package com.example.physicalexamservice.outlet.dao.mysql;

import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordMysqlPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalExamRecordMysqlPoDao {
    long countByExample(PhysicalExamRecordMysqlPoExample example);

    int deleteByExample(PhysicalExamRecordMysqlPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhysicalExamRecordMysqlPo record);

    int insertSelective(PhysicalExamRecordMysqlPo record);

    List<PhysicalExamRecordMysqlPo> selectByExample(PhysicalExamRecordMysqlPoExample example);

    PhysicalExamRecordMysqlPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PhysicalExamRecordMysqlPo record, @Param("example") PhysicalExamRecordMysqlPoExample example);

    int updateByExample(@Param("record") PhysicalExamRecordMysqlPo record, @Param("example") PhysicalExamRecordMysqlPoExample example);

    int updateByPrimaryKeySelective(PhysicalExamRecordMysqlPo record);

    int updateByPrimaryKey(PhysicalExamRecordMysqlPo record);
}