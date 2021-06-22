package com.example.registerservice.outlet.publisher;

import com.example.registerservice.outlet.publisher.api.IAddRegisterOrderEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/19:55
 * @Description:
 */
@Slf4j
@Component
public class AddRegisterOrderEventPublisher implements IAddRegisterOrderEventPublisher {

    @Autowired
    private RabbitTemplate template;

    @Override
    @EventListener(AddRegisterOrderCommandCompletedEvent.class)
    public void publish(AddRegisterOrderCommandCompletedEvent event) {
        log.debug("向register_order_queue路由发送了挂号订单为:{}！", event.getSource());
        String no = (String) event.getSource();//no为挂号订单号
        template.convertAndSend("register_order_exchange", "order.add", no);
    }
}
