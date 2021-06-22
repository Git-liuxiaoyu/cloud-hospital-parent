package com.example.registerservice.inlet.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/20:56
 * @Description: 监听死信队列
 */
@Component
@RabbitListener(queues = "register_order_dlq")
@Slf4j
public class VerifyNoSubscriber {

    @RabbitHandler
    public void process(String message) {
        log.info("死信队列拿到挂号No为{}", message);
    }
}
