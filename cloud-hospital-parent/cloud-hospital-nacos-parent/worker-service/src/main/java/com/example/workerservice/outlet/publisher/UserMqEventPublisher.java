package com.example.workerservice.outlet.publisher;

import com.example.workerservice.outlet.publisher.api.IUserMqEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 - IUserMqEventPublisher
 */
@Component
@Slf4j
public class UserMqEventPublisher implements IUserMqEventPublisher {

    /* 构造注入 - 开始 */
    private final RabbitTemplate rabbitTemplate;

    public UserMqEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    /* 构造注入 - 结束 */

    /**
     * 发送消息  - 发送验证码消息 - SendVerifyCodeMqEvent
     *
     * @param event
     */
    @Override
    @EventListener
    public void sendMsg(SendVerifyCodeMqEvent event) {
        /* 获得手机号 */
        String phone = (String) event.getSource();

        /* 发送到队列去 */
        rabbitTemplate.convertAndSend("code_exchange","phone.add","PWDUPDATE-"+phone);

        /* LOG */
        log.debug("发送消息 [发送验证码到手机号 {} ]",phone);
    }
}
