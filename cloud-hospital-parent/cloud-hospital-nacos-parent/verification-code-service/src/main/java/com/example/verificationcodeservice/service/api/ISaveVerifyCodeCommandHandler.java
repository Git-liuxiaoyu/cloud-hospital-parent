package com.example.verificationcodeservice.service.api;

import com.example.verificationcodeservice.service.command.phone.SaveVerifyCodeCommand;

/**
 * 接口 - 保存验证码
 */
public interface ISaveVerifyCodeCommandHandler {

    void action(SaveVerifyCodeCommand command);

}
