package com.example.takenumberservice.outlet.dao.mysql;

import com.example.takenumberservice.outlet.dao.mysql.pojo.ExamineProofPo;
import com.example.takenumberservice.outlet.dao.mysql.pojo.PharmacyProofPo;
import org.springframework.stereotype.Repository;


@Repository
public interface ExamineProofDao {

    int findorderNum(String type);//根据检查类型查询最大排队数

    int addproof(ExamineProofPo po);//将取票凭证存入数据库

    void delete();//每晚12点清除整张表数据
}
