package com.example.drugservice.adapt;

import com.example.drugservice.adapt.Exception.DrugOddIsNullException;
import com.example.drugservice.adapt.Exception.DrugOddNotFoundException;
import com.example.drugservice.adapt.converter.DrugOddVoConverter;
import com.example.drugservice.adapt.converter.DrugVoConverter;
import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.outlet.dao.mysql.*;
import com.example.drugservice.outlet.dao.mysql.po.DrugOddDetailPo;
import com.example.drugservice.outlet.dao.mysql.po.DrugOddPo;
import com.example.drugservice.outlet.dao.mysql.po.DrugPo;
import com.example.drugservice.outlet.dao.mysql.po.MessagePo;
import com.example.drugservice.outlet.dao.redis.DrugOddRedisDao;
import com.example.drugservice.outlet.dao.redis.po.DrugOddRedisPo;
import com.example.drugservice.service.add.AddDrugOddCommand;
import com.example.drugservice.service.add.AddDrugOddDetailCommand;
import com.example.drugservice.service.instock.InStockDrugCommand;
import com.example.drugservice.service.query.ExampleQueryDrugCommand;
import com.example.drugservice.service.query.ExampleQueryDrugOddCommand;
import com.example.drugservice.service.update.UpdateDrugOddCommand;
import com.example.drugservice.util.DistributedLock;
import com.example.drugservice.util.NoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class DrugOddAdapt {
    @Autowired
    private DrugOddDao drugOddDao;

    @Autowired
    private DrugOddVoConverter converter;

    @Autowired
    private DrugOddRedisDao redisDao;

    @Autowired
    private DrugOddDetailDao drugOddDetailDao;

    @Autowired
    private DrugDao drugDao;

    @Autowired
    private MessageDao messageMysqlDao;

    //条件查询集合
    public List<DrugOddVo> findDrugListByExample( ExampleQueryDrugOddCommand command){

        DrugOddPo  po = new DrugOddPo();
        //command转换为po
        BeanUtils.copyProperties(command,po);
        List<DrugOddPo> drugOddPos = drugOddDao.selectByCon(po);

        //新建一个vo集合
        List<DrugOddVo> voList = new ArrayList<>();
        for (DrugOddPo po1 : drugOddPos) {
            DrugOddVo vo = new DrugOddVo();
            //po转换为vo
            BeanUtils.copyProperties(po1,vo);
            voList.add(vo);
        }

        return voList;
    }

    //修改药单状态
    public void updateDrugById(UpdateDrugOddCommand command){
        DrugOddPo po = new DrugOddPo();
        po.setId(command.getId());
        po.setStatus("2");
        //动态修改
        drugOddDao.updateByPrimaryKeySelective(po);

        //发消息
        MessagePo message = new MessagePo();
        message.setExchange("amq.direct");
        message.setRoutingKey("zhang.created");
        message.setMessageContent(command.getId().toString());
        message.setStatus(MessagePo.UN_SEND);
        message.setRetryCount(5);
        message.setVersion(0L);
        messageMysqlDao.insert(message);
        //删除redis 缓存
//        redisDao.deleteById(command.getId());
//        log.info("已删除Redis里药品表单编号为[{}]的数据",command.getId());
    }

    //添加药品表单
    public Long addDrugOdd(AddDrugOddCommand command){
        DrugOddPo po  = new DrugOddPo();
        po.setNo(NoUtils.getNoUtils());
        po.setCreatetime(new Date());
        po.setDoctorid(command.getDoctorid());
        po.setPatientid(command.getPatientid());
        po.setOutPatientRecordId(command.getOutPatientRecordId());
        //未支付状态
        po.setStatus("0");
        drugOddDao.insert(po);
        //主键回填id
        Long drugOddId = po.getId();
        log.info("回显id为{}",drugOddId);

        //把药品详细信息 和回填的药品表单id  添加到药品详情里面
        List<AddDrugOddDetailCommand> detailCommands = command.getDetailCommands();
        for (AddDrugOddDetailCommand detailCommand : detailCommands) {
            DrugOddDetailPo detailPo = new DrugOddDetailPo();
            detailPo.setDrugoddid(drugOddId);
            detailPo.setDrugnum(detailCommand.getDrugNum().longValue());
            detailPo.setDrugid(detailCommand.getDrugId().intValue());
            drugOddDetailDao.insert(detailPo);
        }

        //先查库存 如果库存大于购买数量就减少药品库存
        /*循环获取药品详情里购买药的信息*/
        /*修改成功后 使用死信队列*/
        /*修改库存使用分布式锁*/
        DistributedLock lock = new DistributedLock("hello","world",5, TimeUnit.SECONDS);
       //尝试获得这个锁,如果被别人持有,后面十秒内反复尝试获得锁,每隔0.1秒试一次
        if(lock.lock(10*1000,100)){
            log.info("成功获得锁");
            //执行业务逻辑
            for (AddDrugOddDetailCommand detailCommand : detailCommands) {
                DrugPo po1 = drugDao.selectByPrimaryKey(detailCommand.getDrugId());
                if (po1.getStock()>=detailCommand.getDrugNum()){
                    log.info("库存大于或等于购买数量 可以执行减少库存操作");
                    po1.setStock(po1.getStock()-detailCommand.getDrugNum());
                    drugDao.updateByPrimaryKeySelective(po1);
                }else {
                    log.info("库存小于购买数量 无法执行减少库存操作 库存不足");
                }
            }
            //释放锁
            lock.unlock();
        }else {
            log.info("获得锁失败,业务逻辑没有执行");
        }

        return drugOddId;
    }

    //根据编号查询
    public DrugOddVo getByNo(String no){
        DrugOddVo vo=new DrugOddVo();
        try{
            //先查redis
            DrugOddRedisPo redisPo = redisDao.getAllByNo(no);
            log.info("从redis中读取药品单编号{}的数据",no);
             vo = converter.convert(redisPo);
        }catch (Exception e){
                //查Mysql
                DrugOddPo po=  drugOddDao.selectByNo(no);
                log.info("从Mysql中读取药品单编号{}的数据",no);
                if (po!=null){
                    BeanUtils.copyProperties(po,vo);

                    //同步数据 存入Redis
                    DrugOddRedisPo redisPo = new DrugOddRedisPo();
                    BeanUtils.copyProperties(po,redisPo);
                    redisDao.save(redisPo);
                    log.info("存入Redis读取药品单编号{}的数据",redisPo.getNo());
                }else {
                    log.info("Mysql不存在这个编号[{}]",no);
                }
        }
      return vo;
    }
        /*根据药品单id查询药品单状态 30分钟内是否付款 没付款就把库存退回 并且把药品单状态改为付款超时*/
    public void updateById(Long drugOddId){
        DrugOddPo drugOddPo = drugOddDao.selectByPrimaryKey(drugOddId);

        //如果为付款  就退回库存 0表示 未付款
        if (drugOddPo.getStatus().equals("0")){
            log.info("进入未付款操作");
            //根据药品单Id 查询药品详情
            List<DrugOddDetailPo> drugOddDetailPos = drugOddDetailDao.selectByDrugoddId(drugOddId);
            for (DrugOddDetailPo drugOddDetailPo : drugOddDetailPos) {
                //根据详情表的药品id查询药品
                DrugPo drugPo = drugDao.selectByPrimaryKey(drugOddDetailPo.getDrugid().longValue());
                //把详情表的药品数量 退给药品库存
                drugPo.setStock(drugPo.getStock()+drugOddDetailPo.getDrugnum().intValue());
                drugDao.updateByPrimaryKeySelective(drugPo);
                log.info("成功退回id为[{}]的库存",drugPo.getId());
            }
            //把药品单状态改为4 表示付款超时
            drugOddPo.setStatus("4");
            drugOddDao.updateByPrimaryKeySelective(drugOddPo);
            log.info("超时为付款状态修改成功 超时付款状态为[{}]",drugOddPo.getStatus());
        }
    }



}
