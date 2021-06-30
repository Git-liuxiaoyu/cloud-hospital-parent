package com.example.workerservice.config.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 绑定配置
 * <p>
 * 交换机 - 队列 - 绑定
 */
@Configuration
public class BindingConfig {

    @Bean
    public Binding itemQueueExchange(
            @Qualifier("code_exchange") Exchange exchange,
            @Qualifier("phone_code_queue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("phone.add").noargs();
    }

    @Bean
    public Binding getDivisionRedisCacheQAndExBinding(
            @Qualifier("DivisionRedisCacheEx") Exchange exchange,
            @Qualifier("DivisionRedisCacheQ") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("division.redis.cache").noargs();
    }

    @Bean
    public Binding getDivisionEsQAndExBinding(
            @Qualifier("DivisionEsEx") Exchange exchange,
            @Qualifier("DivisionEsQ") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("division.es").noargs();
    }

}
