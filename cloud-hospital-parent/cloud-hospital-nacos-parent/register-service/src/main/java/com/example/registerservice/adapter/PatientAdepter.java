package com.example.registerservice.adapter;

import com.example.registerservice.adapter.converter.PatientServicePoConverter;
import com.example.registerservice.adapter.exception.AdapterException;
import com.example.registerservice.outlet.dao.mysql.PatientMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.service.command.addpatient.AddPatientCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:49
 * @Description:
 */
@Component
public class PatientAdepter {

    @Autowired
    private PatientMysqlDao mysqlDao;

    @Autowired
    private PatientServicePoConverter converter;


    public void insert(AddPatientCommand command){
        PatientMysqlPo converter = this.converter.converter(command);
        int insert = mysqlDao.insert(converter);
        if(insert==0){
            throw new AdapterException();//sql添加失败抛出异常
        }
    }
}
