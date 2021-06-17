package com.example.registerservice.adapter.RabbitMQ;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/03/15:52
 * @Description: 交换机和队列绑定类
 */
@Configuration
public class Builder {

    @Bean
    public Binding itemQueueExchange(
            @Qualifier("code_exchange") Exchange exchange,
            @Qualifier("phone_code_queue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("phone.add").noargs();
    }
}
