package com.example.registerservice.service.api;

import com.example.registerservice.service.query.querymessage.QueryMessageCommand;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/26/10:42
 * @Description: 添加消息表的接口
 */
public interface IQueryMessageCommandHandler {
    void action(QueryMessageCommand command);
}
