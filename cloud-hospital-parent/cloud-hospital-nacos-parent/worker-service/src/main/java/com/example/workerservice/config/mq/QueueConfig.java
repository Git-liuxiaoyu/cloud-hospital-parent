package com.example.workerservice.config.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class QueueConfig {

    @Bean("phone_code_queue")
    public Queue getDlxQueue(){
        return QueueBuilder.durable("phone_code_queue").build();
    }

}
