package com.example.registerservice.outlet.dao.mysql;

import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMysqlDao {
    long countByExample(PatientMysqlPoExample example);

    int deleteByExample(PatientMysqlPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PatientMysqlPo record);

    int insertSelective(PatientMysqlPo record);

    List<PatientMysqlPo> selectByExample(PatientMysqlPoExample example);

    PatientMysqlPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PatientMysqlPo record, @Param("example") PatientMysqlPoExample example);

    int updateByExample(@Param("record") PatientMysqlPo record, @Param("example") PatientMysqlPoExample example);

    int updateByPrimaryKeySelective(PatientMysqlPo record);

    int updateByPrimaryKey(PatientMysqlPo record);
}