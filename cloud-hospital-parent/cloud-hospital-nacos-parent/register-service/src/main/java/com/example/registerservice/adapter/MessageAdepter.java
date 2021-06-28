package com.example.registerservice.adapter;

import com.example.registerservice.adapter.converter.MessageConverter;
import com.example.registerservice.outlet.dao.mysql.MessageMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.MessageMysqlPo;
import com.example.registerservice.service.command.addmessage.AddMessageCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public void insert(AddMessageCommand command){
        MessageMysqlPo converter = this.converter.Converter(command);
        mysqlDao.insert(converter);
    }
}
