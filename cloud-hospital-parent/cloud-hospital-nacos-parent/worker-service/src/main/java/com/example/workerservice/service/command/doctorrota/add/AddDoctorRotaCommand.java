package com.example.workerservice.service.command.doctorrota.add;

import com.example.workerservice.service.api.doctorrota.IAddDoctorRotaCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 实体类 - 命令 - AddDoctorRotaCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Data
@ToString
@Slf4j
@ApiModel
public class AddDoctorRotaCommand {

    @ApiModelProperty(value = "医生排班表主键ID", example = "1")
    private Long id;

    @ApiModelProperty(value = "创造该排班的医生工号", example = "STAFF20210616175114619751")
    private String createWorkerNo;

    @NotNull
    @ApiModelProperty(value = "科室主键ID", example = "1",required = true)
    private Integer departmentId;

    @NotNull
    @ApiModelProperty(value = "排班的日期(yyyy-MM-dd)", example = "2021-06-23",required = true)
    private Date date;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "排班的类型(1、门诊排班,2、住院排班[未做])", example = "1",required = true)
    private String rotaType;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "排班时间类型（1、上午班,2、下午班, 3、晚班）[无晚班]", example = "1",required = true)
    private String shiftType;

    @NotNull
    @ApiModelProperty(value = "排班的医生主键ID", example = "1",required = true)
    private Integer doctorId;

    @NotNull
    @ApiModelProperty(value = "单次排班最大看诊人数", example = "1",required = true)
    private Integer maxPatient;

    @NotNull
    @ApiModelProperty(value = "排班的房间主键ID(该排班在哪个诊室)", example = "1",required = true)
    private Integer roomId;

    @ApiModelProperty(value = "创建该排班的医生主键ID", example = "1")
    private Integer createId;

    @ApiModelProperty(value = "创建该排班的时间")
    private Date createTime;

    @ApiModelProperty(value = "该排班的状态", example = "1")
    private String status;

    @ApiModelProperty(hidden = true)
    private IAddDoctorRotaCommandHandler addDoctorRotaCommandHandler;

    public AddDoctorRotaCommand() {
        this.addDoctorRotaCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IAddDoctorRotaCommandHandler.class);
    }

    public AddDoctorRotaCommand(Long id, String createWorkerNo, Integer departmentId, Date date, String rotaType, String shiftType, Integer doctorId, Integer maxPatient, Integer roomId, Integer createId, Date createTime, String status) {
        this();
        this.id = id;
        this.createWorkerNo = createWorkerNo;
        this.departmentId = departmentId;
        this.date = date;
        this.rotaType = rotaType;
        this.shiftType = shiftType;
        this.doctorId = doctorId;
        this.maxPatient = maxPatient;
        this.roomId = roomId;
        this.createId = createId;
        this.createTime = createTime;
        this.status = status;
    }

    public Long execute() {
        /* 执行方法 */
        return this.addDoctorRotaCommandHandler.action(this);
    }

}
