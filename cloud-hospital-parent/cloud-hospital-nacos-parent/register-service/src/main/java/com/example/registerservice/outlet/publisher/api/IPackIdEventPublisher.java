package com.example.registerservice.outlet.publisher.api;

import com.example.registerservice.outlet.publisher.PackIdEventPublisher;
import org.springframework.context.ApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/25/19:53
 * @Description: 将id发送给队列
 */
public interface IPackIdEventPublisher {
    public void publish(PackIdCommandCompletedEvent event);

    public static class PackIdCommandCompletedEvent extends ApplicationEvent {

        private Long id;

        public PackIdCommandCompletedEvent(Long id) {
            super(id);
            this.id=id;
        }

    }
}
