package com.example.takenumberservice.inlet.mq;

import com.example.takenumberservice.adapter.PharmacyProofDaoAdapter;
import com.example.takenumberservice.adapter.RegisterAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 药房取票的接收消息方
 */
@Component
@Slf4j
public class PharmacyProofConsumer {

    @Autowired
    private PharmacyProofDaoAdapter pharmacyProofDaoAdapter;

    /**
     * 监听某个队列的消息
     * @param no 接收到的消息
     */
    @RabbitListener(queues = "patient_pharmacy")//这个队列为测试的队列
    public void PharmacyProof(String no){
        //删除redis
        //pharmacyProofDaoAdapter.deleteNoRedis(no);
        log.info("接收到的消息为{}",no);

    }

}
