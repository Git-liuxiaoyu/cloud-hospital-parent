package com.example.registerservice.service.query.querypatient;

import com.example.registerservice.adapter.PatientAdepter;
import com.example.registerservice.service.api.IQueryPatientByIdCommandHandler;
import com.example.registerservice.service.query.querypatient.domain.Patient;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/22/16:48
 * @Description:
 */
@Component
public class QueryPatientByIdCommandHandler implements IQueryPatientByIdCommandHandler {

    /*构造注入对象*/
    private final PatientAdepter adepter;

    public QueryPatientByIdCommandHandler(PatientAdepter adepter) {
        this.adepter = adepter;
    }

    @Override
    public Patient action(QueryPatientByIdCommand command) {

        Patient patient = null;
        try {
            patient = adepter.selectGetPatientById(command);
            /*这里的catch捕获的是查了3个数据库都没有查询到数据*/
        } catch (NullPointerException e) {
            /*抛出异常*/
            throw new PatientByIdNotFoundException();
        }
        return patient;
    }
}
