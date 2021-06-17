package com.example.workerservice.service.api;

import com.example.workerservice.service.command.sendcode.SendVerifyCodeCommand;

/**
 * 接口 - 发送验证码
 */
public interface ISendVerifyCodeCommandHandler {

    void action(SendVerifyCodeCommand command);

}
