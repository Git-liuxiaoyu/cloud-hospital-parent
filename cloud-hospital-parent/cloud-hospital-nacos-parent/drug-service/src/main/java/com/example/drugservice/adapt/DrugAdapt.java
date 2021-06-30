package com.example.drugservice.adapt;

import com.example.drugservice.adapt.Exception.DrugNotFoundException;
import com.example.drugservice.adapt.converter.DrugVoConverter;
import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.outlet.dao.es.DrugEsDao;
import com.example.drugservice.outlet.dao.es.po.DrugEsPo;
import com.example.drugservice.outlet.dao.mysql.DrugDao;
import com.example.drugservice.outlet.dao.mysql.po.DrugPo;

import com.example.drugservice.outlet.dao.redis.DrugRedisDao;
import com.example.drugservice.outlet.dao.redis.po.DrugRedisPo;
import com.example.drugservice.service.instock.InStockDrugCommand;
import com.example.drugservice.service.query.ExampleQueryDrugCommand;
import com.example.drugservice.util.NoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class DrugAdapt {
    @Autowired
    private DrugDao drugDao;

    @Autowired
    private DrugVoConverter converter;

    @Autowired
    private DrugEsDao drugEsDao;

    @Autowired
    private DrugRedisDao drugRedisDao;

    //动态查询 分页列表
    public List<DrugVo> findDrugListByExample(ExampleQueryDrugCommand command){
        //查es
        List<DrugEsPo> poList =new ArrayList<>();
        if (command.getNo()!=null){
            poList=drugEsDao.findAllByNo(command.getNo());
        }else if (command.getName()!=null){
            poList= drugEsDao.findAllByName(command.getName());
        }else if (command.getTypeId()!=null){
            poList=drugEsDao.getAllByTypeId(command.getTypeId());
        }
        else {
           poList= drugEsDao.findAll();
        }
        //es po 转换为vo
        List<DrugVo> vos = converter.convert2(poList);

        //drugEsDao.deleteAll();
//        if (poList.size()==0){
//            log.info("走mysql 查询列表");
//
//            DrugPo  po = new DrugPo();
//            BeanUtils.copyProperties(command,po);
//            List<DrugPo> drugPos = drugDao.selectByCon(po);
//            List<DrugVo> drugVos = converter.convert(drugPos);
//
//            //mysql数据转存到es
//            for (DrugPo drugPo : drugPos) {
//                DrugEsPo po1 = new DrugEsPo();
//                po1.setTypeName(drugPo.getDrugtype());
//                po1.setStock(drugPo.getStock());
//                po1.setTypeId(drugPo.getTypeid());
//                System.out.println(drugPo.getId().toString());
//                po1.setId(drugPo.getId().toString());
//                BeanUtils.copyProperties(drugPo,po1);
//                drugEsDao.save(po1);
//            }
//            return drugVos;
//       }
        log.info("走es 查询列表");
        return vos;
    }


    //根据药品名和生产地查询药品   /*查对象*/
    public InStockDrugCommand getDrugByNameAndLocation(String name,String location){
        InStockDrugCommand command=new InStockDrugCommand();
        try {
            //先查redis
            DrugRedisPo drugRedisPo = drugRedisDao
                        .getAllByNameAndLocation(name, location);
            log.info("从Redis中读取药品[{}]的数据",drugRedisPo.getId());

            /*redisPo转换*/
            BeanUtils.copyProperties(drugRedisPo,command);

        }catch (DrugNotFoundException e){
            /*查mysql*/
            DrugPo po1 = drugDao.selectByNameAndByLocation(name, location);
            if (po1==null){
                //返回一个空
                return null;
            }
            log.info("从Mysql中读取药品[{}]的数据",po1.getId());
            BeanUtils.copyProperties(po1,command);
            /*数据同步 存redis*/
            DrugRedisPo redisPo = new DrugRedisPo();
            BeanUtils.copyProperties(po1,redisPo);
            drugRedisDao.save(redisPo);
        }
//        DrugPo po = new DrugPo();
//        po.setName(name);
//        po.setLocation(location);
        return command;
    }

    //添加药品
    public void AddDrug(InStockDrugCommand command){
        //查询最后一个编号然后+1
        DrugPo po1 = drugDao.selectNo();
        int no = Integer.parseInt(po1.getNo());
        System.out.println(no);

        DrugPo po = new DrugPo();
        po.setNo(NoUtils.getNoUtils());
        po.setTypeid(command.getTypeId());
        po.setStock(command.getNum());

        BeanUtils.copyProperties(command,po);
        drugDao.insert(po);

        //同时存入es
        DrugEsPo drugEsPo = new DrugEsPo();
        BeanUtils.copyProperties(po,drugEsPo);
        drugEsDao.save(drugEsPo);
        log.info("添加到Es的药品为[{}]",drugEsPo.getNo());

    }


    //增加药品库存
    public void upDateDrug(InStockDrugCommand command){
        /*修改msql*/
        drugDao.updateByNo(command.getNum(),command.getNo());
        log.info("增加mysql的药品为[{}]的数据",command.getNo());

        /*修改es*/
        DrugEsPo esPo = drugEsDao.getAllByNo(command.getNo());
        esPo.setStock(esPo.getStock()+command.getNum());
        drugEsDao.save(esPo);
        log.info("增加es的药品为[{}]的数据",esPo.getNo());

        /*删除redis*/
        drugRedisDao.deleteByNo(command.getNo());
        log.info("删除Redis的药品为[{}]的数据",command.getNo());
    }

    //减少药品库存
    public void updateDrugReduce(String no,Integer num){
        /*修改Mysql*/
        drugDao.updateByNoReduce(no,num);

        //查出es对象 然后修改
        DrugEsPo esPo = drugEsDao.getAllByNo(no);
        esPo.setStock(esPo.getStock()-num);
        drugEsDao.save(esPo);

        /*删除Redis*/
        drugRedisDao.deleteByNo(no);
        log.info("删除Redis的药品为[{}]的数据",no);
    }
}
