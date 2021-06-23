package com.example.workerservice.service.command.user.login;

import com.example.workerservice.service.api.user.ILoginUserCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 实体类 - 命令 - 用户登录
 */
@Data
@Slf4j
@ApiModel
public class LoginUserCommand {

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "用户的账号", example = "123", required = true)
    private String account;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "用户的密码", example = "123123", required = true)
    private String password;

    @ApiModelProperty(value = "用户的请求登录Token", example = "asd12312b3i123oh51")
    private String loginToken;

    @ApiModelProperty(value = "用户的请求的IP", example = "127.0.0.1")
    private String ip;

    @ApiModelProperty(hidden = true)
    private ILoginUserCommandHandler loginUserCommandHandler;

    public LoginUserCommand() {
        this.loginUserCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(ILoginUserCommandHandler.class);
    }

    public LoginUserCommand(String account, String password, String loginToken) {
        this();
        this.account = account;
        this.password = password;
        this.loginToken = loginToken;
    }

    public boolean check() {
        /* 执行方法 */
        return loginUserCommandHandler.check(this);
    }

    public String execute() {
        /* 执行方法,返回对象 */
        return loginUserCommandHandler.action(this);
    }

}
