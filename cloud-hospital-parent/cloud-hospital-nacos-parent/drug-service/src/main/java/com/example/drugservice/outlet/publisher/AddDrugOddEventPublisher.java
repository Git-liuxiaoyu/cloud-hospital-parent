package com.example.drugservice.outlet.publisher;

import com.example.drugservice.outlet.publisher.api.IAddDrugOddEventPublisher;
import com.example.drugservice.outlet.publisher.po.AddDrugOddCommandEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddDrugOddEventPublisher implements IAddDrugOddEventPublisher {

    @Autowired
    private RabbitTemplate template;

    // 添加完新的药品表单之后，在消息的接收者这里做后续操作，例如：数据同步等
    @Override
    @EventListener(AddDrugOddCommandEvent.class)
    public void publish(AddDrugOddCommandEvent event) {
        log.debug("广而告之：药品表单[{}]成立了！请各单位注意。", event.getSource());
        template.convertAndSend("first-exchange","first-routing-key",event.getSource());

    }
}
