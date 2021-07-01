package com.example.registerservice.service.command.addpatient;

import com.example.registerservice.adapter.PatientAdepter;
import com.example.registerservice.adapter.exception.AdapterException;
import com.example.registerservice.outlet.dao.mysql.PatientMysqlDao;
import com.example.registerservice.service.api.IAddPatientCommandHandler;
import com.example.registerservice.service.api.IQueryPatientByIdentityIdCommandHandler;
import com.example.registerservice.service.query.querypatient.QueryPatientByIdentityIdCommand;
import com.example.registerservice.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:14
 * @Description:
 */
@Service
@Transactional
@Slf4j
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
        /*先查询患者的身份证能不能被添加*/
        try {
            /*先查询一下看看有没有该患者*/
            new QueryPatientByIdentityIdCommand(command.getIdentityId()).execute();
            log.debug("身份证{}已存在该患者不能添加", command.getIdentityId());
            /*查询到存在该患者抛异常*/
            throw new PatientByIdentityIdException();
        } catch (IQueryPatientByIdentityIdCommandHandler.PatientByIdentityIdNotFoundException e) {
            log.debug("添加身份证{}患者可以添加", command.getIdentityId());
        }

        Long patientId = null;
        try {
            patientId = adepter.insert(command);
        } catch (AdapterException e) {
            /*添加患者抛异常*/
            throw new PatientAddException();
        }
        return patientId;
    }
}
