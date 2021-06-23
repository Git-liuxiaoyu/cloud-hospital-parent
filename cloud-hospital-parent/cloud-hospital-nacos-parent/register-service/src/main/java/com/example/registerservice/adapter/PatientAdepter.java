package com.example.registerservice.adapter;

import com.example.registerservice.adapter.converter.PatientConverter;
import com.example.registerservice.adapter.converter.PatientServicePoConverter;
import com.example.registerservice.adapter.exception.AdapterException;
import com.example.registerservice.outlet.dao.mysql.PatientMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.service.command.addpatient.AddPatientCommand;
import com.example.registerservice.service.query.querypatient.QueryPatientByIdCommand;
import com.example.registerservice.service.query.querypatient.domain.Patient;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PatientAdepter {

    @Autowired
    private PatientMysqlDao mysqlDao;

    @Autowired
    private PatientServicePoConverter converter;

    @Autowired
    private PatientConverter patientConverter;


    /**
     * 添加患者信息
     *
     * @param command
     * @return
     */
    public Long insert(AddPatientCommand command) {
        PatientMysqlPo converter = this.converter.converter(command);
        int insert = mysqlDao.insert(converter);
        if (insert == 0) {
            throw new AdapterException();//sql添加失败抛出异常
        }
        return converter.getId();
    }

    /**
     * 查询患者信息
     *
     * @param command
     * @return
     */
    public Patient selectGetPatientById(QueryPatientByIdCommand command) {
        PatientMysqlPo mysqlPo = mysqlDao.selectByPrimaryKey(command.getId());
        //没有查询到数据抛异常
        if (mysqlPo == null) {
            log.debug("根据id{}没有查到数据", command.getId());
            throw new NullPointerException();
        }
        Patient converter = patientConverter.converter(mysqlPo);
        return converter;
    }
}
