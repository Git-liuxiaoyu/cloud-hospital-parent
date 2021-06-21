//package com.example.outpatientservice.config.rabbitmq;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Exchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class BindConfig {
//
//    @Bean
//    public Binding binding(
//            @Qualifier("queue_department_created")Queue queue,
//            @Qualifier("exchange_department_created")Exchange exchange
//    ){
//        return BindingBuilder.bind(queue)
//                .to(exchange)
//                .with("department.created")
//                .noargs();
//    }
//
//
//    @Bean
//    public Binding binding2(
//            @Qualifier("queue_department_delete")Queue queue,
//            @Qualifier("exchange_department_delete")Exchange exchange
//    ){
//        return BindingBuilder.bind(queue)
//                            .to(exchange)
//                            .with("department.delete")
//                            .noargs();
//    }
//}
