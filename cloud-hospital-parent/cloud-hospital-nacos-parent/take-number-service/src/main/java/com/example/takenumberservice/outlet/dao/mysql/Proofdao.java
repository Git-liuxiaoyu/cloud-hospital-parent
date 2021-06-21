package com.example.takenumberservice.outlet.dao.mysql;


import com.example.takenumberservice.outlet.dao.mysql.pojo.ProofPo;
import com.example.takenumberservice.service.command.addProof.ProofCommand;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public interface ProofDao {

    int findorderNum();//查询最大排队数

    int addproof(ProofPo po);//将取票凭证存入数据库

}
