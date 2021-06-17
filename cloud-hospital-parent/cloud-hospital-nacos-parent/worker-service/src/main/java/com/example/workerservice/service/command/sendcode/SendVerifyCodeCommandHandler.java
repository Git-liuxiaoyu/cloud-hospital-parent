package com.example.workerservice.service.command.sendcode;

import com.example.workerservice.adapter.UserDaoAdapter;
import com.example.workerservice.outlet.publisher.api.IUserMqEventPublisher;
import com.example.workerservice.service.api.ISendVerifyCodeCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 - SendVerifyCodeCommandHandler
 */
@Component
@Slf4j
public class SendVerifyCodeCommandHandler implements ISendVerifyCodeCommandHandler {

    /* 构造注入 - 开始 */
    private final UserDaoAdapter userDaoAdapter;

    public SendVerifyCodeCommandHandler(UserDaoAdapter userDaoAdapter) {
        this.userDaoAdapter = userDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public void action(SendVerifyCodeCommand command) {
        /* 推送 Event */
        ApplicationContextHolder.getApplicationContext().publishEvent(new IUserMqEventPublisher.SendVerifyCodeMqEvent(command.getPhone()));
    }
}
