package com.example.registerservice.service.query.querymessage;

import com.example.registerservice.service.api.IQueryMessageCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/30/12:13
 * @Description:
 */
@Data
public class QueryMessageCommand {

    private String messageContent;//消息内容
    private String status;

    private IQueryMessageCommandHandler handler;

    public QueryMessageCommand(String messageContent) {
        this();
        this.messageContent = messageContent;
    }

    public QueryMessageCommand() {
        handler = ApplicationContextHolder.getApplicationContext().getBean(IQueryMessageCommandHandler.class);
    }

    public void execute() {
        this.status = "0";
        handler.action(this);
    }

}
