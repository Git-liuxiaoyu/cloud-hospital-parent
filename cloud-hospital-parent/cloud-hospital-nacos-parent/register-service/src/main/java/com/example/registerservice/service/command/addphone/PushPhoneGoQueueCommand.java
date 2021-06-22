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
public class PushPhoneGoQueueCommand implements Serializable {

    private String phone;

//    private IPushPhoneGoQueueEventPublisher handler;

    private IAddPhoneGoRedisCommandHandler handler;

    public PushPhoneGoQueueCommand() {
        //命令模式代理对象注入
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IAddPhoneGoRedisCommandHandler.class);
    }

    public PushPhoneGoQueueCommand(String phone) {
        this();
        this.phone = phone;
    }

    public boolean execute() {
        //调用接口方法
        boolean action = handler.action(this);

        //执行event事件 如果action为true表示今天已经获取过验证码 false表示没有获取
        if (!action) {
            PushPhoneGoQueueCommandCompletedEvent event = new PushPhoneGoQueueCommandCompletedEvent(phone);
            ApplicationContextHolder.getApplicationContext().publishEvent(event);
        }
        return action;
    }
}
