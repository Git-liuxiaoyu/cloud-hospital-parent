package com.example.registerservice.service.command.updatepatient;

import com.example.registerservice.service.api.IUpdatePatientCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/23/14:42
 * @Description:
 */
@Data
public class UpdatePatientCommand {

    @NotNull
    @ApiModelProperty(value = "患者id", example = "1", required = true)
    private Long id;//患者的Id

    @NotNull
    @ApiModelProperty(value = "患者姓名", example = "刘小雨", required = true)
    private String name;//患者姓名

    @NotNull
    @ApiModelProperty(value = "患者年龄", example = "21", required = true)
    private Integer age;//患者年龄

    @NotNull
    @ApiModelProperty(value = "患者性别", example = "0是男，1是女", required = true)
    private String gender;//患者性别

    @NotNull
    @ApiModelProperty(value = "患者电话", example = "17683858973", required = true)
    private String phone;//患者电话

    @NotNull
    @ApiModelProperty(value = "患者身份证", example = "42900620001234567X", required = true)
    private String identityId;//患者身份证

    @ApiModelProperty(value = "患者身份证",  hidden = true)
    private IUpdatePatientCommandHandler handler;

    public UpdatePatientCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IUpdatePatientCommandHandler.class);
    }

    public void execute() {
        handler.action(this);
    }
}
