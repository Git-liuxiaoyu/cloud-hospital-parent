package com.example.registerservice.config.RabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/03/15:50
 * @Description: 队列声明类
 */
@Configuration
public class Queues {


    /**
     * 登入验证码队列
     *
     * @return
     */
    @Bean("phone_code_queue")
    public Queue getDlxQueue() {
        return QueueBuilder.durable("phone_code_queue").build();
    }

    /**
     * 挂号订单队列
     *
     * @return
     */
    @Bean("register_order_queue")
    public Queue registerOrderQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", "register_order_dl_exchange");   // 指定时期后消息投递给哪个交换器。
        args.put("x-dead-letter-routing-key", "dl.order.add");  // 指定到期后投递消息时以哪个路由键进行投递。
        args.put("x-message-ttl", 30000);                            // 指定到期时间。5 秒
        return new Queue("register_order_queue", true, false, false, args);                           // 指定到期时间。5 秒
    }

    /**
     * 挂号订单的死信队列
     *
     * @return
     */
    @Bean("register_order_dlq")
    public Queue registerOrderDlq() {
        return QueueBuilder.durable("register_order_dlq").build();
    }
}
