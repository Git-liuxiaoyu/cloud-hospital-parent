package com.example.workerservice.service.command.doctorrota.regquery;

import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.service.api.doctorrota.IRegQueryDoctorRotaCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
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
public class RegQueryDoctorRotaCommand {

    @NotNull
    @ApiModelProperty(value = "想要挂号的日期(yyyy-MM-dd)", example = "2021-06-23",required = true)
    private Date date;

    @NotNull
    @ApiModelProperty(value = "想要挂号的科室主键ID", example = "1",required = true)
    private Integer departmentId;

    @ApiModelProperty(hidden = true)
    private IRegQueryDoctorRotaCommandHandler regQueryDoctorRotaCommandHandler;

    public RegQueryDoctorRotaCommand() {
        this.regQueryDoctorRotaCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IRegQueryDoctorRotaCommandHandler.class);
    }

    public RegQueryDoctorRotaCommand(Date date, Integer departmentId) {
        this();
        this.date = date;
        this.departmentId = departmentId;
    }

    public List<DoctorRotaVo> execute(){
        /* 执行方法 */
        return this.regQueryDoctorRotaCommandHandler.action(this);
    }

}
