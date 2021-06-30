package com.example.outpatientservice.outlet.dao.mysql;

import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientCasesPo;
import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientCasesPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OutPatientCasesDao {
    long countByExample(OutPatientCasesPoExample example);

    int deleteByExample(OutPatientCasesPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OutPatientCasesPo record);

    int insertSelective(OutPatientCasesPo record);

    List<OutPatientCasesPo> selectByExample(OutPatientCasesPoExample example);

    OutPatientCasesPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OutPatientCasesPo record, @Param("example") OutPatientCasesPoExample example);

    int updateByExample(@Param("record") OutPatientCasesPo record, @Param("example") OutPatientCasesPoExample example);

    int updateByPrimaryKeySelective(OutPatientCasesPo record);

    int updateByPrimaryKey(OutPatientCasesPo record);
}