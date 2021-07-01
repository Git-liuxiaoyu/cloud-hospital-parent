package com.example.registerservice.inlet.timer;

import com.example.registerservice.outlet.dao.mysql.MessageMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.MessageMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.MessageMysqlPoExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/26/12:07
 * @Description:
 */
@Slf4j
@Service
public class ReliableMessageService {
    private final MessageMysqlDao mysqlDao;
    private final RabbitTemplate template;

    public ReliableMessageService(MessageMysqlDao mysqlDao, RabbitTemplate template) {
        this.mysqlDao = mysqlDao;
        this.template = template;
    }

    //    @Scheduled(fixedDelay = 3 * 1000)
    @Scheduled(fixedDelay = 1000 * 60 * 10)
    private void autoSend() {
        MessageMysqlPoExample example = new MessageMysqlPoExample();
        example.createCriteria().andStatusEqualTo("0");
        List<MessageMysqlPo> mysqlPoList = mysqlDao.selectByExample(example);
        log.debug("定时查询消息表");
        mysqlPoList.forEach(item -> {
            template.convertAndSend(item.getExchange(), item.getRoutingKey(), item.getMessageContent(), new CorrelationData(item.getId().toString()));
        });
    }
}
