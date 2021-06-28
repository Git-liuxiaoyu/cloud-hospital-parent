package com.example.workerservice.service.api.doctorrota;

import com.example.workerservice.service.command.doctorrota.cancel.CancelDoctorRotaCommand;

/**
 * 接口 - ICancelDoctorRotaCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
public interface ICancelDoctorRotaCommandHandler {

    void action(CancelDoctorRotaCommand command);

    /**
     * 自定义业务异常 - 没有发现该医生排班
     **/
    class DoctorRotaNotFoundException extends RuntimeException {
        public DoctorRotaNotFoundException() {
            super("没有发现该医生排班");
        }
    }

}
