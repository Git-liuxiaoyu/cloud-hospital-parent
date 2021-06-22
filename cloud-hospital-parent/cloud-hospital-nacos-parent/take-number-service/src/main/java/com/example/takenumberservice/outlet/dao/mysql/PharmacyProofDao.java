package com.example.takenumberservice.outlet.dao.mysql;

import com.example.takenumberservice.outlet.dao.mysql.pojo.PharmacyProofPo;
import com.example.takenumberservice.outlet.dao.mysql.pojo.ProofPo;
import org.springframework.stereotype.Repository;

/**
 * 访问数据库
 */
@Repository
public interface PharmacyProofDao {

    int findorderNum();//查询最大排队数

    int addproof(PharmacyProofPo po);//将取票凭证存入数据库

    void delete();//每晚12点清除整张表数据



}
