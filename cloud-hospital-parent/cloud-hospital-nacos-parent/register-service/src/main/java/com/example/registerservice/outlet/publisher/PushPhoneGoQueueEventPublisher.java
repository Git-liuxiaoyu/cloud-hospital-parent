package com.example.registerservice.outlet.publisher;

import com.example.registerservice.outlet.publisher.api.IPushPhoneGoQueueEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/10:48
 * @Description: 给队列发送手机号消息的实现类
 */
@Slf4j
@Component
public class PushPhoneGoQueueEventPublisher implements IPushPhoneGoQueueEventPublisher {

    @Autowired
    private RabbitTemplate template;

    @Override
    @EventListener(PushPhoneGoQueueCommandCompletedEvent.class)
    public void publish(PushPhoneGoQueueCommandCompletedEvent event) {
        log.debug("phone_code_queue路由发送了手机号为:{}！请短信微服务注意。", event.getSource());
        String msg = "Login-" + event.getSource();//登录验证码，前缀为Login
        template.convertAndSend("code_exchange", "phone.add", msg);
    }
}
