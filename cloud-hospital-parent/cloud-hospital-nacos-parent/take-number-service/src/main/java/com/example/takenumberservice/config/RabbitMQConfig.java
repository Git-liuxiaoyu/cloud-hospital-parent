package com.example.takenumberservice.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    //声明叫号交换机
    @Bean("switch")
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange("patient_sort_switch").durable(true).build();
    }

    //声明叫号消息队列
    @Bean("Queue")
    public Queue getQueue(){
        return QueueBuilder.durable("patient_sort").build();
    }


    //绑定叫号队列交换机
    @Bean
    public Binding itemQueueExchange(@Qualifier("Queue") Queue queue
                                    ,@Qualifier("switch") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("patient.send").noargs();
    }


/*===========================================================================================*/


    //声明药房交换机
    @Bean("yfexchange")
    public Exchange tomacyExchange(){
        return ExchangeBuilder.topicExchange("patient_pharmacy_exchange").durable(true).build();
    }

    //声明药房消息队列
    @Bean("yfQueue")
    public Queue getQueuemacy(){
        return QueueBuilder.durable("patient_pharmacy").build();
    }


    //绑定药房队列交换机
    @Bean
    public Binding itemQueuemacyExchange(@Qualifier("yfQueue") Queue queue
            ,@Qualifier("yfexchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("patient.yf").noargs();
    }


    /*===========================================================================================*/


    //声明药房交换机
    @Bean("jcexchange")
    public Exchange toexamineExchange(){
        return ExchangeBuilder.topicExchange("patient_examine_exchange").durable(true).build();
    }

    //声明药房消息队列
    @Bean("jcQueue")
    public Queue getQueueexamine(){
        return QueueBuilder.durable("patient_examine").build();
    }


    //绑定药房队列交换机
    @Bean
    public Binding itemQueueexamineExchange(@Qualifier("jcQueue") Queue queue
            ,@Qualifier("jcexchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("patient.jc").noargs();
    }




}
