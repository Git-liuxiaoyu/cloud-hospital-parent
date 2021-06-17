package com.example.registerservice.config.RabbitMQ;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/03/15:49
 * @Description: 交换机声名类
 */
@Configuration
public class Exchanges {

    @Bean("code_exchange")
    public Exchange topicExchange() {
        return ExchangeBuilder.topicExchange("code_exchange").durable(true).build();
    }
}
