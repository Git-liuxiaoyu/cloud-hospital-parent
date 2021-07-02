package com.example.physicalexamservice.config.mq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类 - RabbitMQ - 交换机
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Configuration
public class ExchangesConfig {

    @Bean("physical_exam_type_cache_exchange")
    public DirectExchange getPhysicalExamTypeCacheExchange() {
        return new DirectExchange("physical_exam_type_cache_ex", true, false);
    }

    @Bean("PhysicalExamRecordEsDirectEx")
    public DirectExchange getPhysicalExamRecordEsDirectExchange() {
        return new DirectExchange("physical_exam_record_es_ex", true, false);
    }

    @Bean("PhysicalExamRecordDetailEsDirectEx")
    public DirectExchange getPhysicalExamRecordDetailEsDirectExchange() {
        return new DirectExchange("physical_exam_record_detail_es_ex", true, false);
    }

    @Bean("PhysicalExamRedisCacheDirectEx")
    public DirectExchange getPhysicalExamRedisCacheDirectExchange() {
        return new DirectExchange("physical_exam_redis_cache_ex", true, false);
    }

    @Bean("PhysicalExamRecordIsPayDeadDirectEx")
    public DirectExchange getPhysicalExamRecordIsPayDeadExchange() {
        return new DirectExchange("physical_exam_record_is_pay_dead_ex", true, false);
    }

    @Bean("PhysicalExamRecordIsPayRealDirectEx")
    public DirectExchange getPhysicalExamRecordIsPayRealExchange() {
        return new DirectExchange("physical_exam_record_is_pay_real_ex", true, false);
    }

    @Bean("PhysicalExamEsDirectEx")
    public DirectExchange getPhysicalExamEsDirectExchange() {
        return new DirectExchange("physical_exam_es_ex", true, false);
    }

    @Bean("PhysicalExamRecordRedisCacheDirectEx")
    public DirectExchange getPhysicalExamRecordRedisCacheDirectExchange() {
        return new DirectExchange("physical_exam_record_redis_cache_ex", true, false);
    }

    @Bean("PhysicalExamRecordDetailRedisCacheDirectEx")
    public DirectExchange getPhysicalExamRecordDetailRedisCacheDirectExchange() {
        return new DirectExchange("physical_exam_record_detail_redis_cache_ex", true, false);
    }

}
