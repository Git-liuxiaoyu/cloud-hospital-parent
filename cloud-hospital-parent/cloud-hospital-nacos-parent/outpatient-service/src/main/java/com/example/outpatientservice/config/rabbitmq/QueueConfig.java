//package com.example.outpatientservice.config.rabbitmq;
//
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.QueueBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class QueueConfig {
//
//    @Bean("queue_department_created")
//    public Queue queue(){
//        return QueueBuilder.durable("queue_department_created").build();
//        //return  new Queue("department-created.zz");
//    }
//
//    @Bean("queue_department_delete")
//    public Queue queue2(){
//        return QueueBuilder.durable("queue_department_delete").build();
//
//        //return  new Queue("department-delete.zz");
//    }
//}
