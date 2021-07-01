package com.example.registerservice.service.query.querymessage;

import com.example.registerservice.adapter.MessageAdepter;
import com.example.registerservice.service.api.IQueryMessageCommandHandler;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/30/12:13
 * @Description:
 */
@Component
public class QueryMessageCommandHandler implements IQueryMessageCommandHandler {

    private final MessageAdepter adepter;

    public QueryMessageCommandHandler(MessageAdepter adepter) {
        this.adepter = adepter;
    }

    @Override
    public void action(QueryMessageCommand command) {
        adepter.selectByMsgByStatus(command);
    }
}
