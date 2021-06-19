package com.example.registerservice.adapter.converter;

import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.service.command.addpatient.AddPatientCommand;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:50
 * @Description:
 */
@Component
public class PatientServicePoConverter {

    /**
     * PatientService对象转PatientMysql对象
     *
     * @param command
     * @return mysqlPo对象
     */
    public PatientMysqlPo converter(AddPatientCommand command) {
        PatientMysqlPo mysqlPo = new PatientMysqlPo();
        mysqlPo.setNo(command.getNo());
        mysqlPo.setName(command.getName());
        mysqlPo.setAge(command.getAge());
        mysqlPo.setGender(command.getGender());
        mysqlPo.setPhone(command.getPhone());
        mysqlPo.setIdentityid(command.getIdentityId());
        mysqlPo.setStatus(command.getStatus());
        mysqlPo.setCreatetime(command.getCreatetime());
        mysqlPo.setMedicard(command.getMedicard());
        return mysqlPo;
    }
}
