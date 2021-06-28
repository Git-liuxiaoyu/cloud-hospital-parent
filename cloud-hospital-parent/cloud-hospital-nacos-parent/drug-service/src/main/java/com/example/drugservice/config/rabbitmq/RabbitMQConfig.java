package com.example.drugservice.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    public static final String first_exchange_name = "first-exchange";
    public static final String second_exchange_name = "second-exchange";

    public static final String first_routing_key = "first-routing-key";
    public static final String second_routing_key = "second-routing-key";

    public static final String first_binding = "first-binding";
    public static final String second_binding = "second-binding";

    public static final String dead_queue_name = "dead-queue";
    public static final String real_queue_name = "real-queue";

    @Bean("dead-queue")
    public Queue deadQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", second_exchange_name);   // 指定时期后消息投递给哪个交换器。
        args.put("x-dead-letter-routing-key", second_routing_key);  // 指定到期后投递消息时以哪个路由键进行投递。
        args.put("x-message-ttl", 10000);                            // 指定到期时间。5 秒
        return new Queue(dead_queue_name, true, false, false, args);
    }

    @Bean("real-queue")
    public Queue realQueue() {
        return new Queue(real_queue_name, true, false, false);
    }


    @Bean(first_exchange_name)
    public TopicExchange firstExchange() {
        return new TopicExchange(first_exchange_name, true, false);
    }

    @Bean(first_binding)
    public Binding firstBinding(@Qualifier(dead_queue_name) Queue queue,
                                @Qualifier(first_exchange_name) Exchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(first_routing_key)
                .noargs();
    }

    /* 问题二：延迟队列凭什么会把消息再转给 real-queue 。*/
    @Bean(second_exchange_name)
    public TopicExchange secondExchange() {
        return new TopicExchange(second_exchange_name, true, false);
    }

    @Bean(second_binding)
    public Binding secondBiding(@Qualifier(real_queue_name) Queue queue,
                                @Qualifier(second_exchange_name) Exchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(second_routing_key)
                .noargs();
    }
}

