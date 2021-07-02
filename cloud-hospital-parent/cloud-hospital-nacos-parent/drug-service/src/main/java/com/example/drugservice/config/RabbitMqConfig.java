package com.example.drugservice.config;

import com.example.drugservice.outlet.dao.mysql.MessageDao;
import com.example.drugservice.outlet.dao.mysql.po.MessagePo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableRabbit
public class RabbitMqConfig {



    @Autowired
    private  MessageDao messageMysqlDao;

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);

        // 设置开启 Mandatory，才能触发回调函数，无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);


            // 关键就是以下两句
            rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
                // 这里的 correlationData 来源于 convertAndSend 方法。
                System.out.println(correlationData.getId());
                if(correlationData.getId()!=null){
                    log.debug("消息唯一标识 ： {}", correlationData.getId());
                    Long messageId = Long.parseLong(correlationData.getId());
                    MessagePo message = messageMysqlDao.selectByPrimaryKey(messageId);
                    if (ack) {
                        log.info("消息成功发送到 RabbitMQ（的交换机）");
                        message.setStatus(MessagePo.RABBITMQ_RECEIVED);
                    } else {
                        log.info("消息未能成功发送");
                    }

                    message.setRetryCount(message.getRetryCount() -1);
                    if (message.getRetryCount() == 0) {
                        message.setStatus(MessagePo.RETRY_ERROR);
                        log.info("人工干预：结合邮件功能、短信功能，喊人来处理 ...");
                    }

                    messageMysqlDao.updateByPrimaryKey(message);
                }

            });



        return rabbitTemplate;
    }
}
