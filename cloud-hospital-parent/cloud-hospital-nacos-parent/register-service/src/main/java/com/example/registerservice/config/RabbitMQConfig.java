package com.example.registerservice.config;

import com.example.registerservice.outlet.dao.mysql.MessageMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.MessageMysqlPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/26/15:35
 * @Description:
 */
@Configuration
@Slf4j
@Service
public class RabbitMQConfig {

    private final MessageMysqlDao mysqlDao;

    public RabbitMQConfig(MessageMysqlDao mysqlDao) {
        this.mysqlDao = mysqlDao;
    }

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);

        // 设置开启 Mandatory，才能触发回调函数，无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        // 关键就是以下两句
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            // 这里的 correlationData 来源于 convertAndSend 方法。
            log.debug("消息唯一标识 ： {}", correlationData);
            /*不是消息表的不进入下面*/
            if (correlationData.getId().equals("no")) {
                return;
            }
            if (ack) {
                log.debug("消息已发送至 RabbitMQ（的Exchange），修改 id 为 {} 的状态。", correlationData.getId());
                MessageMysqlPo po = new MessageMysqlPo();
                po.setStatus("1");
                po.setId(Long.valueOf(correlationData.getId()));
                mysqlDao.updateByPrimaryKeySelective(po);
                log.debug("修改消息表id为{}状态成功", correlationData.getId());
            } else {
                log.debug("消息未能发送到 Exchange。失败原因 {}", cause);
                MessageMysqlPo mysqlPo = mysqlDao.selectByPrimaryKey(Long.valueOf(correlationData.getId()));
                MessageMysqlPo po = new MessageMysqlPo();
                if (mysqlPo.getRetryCount() == 0) {
                    po.setStatus("2");
                } else {
                    po.setRetryCount(mysqlPo.getRetryCount() - 1);
                }
                po.setId(Long.valueOf(correlationData.getId()));
                mysqlDao.updateByPrimaryKeySelective(po);
            }
        });

        return rabbitTemplate;
    }
}
