package com.example.drugservice.inlet.timer;

import com.example.drugservice.outlet.dao.mysql.MessageDao;
import com.example.drugservice.outlet.dao.mysql.po.MessagePo;
import com.example.drugservice.outlet.dao.mysql.po.MessagePoExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SendMessageTimer {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MessageDao messageMysqlDao;

    @Scheduled(fixedRate = 6000)
    private void process() {

        // 1. 找待发送消息
        MessagePoExample example = new MessagePoExample();
        example.createCriteria()
                .andStatusEqualTo(MessagePo.UN_SEND);
        List<MessagePo> messages = messageMysqlDao.selectByExample(example);
        log.info("本轮有[{}]条待发送消息", messages.size());

        // 2. 【送到】RabbitMQ
        for (MessagePo message : messages) {
            rabbitTemplate.convertAndSend(
                    message.getExchange(),
                    message.getRoutingKey(),
                    message.getId()+":"+message.getMessageContent(),
                    new CorrelationData(message.getId().toString())
            );
        }

    }
}
