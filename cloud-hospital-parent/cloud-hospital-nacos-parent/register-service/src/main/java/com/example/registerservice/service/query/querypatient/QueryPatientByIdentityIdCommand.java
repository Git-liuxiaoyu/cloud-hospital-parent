package com.example.registerservice.service.query.querypatient;

import com.example.registerservice.service.api.IQueryPatientByIdentityIdCommandHandler;
import com.example.registerservice.service.query.querypatient.domain.Patient;
import com.example.registerservice.util.ApplicationContextHolder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/23/10:31
 * @Description:
 */
@Data
public class QueryPatientByIdentityIdCommand {
    private String identityId;

    private IQueryPatientByIdentityIdCommandHandler handler;

    public QueryPatientByIdentityIdCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IQueryPatientByIdentityIdCommandHandler.class);
    }

    public QueryPatientByIdentityIdCommand(String identityId) {
        this();
        this.identityId = identityId;
    }

    public Patient execute() {
        Patient action = handler.action(this);
        return action;
    }
}
