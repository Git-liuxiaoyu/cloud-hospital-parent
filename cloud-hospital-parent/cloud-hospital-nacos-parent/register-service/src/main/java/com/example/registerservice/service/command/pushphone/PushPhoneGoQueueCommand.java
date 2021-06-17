package com.example.registerservice.service.command.pushphone;

import com.example.registerservice.outlet.publisher.api.IpushPhoneGoQueueEventPublisher;
import com.example.registerservice.outlet.publisher.api.IpushPhoneGoQueueEventPublisher.*;
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

    private IpushPhoneGoQueueEventPublisher handler;

    public PushPhoneGoQueueCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IpushPhoneGoQueueEventPublisher.class);
    }

    public PushPhoneGoQueueCommand(String phone) {
        this();
        this.phone = phone;
    }

    public void execute() {
        PushPhoneGoQueueCommandCompletedEvent event=new PushPhoneGoQueueCommandCompletedEvent(phone);
        ApplicationContextHolder.getApplicationContext().publishEvent(event);
    }
}
