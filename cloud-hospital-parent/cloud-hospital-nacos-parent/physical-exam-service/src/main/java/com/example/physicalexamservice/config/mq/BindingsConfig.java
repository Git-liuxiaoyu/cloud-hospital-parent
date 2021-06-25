package com.example.physicalexamservice.config.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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

}
