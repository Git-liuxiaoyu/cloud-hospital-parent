package com.example.registerservice;


import com.example.registerservice.outlet.dao.mysql.PatientMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPoExample;
import com.example.registerservice.adapter.RegisterDaoAdapter;
import com.example.registerservice.outlet.dao.mysql.PatientMysqlDao;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPoExample;
import com.example.registerservice.outlet.dao.redis.po.PatientRedisPo;
import com.example.registerservice.service.query.GetPhoneAndCode.QueuePhoneAndCodeCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class RegisterServiceApplicationTests {


}
