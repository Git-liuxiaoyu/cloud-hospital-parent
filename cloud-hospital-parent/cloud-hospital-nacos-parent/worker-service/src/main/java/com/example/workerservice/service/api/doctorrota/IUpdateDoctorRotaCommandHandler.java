package com.example.workerservice.service.api.doctorrota;

import com.example.workerservice.service.command.doctorrota.update.UpdateDoctorRotaCommand;

/**
 * 接口 - IUpdateDoctorRotaCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
public interface IUpdateDoctorRotaCommandHandler {

    void action(UpdateDoctorRotaCommand command);

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


    /**
     * 自定义业务异常 - 类型未发现
     **/
    class ClassTypeNotFoundException extends RuntimeException {
        public ClassTypeNotFoundException() {
            super("添加失败");
        }
    }

}
