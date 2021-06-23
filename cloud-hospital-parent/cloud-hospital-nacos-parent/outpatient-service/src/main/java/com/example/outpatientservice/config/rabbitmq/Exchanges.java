package com.example.outpatientservice.config.rabbitmq;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Exchanges {

    /**
     * 过号交换机
     *
     * @return
     */
//    @Bean("outpatient_losenumber_exchange")
//    public Exchange registerOrderExchange() {
//        return ExchangeBuilder.topicExchange("outpatient_losenumber_exchange").durable(true).build();
//    }

    /*
    就诊完交换机
     */
    @Bean("outpatient_over_exchange")
    public Exchange outPatientOverExchange() {
        return ExchangeBuilder.topicExchange("outpatient_over_exchange").durable(true).build();
    }

}
