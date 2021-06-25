package com.example.physicalexamservice.config.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Configuration
public class QueuesConfig {

    @Bean("physical_exam_type_cache_q")
    public Queue getPhysicalExamTypeCacheQueue(){
        return new Queue("physical_exam_type_cache_q",true,false,false);
    }


}
