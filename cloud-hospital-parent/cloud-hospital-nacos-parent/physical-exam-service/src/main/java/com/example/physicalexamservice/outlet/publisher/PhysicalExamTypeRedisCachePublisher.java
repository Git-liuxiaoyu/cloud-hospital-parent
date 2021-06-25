package com.example.physicalexamservice.outlet.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * Publisher - RedisCache -
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Component
@Slf4j
public class PhysicalExamTypeRedisCachePublisher {


    /* 构造注入 — START */
    private final RabbitTemplate rabbitTemplate;

    public PhysicalExamTypeRedisCachePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    /* 构造注入 - END */

    public void publishPhysicalExamTypeDelete(Integer id) {
        /* 发送到RabbitMQ */
        String message = "delete-" + id;
        rabbitTemplate.convertAndSend("physical_exam_type_cache_ex", "physical.exam.type.cache", message);
    }

    public void publishPhysicalExamTypeAllDelete() {
        /* 发送到RabbitMQ */
        String message = "deleteAll-";
        rabbitTemplate.convertAndSend("physical_exam_type_cache_ex", "physical.exam.type.cache", message);
    }

    public void publishPhysicalExamTypeUpdateDelete(Integer id) {
        /* 发送到RabbitMQ */
        String message = "update-" + id;
        rabbitTemplate.convertAndSend("physical_exam_type_cache_ex", "physical.exam.type.cache", message);
    }

    public void publishPhysicalExamTypeAllUpdateDelete(String status) {
        /* 发送到RabbitMQ */
        String message = "updateAll-" + status;
        rabbitTemplate.convertAndSend("physical_exam_type_cache_ex", "physical.exam.type.cache", message);
    }

}
