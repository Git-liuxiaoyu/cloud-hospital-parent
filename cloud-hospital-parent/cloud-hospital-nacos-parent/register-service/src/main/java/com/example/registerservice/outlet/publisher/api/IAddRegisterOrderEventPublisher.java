package com.example.registerservice.outlet.publisher.api;

import com.example.registerservice.outlet.publisher.AddRegisterOrderEventPublisher;
import org.springframework.context.ApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/19:54
 * @Description: 添加挂号订单的时候给队列发送消息的Publisher接口
 */
public interface IAddRegisterOrderEventPublisher {

    public void publish(AddRegisterOrderCommandCompletedEvent event);

    public static class AddRegisterOrderCommandCompletedEvent extends ApplicationEvent {

        private String no;

        public AddRegisterOrderCommandCompletedEvent(String no) {
            super(no);
            this.no=no;
        }

    }
}
