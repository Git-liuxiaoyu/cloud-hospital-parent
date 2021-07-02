package com.example.physicalexamservice.inlet.timer;

import com.example.physicalexamservice.outlet.dao.mysql.MessageMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.MessageMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.MessageMysqlPoExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/30
 */
@Slf4j
@Component
public class ReliableMessageServiceTimer {


    /* 构造注入 - 开始 */
    private final RabbitTemplate rabbitTemplate;
    private final MessageMysqlPoDao messagePoDao;

    public ReliableMessageServiceTimer(RabbitTemplate rabbitTemplate, MessageMysqlPoDao messagePoDao) {
        this.rabbitTemplate = rabbitTemplate;
        this.messagePoDao = messagePoDao;
    }
    /* 构造注入 - 结束 */

    // 发送消息
    public void send(String exchange, String routingKey, String messageContent, String messageId) {
        rabbitTemplate.convertAndSend(exchange, routingKey, messageContent, new CorrelationData(messageId));
    }


    // 定时任务：每隔 3 分钟从数据库中读取未发送的消息发送到 RabbitMQ
    @Scheduled(fixedDelay = 6000)
    private void autoSend() {
        /* 实例化 */
        MessageMysqlPoExample messagePoExample = new MessageMysqlPoExample();
        /* 创造条件 */
        messagePoExample.createCriteria().andStatusEqualTo(MessageMysqlPo.NOT_SEND);

        List<MessageMysqlPo> messageList = messagePoDao.selectByExample(messagePoExample);

        log.debug("执行定时任务。查询出有 {} 条待发送消息。", messageList.size());

        /* 循环消息 */
        for (MessageMysqlPo messagePo : messageList) {
            /* 发送消息 */
            log.debug("待发送消息 : id-{}", messagePo.getId());
            /* 发送消息 */
            rabbitTemplate.convertAndSend(messagePo.getExchange(), messagePo.getRoutingKey(), messagePo.getMessageContent(), new CorrelationData(String.valueOf(messagePo.getId())));
            /* 实例化 MessagePoExample */
            MessageMysqlPoExample example = new MessageMysqlPoExample();
            /* 创造条件 */
            example.createCriteria().andVersionEqualTo(messagePo.getVersion()).andIdEqualTo(messagePo.getId());
            /* 赋值 */
            messagePo.setVersion(messagePo.getVersion() + 1);
            messagePo.setRetryCount(messagePo.getRetryCount() - 1);
            /* 减少重试次数 */
            messagePoDao.updateByExampleSelective(messagePo, example);
        }

    }

}
