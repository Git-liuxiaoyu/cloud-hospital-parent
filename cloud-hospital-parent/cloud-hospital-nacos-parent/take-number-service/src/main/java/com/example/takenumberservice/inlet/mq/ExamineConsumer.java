package com.example.takenumberservice.inlet.mq;

import com.example.takenumberservice.adapter.RegisterAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 检查取票接收消息
 */
@Component
@Slf4j
public class ExamineConsumer {

    @Autowired
    private RegisterAdapter registerAdapter;//合并后需修改称检查取票的适配器

    /**
     * 监听某个队列的消息
     * @param no 接收到的消息
     */
    @RabbitListener(queues = "patient_examine")//这个队列为测试的队列
    public void examineProof(String no){
        //删除redis
        registerAdapter.deleteNoRedis(no);
        log.info("接收到的消息为{}",no);

    }
}
