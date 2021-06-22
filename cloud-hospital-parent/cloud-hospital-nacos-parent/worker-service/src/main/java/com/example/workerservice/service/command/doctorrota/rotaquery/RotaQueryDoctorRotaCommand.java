package com.example.workerservice.service.command.doctorrota.rotaquery;

import com.example.workerservice.inlet.web.vo.DoctorRotaSetVo;
import com.example.workerservice.service.api.doctorrota.IRotaQueryDoctorRotaCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Data
public class RotaQueryDoctorRotaCommand {

    @NotNull
    private Date date;

    @NotNull
    private Integer departmentId;

    @NotNull
    private String shiftType;

    private IRotaQueryDoctorRotaCommandHandler rotaQueryDoctorRotaCommandHandler;

    public RotaQueryDoctorRotaCommand() {
        this.rotaQueryDoctorRotaCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IRotaQueryDoctorRotaCommandHandler.class);
    }

    public RotaQueryDoctorRotaCommand(Date date, Integer departmentId, String shiftType) {
        this();
        this.date = date;
        this.departmentId = departmentId;
        this.shiftType = shiftType;
    }

    public List<DoctorRotaSetVo> execute() {
        /* 执行方法 */
        return this.rotaQueryDoctorRotaCommandHandler.action(this);
    }
}
