//package com.example.outpatientservice.adapt.listener;
//
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.mybatis.logging.Logger;
//import org.mybatis.logging.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//
//
//@Component
//@RabbitListener(queues = "queue-demo-1")
//@Slf4j
//public class Consumer1 {
//
//
//    @RabbitHandler
//    public void process(String message) {
//        log.info("Consumer 1: {}", message);
//    }
//
//}
