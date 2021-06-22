package com.example.workerservice.service.command.doctorrota.cancel;

import com.example.workerservice.service.api.doctorrota.ICancelDoctorRotaCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 命令 - 实体类 - CancelDoctorRotaCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@Slf4j
public class CancelDoctorRotaCommand {

    private Long id;

    private ICancelDoctorRotaCommandHandler cancelDoctorRotaCommandHandler;

    public CancelDoctorRotaCommand() {
        this.cancelDoctorRotaCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(ICancelDoctorRotaCommandHandler.class);
    }

    public CancelDoctorRotaCommand(Long id) {
        this();
        this.id = id;
    }

    public void execute(){
        /* 执行方法 */
        this.cancelDoctorRotaCommandHandler.action(this);
    }

}
