package com.example.outpatientservice.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Queues {

    //过号队列
//    @Bean("outpatient_losenumber_queue")
//    public Queue getDlxQueue() {
//        return QueueBuilder.durable("outpatient_losenumber_queue").build();
//    }

    //过号队列
    @Bean("outpatient_over_queue")
    public Queue outPatientOverQueue() {
        return QueueBuilder.durable("outpatient_over_queue").build();
    }

}
