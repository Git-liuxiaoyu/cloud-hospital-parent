package com.example.registerservice.service.query.querypatient;

import com.example.registerservice.adapter.PatientAdepter;
import com.example.registerservice.service.api.IQueryPatientByIdentityIdCommandHandler;
import com.example.registerservice.service.query.querypatient.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/23/10:31
 * @Description:
 */
@Component
public class QueryPatientByIdentityIdCommandHandler implements IQueryPatientByIdentityIdCommandHandler {

    @Autowired
    private PatientAdepter adepter;

    @Override
    public Patient action(QueryPatientByIdentityIdCommand command) {
        Patient patient = adepter.selectGetPatientByIdentityId(command);
        return patient;
    }
}
