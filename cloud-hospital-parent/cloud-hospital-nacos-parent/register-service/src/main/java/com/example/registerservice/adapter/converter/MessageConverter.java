package com.example.registerservice.adapter.converter;

import com.example.registerservice.outlet.dao.mysql.po.MessageMysqlPo;
import com.example.registerservice.service.command.addmessage.AddMessageCommand;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/26/11:51
 * @Description:
 */
@Component
public class MessageConverter {

    public MessageMysqlPo converter(AddMessageCommand command) {
        MessageMysqlPo po = new MessageMysqlPo();
        po.setExchange(command.getExchange());
        po.setRoutingKey(command.getRoutingKey());
        po.setMessageContent(command.getMessageContent());
        po.setStatus(command.getStatus());
        po.setRetryCount(command.getRetryCount());
        po.setVersion(command.getVersion());
        return po;
    }

}
