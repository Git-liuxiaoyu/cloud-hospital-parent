package com.example.drugservice;

import com.example.drugservice.outlet.dao.mysql.DrugDao;
import com.example.drugservice.outlet.dao.mysql.DrugOddDao;
import com.example.drugservice.outlet.dao.mysql.po.DrugOddPo;
import com.example.drugservice.outlet.dao.mysql.po.DrugPo;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DrugServiceApplicationTests {
    @Autowired
    private DrugDao drugDao;

    @Autowired
    private RabbitTemplate template;

    @Test
    void contextLoads() {
        List<DrugPo> drugPos = drugDao.selectByExample(null);
        for (DrugPo drugPo : drugPos) {
            System.out.println(drugPo);
        }
        System.out.println(drugPos);
    }

    @Test
    void queueTest(){
        template.convertAndSend("first-exchange","first-routing-key","996996");
    }

    @Test
    void queue2Test(){
        template.convertAndSend("outpatient_over_exchange","outpatient.update","996");
    }




}
