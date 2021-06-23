package com.example.workerservice.service.command.user.updatepwd;

import com.example.workerservice.service.api.user.IUpdateUserPwdCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel
public class UpdateUserPwdCommand {

    @NotBlank
    @NotNull
    @ApiModelProperty(value = "用户接收到的验证码", example = "123456", required = true)
    private String verifyCode;

    @NotBlank
    @NotNull
    @ApiModelProperty(value = "想要被修改密码的员工工号", example = "STAFF20210616175114619751", required = true)
    private String workerNo;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "新的密码", example = "123123", required = true)
    private String password;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "重复密码", example = "123123", required = true)
    private String rePassword;

    @ApiModelProperty(hidden = true)
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
