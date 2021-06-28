package com.example.registerservice.config.RabbitMQ;

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


    /**
     * 验证码的交换机和队列绑定
     *
     * @param exchange
     * @param queue
     * @return
     */
    @Bean
    public Binding itemQueueExchange(
            @Qualifier("code_exchange") Exchange exchange,
            @Qualifier("phone_code_queue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("phone.add").noargs();
    }

    /**
     * 挂号的交换机和队列绑定
     *
     * @param exchange
     * @param queue
     * @return
     */
    @Bean
    public Binding registerOrderQueueExchange(
            @Qualifier("register_order_exchange") Exchange exchange,
            @Qualifier("register_order_queue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("order.add").noargs();
    }

    /**
     * 挂号死信的交换机和队列绑定
     *
     * @param exchange
     * @param queue
     * @return
     */
    @Bean
    public Binding registerOrderDle(
            @Qualifier("register_order_dl_exchange") Exchange exchange,
            @Qualifier("register_order_dlq") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("dl.order.add").noargs();
    }

    /**
     * 消息一致性的队列和消息一致性交换机的绑定
     *
     * @param exchange
     * @param queue
     * @return
     */
    @Bean
    public Binding newsQueueExchange(
            @Qualifier("news_exchange") Exchange exchange,
            @Qualifier("news_queue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("news.add").noargs();
    }
}
