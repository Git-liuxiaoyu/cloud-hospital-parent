package com.example.workerservice.service.command.updatepwd;

import com.example.workerservice.service.api.IUpdateUserPwdCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 实体类 - 命令 - 更新用户密码
 */
@Data
@Slf4j
public class UpdateUserPwdCommand {

    @NotBlank
    @NotNull
    private String verifyCode;

    @NotBlank
    @NotNull
    private String workerNo;

    @NotNull
    @NotBlank
    private String password;

    private IUpdateUserPwdCommandHandler updateUserPwdCommandHandler;

    public UpdateUserPwdCommand() {
        this.updateUserPwdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IUpdateUserPwdCommandHandler.class);
    }

    public UpdateUserPwdCommand(String verifyCode, String workerNo, String password) {
        this();
        this.verifyCode = verifyCode;
        this.workerNo = workerNo;
        this.password = password;
    }

    public void execute() {
        /* 执行方法 */
        this.updateUserPwdCommandHandler.action(this);
    }

}
