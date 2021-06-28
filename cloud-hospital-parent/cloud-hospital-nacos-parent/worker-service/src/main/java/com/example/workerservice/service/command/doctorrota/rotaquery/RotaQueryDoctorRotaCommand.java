package com.example.workerservice.service.command.doctorrota.rotaquery;

import com.example.workerservice.service.api.doctorrota.IRotaQueryDoctorRotaCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Data
@ApiModel
public class RotaQueryDoctorRotaCommand {

    @NotNull
    @ApiModelProperty(value = "查询排班的日期(yyyy-MM-dd)", example = "2021-06-23", required = true)
    private Date date;

    @NotNull
    @ApiModelProperty(value = "查询科室主键ID", example = "1", required = true)
    private Integer departmentId;

    @NotNull
    @ApiModelProperty(value = "查询排班的时间类型(上下午)", example = "1", required = true)
    private String shiftType;

    @ApiModelProperty(hidden = true)
    private IRotaQueryDoctorRotaCommandHandler rotaQueryDoctorRotaCommandHandler;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @ApiModel
    @Builder(toBuilder = true)
    public static class DoctorRotaVo {

        @ApiModelProperty(value = "医生排班的主键ID", example = "1")
        private Long id;

        @ApiModelProperty(value = "排班的房间主键ID", example = "1")
        private Integer roomid;

        @ApiModelProperty(value = "医生主键ID", example = "1")
        private Integer doctorid;

        @ApiModelProperty(value = "单次排班最大看诊人数", example = "1")
        private Integer maxpatient;

        @ApiModelProperty(value = "排班的状态", example = "1")
        private String status;

    }


    public RotaQueryDoctorRotaCommand() {
        this.rotaQueryDoctorRotaCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IRotaQueryDoctorRotaCommandHandler.class);
    }

    public RotaQueryDoctorRotaCommand(Date date, Integer departmentId, String shiftType) {
        this();
        this.date = date;
        this.departmentId = departmentId;
        this.shiftType = shiftType;
    }

    public List<DoctorRotaVo> execute() {
        /* 执行方法 */
        return this.rotaQueryDoctorRotaCommandHandler.action(this);
    }
}
