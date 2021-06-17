package com.example.registerservice;

import com.example.registerservice.outlet.dao.mysql.PatientMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPoExample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RegisterServiceApplicationTests {

    @Autowired
    private PatientMysqlDao patientMysqlDao;

    @Test
    void contextLoads() {
        PatientMysqlPoExample p=new PatientMysqlPoExample();
        List<PatientMysqlPo> patientPos = patientMysqlDao.selectByExample(p);
        System.out.println(patientPos);
    }
}
