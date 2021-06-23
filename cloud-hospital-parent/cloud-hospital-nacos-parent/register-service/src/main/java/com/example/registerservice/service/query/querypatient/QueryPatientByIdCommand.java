package com.example.registerservice.service.query.querypatient;

import com.example.registerservice.service.api.IQueryPatientByIdCommandHandler;
import com.example.registerservice.service.query.querypatient.domain.Patient;
import com.example.registerservice.util.ApplicationContextHolder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/22/16:48
 * @Description:
 */

@Data
public class QueryPatientByIdCommand implements Serializable {
    private Long id;

    private IQueryPatientByIdCommandHandler handler;

    public QueryPatientByIdCommand(Long id) {
        this();
        this.id = id;
    }

    public QueryPatientByIdCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IQueryPatientByIdCommandHandler.class);
    }

    public Patient execute() {
        Patient action = handler.action(this);
        return action;
    }
}
