package com.example.physicalexamservice;

import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordDetailMysqlPo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PhysicalExamServiceApplicationTests {

    @Test
    void contextLoads() {

        PhysicalExamRecordDetailMysqlPo physicalExamRecordDetailMysqlPo = new PhysicalExamRecordDetailMysqlPo();
        List<PhysicalExamRecordDetailMysqlPo> physicalExamRecordDetailMysqlPos= new ArrayList<>();

        physicalExamRecordDetailMysqlPo.setRecordid(1L);

        physicalExamRecordDetailMysqlPos.add(physicalExamRecordDetailMysqlPo);

        function(physicalExamRecordDetailMysqlPos);

        physicalExamRecordDetailMysqlPos.forEach(p-> System.out.println(p.getRecordid()));

    }

    public void function(List<PhysicalExamRecordDetailMysqlPo> physicalExamRecordDetailMysqlPos){
        for (PhysicalExamRecordDetailMysqlPo physicalExamRecordDetailMysqlPo : physicalExamRecordDetailMysqlPos) {
            physicalExamRecordDetailMysqlPo.setRecordid(2L);
        }
    }


}
