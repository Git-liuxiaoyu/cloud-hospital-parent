package com.example.takenumberservice.outlet.mq;


import com.example.takenumberservice.outlet.dao.mysql.MassageDao;
import com.example.takenumberservice.outlet.dao.mysql.pojo.MassagePo;
import com.example.takenumberservice.outlet.mq.pojo.MqPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 发送消息
 */
@Component
@Slf4j
public class SendMsg {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MassageDao massageDao;



    public void SendPatient(MqPo po){
        /**
         * 1：排队序号
         * 2：患者id
         * 3：挂号id
         * 4：医生id
         * 5：医生姓名
         */
        String msg = po.getOrderNum()+","+po.getPatientId()+","+po.getRegId()+","+po.getDoctorId()+","+po.getDoctorName();
        //存入消息表
        MassagePo msgpo = new MassagePo();
        msgpo.setStatus("0");//未发送
        msgpo.setMessage_content(msg);//消息内容
        msgpo.setVersion(0L);
        msgpo.setRetry_count(6);//重复发送6次，如果一直失败则发送邮件叫人
        msgpo.setExchange("patient_sort_switch");//交换机
        msgpo.setRouting_key("patient.send");
        int i = massageDao.addMassage(msgpo);
        System.out.println("是否存入成功："+i);
        Long id = msgpo.getId();//自动生成的id

        //发送消息到消息队列
        rabbitTemplate.convertAndSend("patient_sort_switch","patient.send",msg,new CorrelationData(id.toString()));

        System.out.println(po.toString());
    }

    /**
     * 发送给药房的消息
     */
    public void Sendpharmacy(Integer orderNo,String No){
        /**
         * 1：排队序号
         * 2：药房取票No
         */
        String msg = orderNo+","+No;

        rabbitTemplate.convertAndSend("patient_pharmacy_exchange","patient.yf",msg);
    }


    /**
     * 发送给检查科的消息
     */
    public void SendExamine(String No,Integer orderNo){
        /**
         * 1：排队序号
         * 2：检查科取票No
         */
        String msg = orderNo+","+No;

        rabbitTemplate.convertAndSend("patient_examine_exchange","patient.jc",msg);
    }








    public void SendRetry(MassagePo msgpo){//消息表重发消息

        //发送消息到消息队列
        rabbitTemplate.convertAndSend(msgpo.getExchange(),msgpo.getRouting_key(),msgpo.getMessage_content(),new CorrelationData(msgpo.getId().toString()));
        log.info("重发送消息的内容{}",msgpo);

    }


}
