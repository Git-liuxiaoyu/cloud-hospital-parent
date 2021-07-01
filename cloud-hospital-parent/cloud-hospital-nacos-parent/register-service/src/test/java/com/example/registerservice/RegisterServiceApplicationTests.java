package com.example.registerservice;


import com.example.registerservice.outlet.dao.es.PatientEsDao;
import com.example.registerservice.outlet.dao.es.po.PatientEsPo;
import com.example.registerservice.outlet.dao.mysql.PatientMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPoExample;
import com.example.registerservice.outlet.dao.redis.PatientRedisDao;
import com.example.registerservice.outlet.dao.redis.po.PatientRedisPo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class RegisterServiceApplicationTests {

    @Autowired
    private PatientMysqlDao mysqlDao;

    @Autowired
    private PatientEsDao esDao;

    @Autowired
    private PatientRedisDao redisDao;

    /**
     * 往es里面添加mysql的数据
     */
    @Test
    public void test01() {
        PatientMysqlPoExample example = new PatientMysqlPoExample();
        List<PatientMysqlPo> patientMysqlPos = mysqlDao.selectByExample(example);

        List<PatientEsPo> patientEsPoList = new ArrayList<>();

        List<PatientRedisPo> redisPoList = new ArrayList<>();

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

        patientMysqlPos.forEach(item -> {
            PatientRedisPo redisPo = new PatientRedisPo();
            redisPo.setId(item.getId());
            redisPo.setNo(item.getNo());
            redisPo.setName(item.getName());
            redisPo.setAge(item.getAge());
            redisPo.setGender(item.getGender());
            redisPo.setPhone(item.getPhone());
            redisPo.setIdentityid(item.getIdentityid());
            redisPo.setStatus(item.getStatus());
            redisPo.setCreatetime(item.getCreatetime());
            redisPo.setMedicard(item.getMedicard());
            redisPoList.add(redisPo);
        });

        patientEsPoList.forEach(item -> {
            esDao.save(item);
        });

        redisPoList.forEach(item->{
            redisDao.save(item);
        });

        Iterable<PatientEsPo> all = esDao.findAll();
        all.forEach(item -> {
            System.out.println(item);
        });

        Iterable<PatientRedisPo> all1 = redisDao.findAll();
        all1.forEach(item -> {
            System.out.println(item);
        });
    }

}
