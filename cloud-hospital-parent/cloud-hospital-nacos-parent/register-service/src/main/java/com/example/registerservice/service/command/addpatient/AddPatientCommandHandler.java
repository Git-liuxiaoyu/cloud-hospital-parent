package com.example.registerservice.service.command.addpatient;

import com.example.registerservice.adapter.PatientAdepter;
import com.example.registerservice.outlet.dao.mysql.PatientMysqlDao;
import com.example.registerservice.service.api.IAddPatientCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:14
 * @Description:
 */
@Service
public class AddPatientCommandHandler implements IAddPatientCommandHandler {

    @Autowired
    private PatientAdepter adepter;

    /**
     * 添加病人到数据库方法
     *
     * @param command
     */
    @Override
    public Long action(AddPatientCommand command) {
        Long patientId = adepter.insert(command);
        return patientId;
    }
}
