package com.example.physicalexamservice.config.mq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类 - RabbitMQ - 交换机
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Configuration
public class ExchangesConfig {

    @Bean("physical_exam_type_cache_exchange")
    public DirectExchange getPhysicalExamTypeCacheExchange(){
        return new DirectExchange("physical_exam_type_cache_ex",true,false);
    }

}
