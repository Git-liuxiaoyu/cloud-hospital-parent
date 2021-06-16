package com.example.takenumberservice.outlet.dao.mysql;

import com.example.takenumberservice.outlet.dao.mysql.pojo.Proof;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ProofDao {

    @Select("select * from h_call_proof where regId = #{regId}")
    Proof findbyregId (Integer regId);//根据挂号id查询取票信息



}
