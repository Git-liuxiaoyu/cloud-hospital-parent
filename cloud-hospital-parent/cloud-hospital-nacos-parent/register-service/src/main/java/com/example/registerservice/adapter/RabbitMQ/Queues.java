package com.example.registerservice.adapter.RabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/03/15:50
 * @Description: 队列声明类
 */
@Configuration
public class Queues {

    @Bean("phone_code_queue")
    public Queue getDlxQueue(){
        return QueueBuilder.durable("phone_code_queue").build();
    }
}
