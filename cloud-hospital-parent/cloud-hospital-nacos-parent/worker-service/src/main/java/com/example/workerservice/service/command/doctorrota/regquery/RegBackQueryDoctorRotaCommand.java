package com.example.workerservice.service.command.doctorrota.regquery;

import com.example.workerservice.service.api.doctorrota.IRegBackQueryDoctorRotaCommandHandler;
import com.example.workerservice.service.api.doctorrota.IRegQueryDoctorRotaCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 实体类 - 命令 - 挂号Reg查询DoctorRota
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Data
@ToString
@ApiModel
public class RegBackQueryDoctorRotaCommand {

    @ApiModelProperty(value = "想要挂号的日期(yyyy-MM-dd)", example = "2021-06-23", hidden = true)
    private Date date;

    @NotNull
    @ApiModelProperty(value = "想要挂号的科室主键ID", example = "1", required = true)
    private Integer departmentId;

    @NotNull
    @ApiModelProperty(value = "医生类别(0、普通;1、专家)", example = "1", required = true)
    private String doctorType;

    @NotNull
    @ApiModelProperty(value = "挂号时间段(1、上午,2、下午)", example = "1", required = true)
    private String shiftType;

    @ApiModelProperty(hidden = true)
    private IRegBackQueryDoctorRotaCommandHandler regBackQueryDoctorRotaCommandHandler;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @ApiModel
    public static class DoctorRotaVo {

        @ApiModelProperty(value = "医生排班的主键ID", example = "1")
        private Long id;

        @ApiModelProperty(value = "科室主键ID", example = "1")
        private Integer departmentid;

        @ApiModelProperty(value = "科室名称", example = "心脏外科")
        private String departmentname;

        @ApiModelProperty(value = "该次排班医生的日期(yyyy-MM-dd)", example = "2021-06-23")
        private Date date;

        @ApiModelProperty(value = "这次排班的房间主键ID", example = "1")
        private Integer roomid;

        @ApiModelProperty(value = "该次排班医生的时间类型(上午班、下午班)", example = "1")
        private String shifttype;

        @ApiModelProperty(value = "该次排班医生的主键ID", example = "1")
        private Integer doctorid;

        @ApiModelProperty(value = "该次排班医生的名称", example = "张方松")
        private String doctorName;

        @ApiModelProperty(value = "该次排班医生的头像路径")
        private String doctorAvatar;

        /* 大于0就是专家号 */
        @ApiModelProperty(value = "该次排班医生的等级(0、普通，1、高级,2、主任)[大于0就是专家号]", example = "1")
        private String doctorLevel;

        @ApiModelProperty(value = "该次排班剩余的看诊人数", example = "33")
        private Integer leftpatient;

        @ApiModelProperty(value = "该次排班最大的看诊人数", example = "33")
        private Integer maxpatient;

        @ApiModelProperty(value = "该次排班的状态", example = "33")
        private String status;
    }

    public RegBackQueryDoctorRotaCommand() {
        this.regBackQueryDoctorRotaCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IRegBackQueryDoctorRotaCommandHandler.class);
    }

    public RegBackQueryDoctorRotaCommand(Date date, Integer departmentId) {
        this();
        this.date = date;
        this.departmentId = departmentId;
    }

    public List<DoctorRotaVo> execute() {
        /* 执行方法 */
        return this.regBackQueryDoctorRotaCommandHandler.action(this);
    }

}
