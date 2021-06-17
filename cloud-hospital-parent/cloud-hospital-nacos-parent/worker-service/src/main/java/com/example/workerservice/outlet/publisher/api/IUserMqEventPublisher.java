package com.example.workerservice.outlet.publisher.api;

import org.springframework.context.ApplicationEvent;

/**
 * 接口 - User RabbitMQ Event Bus 推送
 */
public interface IUserMqEventPublisher {

    void sendMsg(SendVerifyCodeMqEvent event);

    /**
     * 内部类 - MqEvent - SendVerifyCode
     */
    class SendVerifyCodeMqEvent extends ApplicationEvent {
        public SendVerifyCodeMqEvent(String phone) {
            super(phone);
        }
    }

}
