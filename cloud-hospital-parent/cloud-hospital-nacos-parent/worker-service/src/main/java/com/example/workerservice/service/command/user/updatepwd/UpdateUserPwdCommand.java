package com.example.workerservice.service.command.user.updatepwd;

import com.example.workerservice.service.api.user.IUpdateUserPwdCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 实体类 - 命令 - 更新用户密码
 */
@Data
@Slf4j
@ToString
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

    @NotNull
    @NotBlank
    private String rePassword;

    private IUpdateUserPwdCommandHandler updateUserPwdCommandHandler;

    public UpdateUserPwdCommand() {
        this.updateUserPwdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IUpdateUserPwdCommandHandler.class);
    }

    public UpdateUserPwdCommand(String verifyCode, String workerNo, String password, String rePassword) {
        this();
        this.verifyCode = verifyCode;
        this.workerNo = workerNo;
        this.password = password;
        this.rePassword = rePassword;
    }

    public void execute() {
        /* 执行方法 */
        this.updateUserPwdCommandHandler.action(this);
    }

}
