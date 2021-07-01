package com.example.registerservice.adapter;

import com.example.registerservice.adapter.converter.MessageConverter;
import com.example.registerservice.adapter.exception.AdapterException;
import com.example.registerservice.outlet.dao.mysql.MessageMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.MessageMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.MessageMysqlPoExample;
import com.example.registerservice.service.command.addmessage.AddMessageCommand;
import com.example.registerservice.service.query.querymessage.QueryMessageCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/26/11:21
 * @Description:
 */
@Component
@Slf4j
public class MessageAdepter {

    private final MessageMysqlDao mysqlDao;
    private final MessageConverter converter;

    public MessageAdepter(MessageMysqlDao mysqlDao, MessageConverter converter) {
        this.mysqlDao = mysqlDao;
        this.converter = converter;
    }

    public void insert(AddMessageCommand command) {
        MessageMysqlPo converter = this.converter.converter(command);
        mysqlDao.insert(converter);
    }

    public void selectByMsgByStatus(QueryMessageCommand command) {
        MessageMysqlPoExample example = new MessageMysqlPoExample();
        example.createCriteria()
                .andMessageContentEqualTo(command.getMessageContent())
                .andStatusEqualTo(command.getStatus());
        List<MessageMysqlPo> mysqlPoList = mysqlDao.selectByExample(example);
        if (!mysqlPoList.isEmpty()) {
            throw new AdapterException();
        }
    }
}
