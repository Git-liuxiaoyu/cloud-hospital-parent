package com.example.physicalexamservice.config.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Configuration
public class QueuesConfig {

    @Bean("physical_exam_type_cache_q")
    public Queue getPhysicalExamTypeCacheQueue() {
        return new Queue("physical_exam_type_cache_q", true, false, false);
    }

    @Bean("PhysicalExamRecordEsQ")
    public Queue getPhysicalExamRecordEsQueue() {
        return new Queue("physical_exam_record_es_q", true, false, false);
    }

    @Bean("PhysicalExamRecordDetailEsQ")
    public Queue getPhysicalExamRecordDetailEsQueue() {
        return new Queue("physical_exam_record_detail_es_q", true, false, false);
    }

    @Bean("PhysicalExamRedisCacheQ")
    public Queue getPhysicalExamRedisCacheQueue() {
        return new Queue("physical_exam_redis_cache_q", true, false, false);
    }

    @Bean("PhysicalExamRecordIsPayDeadQ")
    public Queue getPhysicalExamRecordIsPayDeadQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", "physical_exam_record_is_pay_real_ex");   // 指定时期后消息投递给哪个交换器。
        args.put("x-dead-letter-routing-key", "physical.exam.record.is.pay.real");  // 指定到期后投递消息时以哪个路由键进行投递。
        args.put("x-message-ttl", 30000);                            // 指定到期时间。5 秒
        return new Queue("physical_exam_record_is_pay_dead_q", true, false, false, args);
    }

    @Bean("PhysicalExamRecordIsPayRealQ")
    public Queue getPhysicalExamRecordIsPayRealQueue() {
        return new Queue("physical_exam_record_is_pay_real_q", true, false, false);
    }

    @Bean("PhysicalExamEsQ")
    public Queue getPhysicalExamEsQueue() {
        return new Queue("physical_exam_es_q", true, false, false);
    }

    @Bean("PhysicalExamRecordRedisCacheQ")
    public Queue getPhysicalExamRecordRedisCacheQ() {
        return new Queue("physical_exam_record_redis_cache_q", true, false, false);
    }

    @Bean("PhysicalExamRecordDetailRedisCacheQ")
    public Queue getPhysicalExamRecordDetailRedisCacheQ() {
        return new Queue("physical_exam_record_detail_redis_cache_q", true, false, false);
    }

}
