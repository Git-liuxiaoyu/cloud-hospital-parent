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

    @Bean("DivisionRedisCacheQ")
    public Queue getDivisionRedisCacheQueue(){
        return new Queue("division_redis_cache_q",true,false,false);
    }

    @Bean("DivisionEsQ")
    public Queue getDivisionEsQueue(){
        return new Queue("division_es_q",true,false,false);
    }

}
