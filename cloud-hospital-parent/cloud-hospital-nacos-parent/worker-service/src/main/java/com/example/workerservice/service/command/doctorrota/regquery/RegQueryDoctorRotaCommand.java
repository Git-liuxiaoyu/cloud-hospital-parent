package com.example.workerservice.service.command.doctorrota.regquery;

import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.service.api.doctorrota.IRegQueryDoctorRotaCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
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
public class RegQueryDoctorRotaCommand {

    @NotNull
    private Date date;

    @NotNull
    private Integer departmentId;

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
