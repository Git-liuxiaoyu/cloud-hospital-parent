package com.example.registerservice.service.query.querypatient;

import com.example.registerservice.adapter.PatientAdepter;
import com.example.registerservice.service.api.IQueryPatientByIdCommandHandler;
import com.example.registerservice.service.query.querypatient.domain.Patient;
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

    @Autowired
    private PatientAdepter adepter;

    @Override
    public Patient action(QueryPatientByIdCommand command) {
        Patient patient = adepter.selectGetPatientById(command);
        return patient;
    }
}
