package com.example.registerservice.service.query.GetPhoneAndCode;

import com.example.registerservice.service.api.IAddPhoneGoRedisCommandHandler;
import com.example.registerservice.service.api.IQueuePhoneAndCodeCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/17:19
 * @Description:
 */
@Data
public class QueuePhoneAndCodeCommand implements Serializable {
    private String phone;
    private String code;

    private IQueuePhoneAndCodeCommandHandler handler;

    public QueuePhoneAndCodeCommand() {
        //命令模式代理对象注入
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IQueuePhoneAndCodeCommandHandler.class);
    }

    public boolean execute() {
        //返回的是true表示表单验证通过 false取反
        boolean action = handler.action(this);
        return action;
    }

}
