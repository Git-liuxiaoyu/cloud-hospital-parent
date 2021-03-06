package com.example.registerservice.service.api;


import com.example.registerservice.service.query.querypatient.QueryPatientByIdCommand;
import com.example.registerservice.service.query.querypatient.domain.Patient;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:13
 * @Description: 新增病人接口
 */
public interface IQueryPatientByIdCommandHandler {
    Patient action(QueryPatientByIdCommand command);

    /**
     * 自定义业务异常 - 患者未发现
     **/
    class PatientByIdNotFoundException extends RuntimeException {
        public PatientByIdNotFoundException() {
            super("找不到该患者");
        }
    }
}
