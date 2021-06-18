package com.example.workerservice.service.api.user;

import com.example.workerservice.service.command.user.sendcode.SendVerifyCodeCommand;

/**
 * 接口 - 发送验证码
 */
public interface ISendVerifyCodeCommandHandler {

    void action(SendVerifyCodeCommand command);

}
