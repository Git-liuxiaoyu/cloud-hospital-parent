package com.example.workerservice.config.mq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 交换机配置
 */
@Configuration
public class ExchangeConfig {

    @Bean("code_exchange")
    public Exchange topicExchange() {
        return ExchangeBuilder.topicExchange("code_exchange").durable(true).build();
    }

    @Bean("DivisionRedisCacheEx")
    public DirectExchange getDivisionRedisCacheDirectExchange(){
        return new DirectExchange("division_redis_cache_ex",true,false);
    }

    @Bean("DivisionEsEx")
    public DirectExchange getDivisionEsDirectExchange(){
        return new DirectExchange("division_es_ex",true,false);
    }

}

