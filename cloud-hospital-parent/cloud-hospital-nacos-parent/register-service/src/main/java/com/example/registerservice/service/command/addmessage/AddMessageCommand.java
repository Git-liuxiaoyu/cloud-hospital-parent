package com.example.registerservice.service.command.addmessage;

import com.example.registerservice.service.api.IAddMessageCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/26/10:43
 * @Description:
 */
@Data
public class AddMessageCommand {

    private String exchange;//交换机的名字

    private String routingKey;//路由键

    private String messageContent;//消息的内容

    private String status;//消息的状态（0.未投入、1.已投人、2.消费失败）

    private Integer retryCount;//消息发送次数，默认3次

    private Long version;//用来实现乐观锁的

    private IAddMessageCommandHandler handler;

    public AddMessageCommand(String exchange, String routingKey, String messageContent) {
        this();
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.messageContent = messageContent;
        this.status = "0";//默认是未投入
        this.retryCount = 3;//默认是3次机会
        this.version = 0L;//版本
    }

    public AddMessageCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IAddMessageCommandHandler.class);
    }

    public void execute() {
        handler.action(this);
    }
}
