package com.example.registerservice.config.RabbitMQ;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/03/15:49
 * @Description: 交换机声名类
 */
@Configuration
public class Exchanges {

    /**
     * 验证码交换机
     *
     * @return
     */
    @Bean("code_exchange")
    public Exchange topicExchange() {
        return ExchangeBuilder.topicExchange("code_exchange").durable(true).build();
    }

    /**
     * 挂号订单交换机
     *
     * @return
     */
    @Bean("register_order_exchange")
    public Exchange registerOrderExchange() {
        return ExchangeBuilder.topicExchange("register_order_exchange").durable(true).build();
    }

    /**
     * 挂号订单死信交换机
     *
     * @return
     */
    @Bean("register_order_dl_exchange")
    public Exchange registerOrderDlx() {
        return ExchangeBuilder.topicExchange("register_order_dl_exchange").durable(true).build();
    }
}
