//package com.example.outpatientservice.config.rabbitmq;
//
//
//import org.springframework.amqp.core.Exchange;
//import org.springframework.amqp.core.ExchangeBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ExchangeConfig {
//
//    @Bean("exchange_department_created")
//    public Exchange exchange(){
//
//        return ExchangeBuilder.topicExchange("exchange_department_created").durable(true).build();
//        //return  new TopicExchange("amq.topic.zz");
//
//    }
//
//    @Bean("exchange_department_delete")
//    public Exchange exchange2(){
//        return ExchangeBuilder.topicExchange("exchange_department_delete").durable(true).build();
//        //return  new TopicExchange("amq.topic.delete.zz");
//    }
//}
