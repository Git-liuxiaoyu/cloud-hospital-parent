package com.example.takenumberservice.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    //声明交换机
    @Bean("switch")
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange("patient_sort_switch").durable(true).build();
    }

    //声明消息队列
    @Bean("Queue")
    public Queue getQueue(){
        return QueueBuilder.durable("patient_sort").build();
    }


    //绑定正常队列交换机
    @Bean
    public Binding itemQueueExchange(@Qualifier("Queue") Queue queue
                                    ,@Qualifier("switch") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("patient.send").noargs();
    }




}
