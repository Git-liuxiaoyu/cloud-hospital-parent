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
 * @Description: 根据id查询患者信息命令类
 */

@Data
public class QueryPatientByIdCommand {

    /*患者Id*/
    private Long id;

    /*注入对象*/
    private IQueryPatientByIdCommandHandler handler;

    /*有参注入*/
    public QueryPatientByIdCommand(Long id) {
        this();
        this.id = id;
    }

    /*无参构造*/
    public QueryPatientByIdCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IQueryPatientByIdCommandHandler.class);
    }

    /*命令方法*/
    public Patient execute() {
        Patient action = handler.action(this);
        return action;
    }
}
