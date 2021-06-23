package com.example.takenumberservice.adapter;

import com.example.takenumberservice.adapter.converter.ExamineConverter;
import com.example.takenumberservice.adapter.converter.ProofConverter;
import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.examine.ExamineClient;
import com.example.takenumberservice.outlet.client.examine.pojo.ExamineVo;
import com.example.takenumberservice.outlet.client.register.pojo.Register;
import com.example.takenumberservice.outlet.dao.mysql.ExamineProofDao;
import com.example.takenumberservice.outlet.dao.mysql.pojo.ExamineProofPo;
import com.example.takenumberservice.outlet.dao.mysql.pojo.ProofPo;
import com.example.takenumberservice.outlet.dao.redis.ExamineProofRedisDao;
import com.example.takenumberservice.outlet.dao.redis.pojo.ExamineProofRedisPo;
import com.example.takenumberservice.outlet.dao.redis.pojo.ProofRedisPo;
import com.example.takenumberservice.outlet.mq.SendMsg;
import com.example.takenumberservice.outlet.mq.pojo.MqPo;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;
import com.example.takenumberservice.service.command.addexamineProof.ExamineProofCommand;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 检查科取票
 */

@Repository
@Slf4j
public class ExaminePeoofDaoAdapter {

    @Autowired
    private ExamineProofDao examineProofDao;

    @Autowired
    private ExamineProofRedisDao examineProofRedisDao;

    @Autowired
    private ExamineConverter examineConverter;

    @Autowired
    private ExamineClient examineClient;

    @Autowired
    private SendMsg sendMsg;

    //查询redis中是否有no
    public boolean findNoRedis(String no) {
        Optional<ExamineProofRedisPo> byId = examineProofRedisDao.findById(no);
        System.out.println("redis中查的"+byId.isPresent());
        if(byId.isPresent()){
            log.info("已查询出redis存在该数据no:{}",byId.get().getNo());
            return true;
        }else {
            return false;
        }
    }

    //把no存入redis
    public void addNoRedis(String no) {
        ExamineProofRedisPo redisPo = new ExamineProofRedisPo(no);
        examineProofRedisDao.save(redisPo);
        log.info("执行保存no功能{}",no);
    }

    //把no从redis删除
    public void deleteNoRedis(String no) {
        ExamineProofRedisPo redisPo = new ExamineProofRedisPo(no);
        examineProofRedisDao.delete(redisPo);
        log.info("执行删除no功能{}",no);
    }


    /**
     * 添加进mysql
     * @return
     */
    public int addProof(ExamineProofCommand examinCommand){
        ExamineProofPo excmtopo = examineConverter.excmtopo(examinCommand);
        int addproof = examineProofDao.addproof(excmtopo);
        return addproof;
    }


    /**
     * 向openfeign发送获取检查信息请求
     * @return
     */

    public ResponseResult<ExamineProofCommand> findbyno(String no) {
        try {
            //ResponseResult<ExamineVo> findbyno = examineClient.findByJCNo(no);


       /*============================测试=================================================*/
            ResponseResult<ExamineVo> findbyno = new ResponseResult<ExamineVo>();
            ExamineVo ev = new ExamineVo();
            ev.setNo("JC0001");
            ev.setType("1");
            findbyno.setData(ev);
            findbyno.setCode(200);
            findbyno.setMsg("ok");
        /*============================测试=================================================*/


            if (findbyno.getCode() != 200) {
                return new ResponseResult<ExamineProofCommand>(400, "未查询到检查单信息，请稍后重试！", null);
            } else {
                ExamineProofCommand votoexcm = examineConverter.votoexcm(findbyno.getData());

                return new ResponseResult<ExamineProofCommand>(200, "ok", votoexcm);
            }
            //return "就诊室";
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<ExamineProofCommand>(400, "未查询到检查单信息，请稍后重试！", null);
        }


    }

    /**
     * 排序查询获得第最大排队序号
     * @return
     */
    public Integer findOrderNum(String type) {
        Integer i = 0;
        try {
            i = examineProofDao.findorderNum(type);
        }catch (Exception e){
            return 0;
        }
        return i;
    }

    /**
     * 给队列发送消息，叫号微服务接受
     */
    public void sendexamine(String no,Integer orderNum){

        sendMsg.SendExamine(no,orderNum);
        log.info("已发送消息{},{}",no,orderNum);
    }




}
