package com.example.workerservice.service.api.doctorrota;

import com.example.workerservice.service.command.doctorrota.add.AddDoctorRotaCommand;

/**
 * 接口 - IAddDoctorRotaCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
public interface IAddDoctorRotaCommandHandler {

    Long action(AddDoctorRotaCommand command);


    /**
     * 自定义业务异常 - 医生不能同一时间段出现在多间诊室
     **/
    class DoctorIsRotedInOtherRoomException extends RuntimeException {
        public DoctorIsRotedInOtherRoomException() {
            super("医生不能同一时间段出现在多间诊室");
        }
    }


    /**
     * 自定义业务异常 - 员工未发现
     **/
    class WorkerInfoNotFoundException extends RuntimeException {
        public WorkerInfoNotFoundException() {
            super("找不到该员工");
        }
    }

}
