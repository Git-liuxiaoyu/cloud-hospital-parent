package com.example.physicalexamservice.config.mq;

import com.example.physicalexamservice.outlet.dao.mysql.MessageMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.MessageMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.MessageMysqlPoExample;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
@Slf4j
public class RabbitMQConfig {

    /* 构造注入 - 开始 */
    private final MessageMysqlPoDao messagePoDao;

    public RabbitMQConfig(MessageMysqlPoDao messagePoDao) {
        this.messagePoDao = messagePoDao;
    }
    /* 构造注入 - 结束 */

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);

        // 设置开启 Mandatory，才能触发回调函数，无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        // 关键就是以下两句
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            /* 获得 msgID */
            long msgId = Long.parseLong(correlationData.getId());
            MessageMysqlPo messagePo = messagePoDao.selectByPrimaryKey(msgId);
            /* 判断MessagePo是否存在 */
            if (messagePo == null) {
                log.error("没有找到主键ID [{}] 的消息表数据库信息", msgId);
                return;
            }
            /* 实例化 */
            MessageMysqlPoExample messagePoExample = new MessageMysqlPoExample();
            /* 编写条件 Version 和 Id 相等 */
            messagePoExample.createCriteria().andIdEqualTo(msgId).andVersionEqualTo(messagePo.getVersion());
            // 这里的 correlationData 来源于 convertAndSend 方法。
            log.debug("消息唯一标识 ： {}", correlationData);
            if (ack) {
                log.debug("消息已发送至 RabbitMQ（的Exchange），修改 id 为 {} 的状态。", correlationData.getId());
                /* 填值 */
                messagePo.setVersion(messagePo.getVersion() + 1);
                messagePo.setStatus(MessageMysqlPo.SEND_TO_EX_SUCCESS); /* 切换状态 */
            } else {
                /* 没有重试次数 */
                if (messagePo.getRetryCount() <= 0) {
                    log.debug("消息未能发送到 Exchange。失败原因 {} , 并且不再重新发送", cause);
                    /* 填值 */
                    messagePo.setVersion(messagePo.getVersion() + 1);
                    messagePo.setStatus(MessageMysqlPo.SEND_TO_EX_FAIL); /* 切换状态 */
                    /* 调用方法更新 */
                    messagePoDao.updateByExampleSelective(messagePo, messagePoExample);
                } else {
                    log.debug("消息未能发送到 Exchange。失败原因 {} , 等待下一次发送", cause);
                }
            }
        });

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /**
             * 该方法在 Queue 无法收到消息时被触发执行。Queue 能收到消息，反而不会执行。
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.debug("Routing key {}", routingKey);
                /* 获得MsgId */
                long msgId = Long.parseLong(message.getMessageProperties().getCorrelationId());
                MessageMysqlPo messagePo = messagePoDao.selectByPrimaryKey(msgId);
                /* 判断MessagePo是否存在 */
                if (messagePo == null) {
                    log.error("没有找到主键ID [{}] 的消息表数据库信息", msgId);
                    return;
                }
                /* 实例化 */
                MessageMysqlPoExample messagePoExample = new MessageMysqlPoExample();
                /* 编写条件 Version 和 Id 相等 */
                messagePoExample.createCriteria().andIdEqualTo(msgId).andVersionEqualTo(messagePo.getVersion());
                /* 没有重试次数 */
                if (messagePo.getRetryCount() <= 0) {
                    log.debug("消息未能发送到 Queue , 并且不再重新发送");
                    /* 填值 */
                    messagePo.setVersion(messagePo.getVersion() + 1);
                    messagePo.setStatus(MessageMysqlPo.SEND_TO_Q_FAIL); /* 切换状态 */
                    /* 调用方法更新 */
                    messagePoDao.updateByExampleSelective(messagePo, messagePoExample);
                } else {
                    log.debug("消息未能发送到 Exchange , 等待下一次发送");
                }
            }
        });

        /* 返回 */
        return rabbitTemplate;
    }

    public static void basicRejectQuietly(Channel channel, long deliveryTag, boolean requeue) {
        try {
            channel.basicReject(deliveryTag, requeue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void basicAckQuietly(Channel channel, long deliveryTag, boolean multiple) {
        try {
            channel.basicAck(deliveryTag, multiple);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
