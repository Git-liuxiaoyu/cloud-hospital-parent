package com.example.workerservice.service.command.user.login;

import com.example.workerservice.service.api.user.ILoginUserCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 实体类 - 命令 - 用户登录
 */
@Data
@Slf4j
public class LoginUserCommand {

    @NotNull
    @NotBlank
    private String account;

    @NotNull
    @NotBlank
    private String password;

    private ILoginUserCommandHandler loginUserCommandHandler;

    public LoginUserCommand() {
        this.loginUserCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(ILoginUserCommandHandler.class);
    }

    public LoginUserCommand(String account, String password) {
        this();
        this.account = account;
        this.password = password;
    }

    public String execute() {
        /* 执行方法,返回对象 */
        return loginUserCommandHandler.action(this);
    }

}
