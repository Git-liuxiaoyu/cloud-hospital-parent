package com.example.registerservice.service.command.addpatient;

import com.example.registerservice.service.api.IAddPatientCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import com.example.registerservice.util.PatientUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:14
 * @Description: 添加患者对象
 */
@Data
@Slf4j
public class AddPatientCommand {

    @ApiModelProperty(hidden = true)
    private Long id;//添加成功返回患者的Id

    @ApiModelProperty(hidden = true)
    private String no;//病人编号
    @ApiModelProperty(hidden = true)
    private String status;//病人状态(0、待就诊 1、已就诊)
    @ApiModelProperty(hidden = true)
    private Date createtime;//病人建档时间
    @ApiModelProperty(hidden = true)
    private String medicard;//病人医保卡

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
    @ApiModelProperty(value = "患者身份证", example = "429006200012345671", required = true)
    private String identityId;//患者身份证

    @ApiModelProperty(hidden = true)
    private IAddPatientCommandHandler handler;

    public AddPatientCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IAddPatientCommandHandler.class);
    }

    public Long execute() {
        /*生成默认的患者编号*/
        this.no = PatientUtil.getPatientNo();
        /*给予默认的状态*/
        this.status = "0";
        /*添加当前时间*/
        this.createtime = new Date();
        Long patientId = handler.action(this);
        return patientId;
    }
}
