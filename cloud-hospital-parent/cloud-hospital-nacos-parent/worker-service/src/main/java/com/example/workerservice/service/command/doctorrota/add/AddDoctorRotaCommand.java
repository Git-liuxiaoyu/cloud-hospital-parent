package com.example.workerservice.service.command.doctorrota.add;

import com.example.workerservice.service.api.doctorrota.IAddDoctorRotaCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
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
public class AddDoctorRotaCommand {

    private Long id;

    private String createWorkerNo;

    @NotNull
    private Integer departmentId;

    @NotNull
    private Date date;

    @NotNull
    @NotBlank
    private String rotaType;

    @NotNull
    @NotBlank
    private String shiftType;

    @NotNull
    private Integer doctorId;

    @NotNull
    private Integer maxPatient;

    @NotNull
    private Integer roomId;

    private Integer createId;

    private Date createTime;

    private String status;

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
