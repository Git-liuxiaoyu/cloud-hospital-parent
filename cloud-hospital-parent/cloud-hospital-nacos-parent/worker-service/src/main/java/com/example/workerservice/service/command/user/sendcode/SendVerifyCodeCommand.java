package com.example.workerservice.service.command.user.sendcode;

import com.example.workerservice.service.api.user.ISendVerifyCodeCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 实体类 - 命令 - 发送验证码
 */
@Data
@Slf4j
@ApiModel
public class SendVerifyCodeCommand {

    @NotBlank
    @NotNull
    @ApiModelProperty(value = "员工工号", example = "STAFF20210616175114619751", required = true)
    private String workerNo;

    @ApiModelProperty(hidden = true)
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
