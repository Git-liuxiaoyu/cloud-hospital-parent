package com.example.registerservice.adapter;

import com.example.registerservice.adapter.converter.PatientConverter;
import com.example.registerservice.adapter.converter.PatientServicePoConverter;
import com.example.registerservice.adapter.exception.AdapterException;
import com.example.registerservice.outlet.dao.mysql.PatientMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPoExample;
import com.example.registerservice.service.command.addpatient.AddPatientCommand;
import com.example.registerservice.service.command.updatepatient.UpdatePatientCommand;
import com.example.registerservice.service.query.querypatient.QueryPatientByIdCommand;
import com.example.registerservice.service.query.querypatient.QueryPatientByIdentityIdCommand;
import com.example.registerservice.service.query.querypatient.domain.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
     * 根据患者id查询患者信息
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

    /**
     * 根据患者身份证查询患者信息
     *
     * @param command
     * @return
     */
    public Patient selectGetPatientByIdentityId(QueryPatientByIdentityIdCommand command) {
        PatientMysqlPoExample example = new PatientMysqlPoExample();
        example.createCriteria().andIdentityidEqualTo(command.getIdentityId());
        List<PatientMysqlPo> patientMysqlPos = mysqlDao.selectByExample(example);
        //判断一下patientMysqlPos是不是空
        if (!patientMysqlPos.isEmpty()) {
            Patient converter = patientConverter.converter(patientMysqlPos.get(0));
            log.debug("根据身份证{}查询到该患者信息{}", command.getIdentityId(), converter);
            return converter;
        } else {
            log.debug("根据身份证{}没有查询到该患者信息", command.getIdentityId());
            throw new NullPointerException();
        }
    }


    /**
     * 事务对象转换为mysql对象
     *
     * @param command
     * @return
     */
    public void update(UpdatePatientCommand command) {
        PatientMysqlPoExample example = new PatientMysqlPoExample();
        PatientMysqlPo converter = patientConverter.converter(command);
        example.createCriteria().andIdEqualTo(command.getId());
        int i = mysqlDao.updateByExampleSelective(converter, example);
        if (i == 0) {
            throw new AdapterException();
        }
    }
}
