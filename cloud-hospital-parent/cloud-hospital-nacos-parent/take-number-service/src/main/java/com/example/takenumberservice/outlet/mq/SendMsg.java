package com.example.takenumberservice.outlet.mq;


import com.example.takenumberservice.outlet.mq.pojo.MqPo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送消息
 */
@Component
public class SendMsg {

    @Autowired
    private RabbitTemplate rabbitTemplate;




    public void SendPatient(MqPo po){
        /**
         * 1：排队序号
         * 2：患者id
         * 3：挂号id
         * 4：医生id
         * 5：医生姓名
         */
        String msg = po.getOrderNum()+","+po.getPatientId()+","+po.getRegId()+","+po.getDoctorId()+","+po.getDoctorName();
        //发送消息到消息队列
        rabbitTemplate.convertAndSend("patient_sort_switch","patient.send",msg);

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


}
