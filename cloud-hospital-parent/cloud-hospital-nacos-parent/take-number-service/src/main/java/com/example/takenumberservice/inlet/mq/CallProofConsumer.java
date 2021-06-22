package com.example.takenumberservice.inlet.mq;

import com.example.takenumberservice.adapter.RegisterAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CallProofConsumer {

    @Autowired
    private RegisterAdapter registerAdapter;

    /**
     * 监听某个队列的消息
     * @param no 接收到的消息
     */
    @RabbitListener(queues = "patient_pharmacy")//这个队列为测试的队列
    public void callProof(String no){
        //删除redis
        registerAdapter.deleteNoRedis(no);
        log.info("接收到的消息为{}",no);

    }
}
