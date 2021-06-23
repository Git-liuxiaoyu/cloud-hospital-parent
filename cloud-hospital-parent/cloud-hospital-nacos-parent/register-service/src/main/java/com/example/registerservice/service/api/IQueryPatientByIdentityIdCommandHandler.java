package com.example.registerservice.service.api;


import com.example.registerservice.service.query.querypatient.QueryPatientByIdCommand;
import com.example.registerservice.service.query.querypatient.QueryPatientByIdentityIdCommand;
import com.example.registerservice.service.query.querypatient.domain.Patient;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:13
 * @Description:
 */
public interface IQueryPatientByIdentityIdCommandHandler {
    Patient action(QueryPatientByIdentityIdCommand command);
}
