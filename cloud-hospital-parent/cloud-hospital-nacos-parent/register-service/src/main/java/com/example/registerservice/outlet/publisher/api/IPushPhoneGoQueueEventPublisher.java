package com.example.registerservice.outlet.publisher.api;

import org.springframework.context.ApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/10:39
 * @Description: 给队列发送消息的Publisher接口
 */
public interface IPushPhoneGoQueueEventPublisher {

    public void publish(PushPhoneGoQueueCommandCompletedEvent event);

    public static class PushPhoneGoQueueCommandCompletedEvent extends ApplicationEvent {

        private String phone;

        public PushPhoneGoQueueCommandCompletedEvent(String phone) {
            super(phone);
            this.phone = phone;
        }
    }
}
