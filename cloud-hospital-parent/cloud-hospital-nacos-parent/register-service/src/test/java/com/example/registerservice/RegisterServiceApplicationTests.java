package com.example.registerservice;


import com.example.registerservice.outlet.dao.es.PatientEsDao;
import com.example.registerservice.outlet.dao.es.po.PatientEsPo;
import com.example.registerservice.outlet.dao.mysql.PatientMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPoExample;
import com.example.registerservice.service.query.querypatient.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class RegisterServiceApplicationTests {

    @Autowired
    private PatientMysqlDao mysqlDao;

    @Autowired
    private PatientEsDao esDao;

    /**
     * 往es里面添加mysql的数据
     */
    @Test
    public void test01() {
        PatientMysqlPoExample example = new PatientMysqlPoExample();
        List<PatientMysqlPo> patientMysqlPos = mysqlDao.selectByExample(example);

        List<PatientEsPo> patientEsPoList = new ArrayList<>();

        patientMysqlPos.forEach(item -> {
            PatientEsPo esPo = new PatientEsPo();
            esPo.setId(item.getId());
            esPo.setNo(item.getNo());
            esPo.setName(item.getName());
            esPo.setAge(item.getAge());
            esPo.setGender(item.getGender());
            esPo.setPhone(item.getPhone());
            esPo.setIdentityid(item.getIdentityid());
            esPo.setStatus(item.getStatus());
            esPo.setCreatetime(item.getCreatetime());
            esPo.setMedicard(item.getMedicard());
            patientEsPoList.add(esPo);
        });


        patientEsPoList.forEach(item -> {
            esDao.save(item);
        });

        Iterable<PatientEsPo> all = esDao.findAll();
        all.forEach(item -> {
            System.out.println(item);
        });
    }

}
