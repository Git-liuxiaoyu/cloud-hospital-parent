package com.example.registerservice.outlet.publisher;

import com.example.registerservice.outlet.publisher.api.IPackIdEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/25/19:53
 * @Description:
 */
@Slf4j
@Component
public class PackIdEventPublisher implements IPackIdEventPublisher {

    @Autowired
    private RabbitTemplate template;

    @Override
    @EventListener(PackIdCommandCompletedEvent.class)
    public void publish(PackIdCommandCompletedEvent event) {
        /*获取id*/
        String id = (String) event.getSource();
        template.convertAndSend("news_exchange", "news.add", id);
        log.debug("向news_exchange路由发送了消息,请注意！", event.getSource());
    }
}
