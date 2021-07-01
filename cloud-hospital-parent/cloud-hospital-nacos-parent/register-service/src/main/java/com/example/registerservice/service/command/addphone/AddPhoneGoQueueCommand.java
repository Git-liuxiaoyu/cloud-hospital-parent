package com.example.registerservice.service.command.addphone;

import com.example.registerservice.outlet.publisher.api.IPushPhoneGoQueueEventPublisher.*;
import com.example.registerservice.service.api.IAddPhoneGoRedisCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/10:33
 * @Description:
 */
@Data
public class AddPhoneGoQueueCommand {

    private String phone;

//    private IPushPhoneGoQueueEventPublisher handler;

    private IAddPhoneGoRedisCommandHandler handler;

    public AddPhoneGoQueueCommand() {
        //命令模式代理对象注入
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IAddPhoneGoRedisCommandHandler.class);
    }

    public AddPhoneGoQueueCommand(String phone) {
        this();
        this.phone = phone;
    }

    public void execute() {
        //调用接口方法
        handler.action(this);

        PushPhoneGoQueueCommandCompletedEvent event = new PushPhoneGoQueueCommandCompletedEvent(phone);
        ApplicationContextHolder.getApplicationContext().publishEvent(event);
    }
}
