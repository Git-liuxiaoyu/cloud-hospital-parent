package com.example.physicalexamservice.config.mq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类 - RabbitMQ - Bindings
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Configuration
public class BindingsConfig {


    @Bean
    public Binding getTeacherCacheQToTeacherCacheExBinding(@Qualifier("physical_exam_type_cache_q") Queue queue, @Qualifier("physical_exam_type_cache_exchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("physical.exam.type.cache");
    }

    @Bean
    public Binding getPhysicalExamRecordEsQAndExBinding(
            @Qualifier("PhysicalExamRecordEsDirectEx") Exchange exchange,
            @Qualifier("PhysicalExamRecordEsQ") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("physical.exam.record.es").noargs();
    }

    @Bean
    public Binding getPhysicalExamRecordDetailQAndExBinding(
            @Qualifier("PhysicalExamRecordDetailEsDirectEx") Exchange exchange,
            @Qualifier("PhysicalExamRecordDetailEsQ") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("physical.exam.record.detail.es").noargs();
    }

    @Bean
    public Binding getPhysicalExamRecordIsPayDeadQAndDeadExBinding(
            @Qualifier("PhysicalExamRecordIsPayDeadDirectEx") Exchange exchange,
            @Qualifier("PhysicalExamRecordIsPayDeadQ") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("physical.exam.record.is.pay.dead").noargs();
    }

    @Bean
    public Binding getPhysicalExamRecordIsPayRealQAndRealExBinding(
            @Qualifier("PhysicalExamRecordIsPayRealDirectEx") Exchange exchange,
            @Qualifier("PhysicalExamRecordIsPayRealQ") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("physical.exam.record.is.pay.real").noargs();
    }

    @Bean
    public Binding getPhysicalExamEsQAndExBinding(
            @Qualifier("PhysicalExamEsDirectEx") Exchange exchange,
            @Qualifier("PhysicalExamEsQ") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("physical.exam.es").noargs();
    }

    @Bean
    public Binding getPhysicalExamRecordRedisCacheQAndExBinding(
            @Qualifier("PhysicalExamRecordRedisCacheDirectEx") Exchange exchange,
            @Qualifier("PhysicalExamRecordRedisCacheQ") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("physical.exam.record.redis.cache").noargs();
    }

    @Bean
    public Binding getPhysicalExamRecordDetailRedisCacheQAndExBinding(
            @Qualifier("PhysicalExamRecordDetailRedisCacheDirectEx") Exchange exchange,
            @Qualifier("PhysicalExamRecordDetailRedisCacheQ") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("physical.exam.record.detail.redis.cache").noargs();
    }

}
