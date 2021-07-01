package com.example.registerservice.service.api;


import com.example.registerservice.service.command.addpatient.AddPatientCommand;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:13
 * @Description: 新增病人接口
 */
public interface IAddPatientCommandHandler {
    Long action(AddPatientCommand command);

    /**
     * 自定义业务异常 - 患者已存在
     **/
    class PatientByIdentityIdException extends RuntimeException {
        public PatientByIdentityIdException() {
            super("患者已存在");
        }
    }

    /**
     * 自定义业务异常 - 患者添加失败
     **/
    class PatientAddException extends RuntimeException {
        public PatientAddException() {
            super("患者添加失败");
        }
    }
}
