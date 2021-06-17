package com.example.workerservice.service.command.sendcode;

import com.example.workerservice.service.api.ISendVerifyCodeCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 实体类 - 命令 - 发送验证码
 */
@Data
@Slf4j
public class SendVerifyCodeCommand {

    @NotBlank
    @NotNull
    private String workerNo;

    private ISendVerifyCodeCommandHandler sendVerifyCodeCommandHandler;

    public SendVerifyCodeCommand() {
        this.sendVerifyCodeCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(ISendVerifyCodeCommandHandler.class);
    }

    public SendVerifyCodeCommand(String workerNo) {
        this.workerNo = workerNo;
    }

    public void execute() {
        /* 调用方法 */
        sendVerifyCodeCommandHandler.action(this);
    }

}
