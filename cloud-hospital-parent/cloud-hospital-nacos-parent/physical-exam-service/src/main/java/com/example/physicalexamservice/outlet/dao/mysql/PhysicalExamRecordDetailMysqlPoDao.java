package com.example.physicalexamservice.outlet.dao.mysql;

import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordDetailMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordDetailMysqlPoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhysicalExamRecordDetailMysqlPoDao {
    long countByExample(PhysicalExamRecordDetailMysqlPoExample example);

    int deleteByExample(PhysicalExamRecordDetailMysqlPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhysicalExamRecordDetailMysqlPo record);

    int insertSelective(PhysicalExamRecordDetailMysqlPo record);

    List<PhysicalExamRecordDetailMysqlPo> selectByExample(PhysicalExamRecordDetailMysqlPoExample example);

    PhysicalExamRecordDetailMysqlPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PhysicalExamRecordDetailMysqlPo record, @Param("example") PhysicalExamRecordDetailMysqlPoExample example);

    int updateByExample(@Param("record") PhysicalExamRecordDetailMysqlPo record, @Param("example") PhysicalExamRecordDetailMysqlPoExample example);

    int updateByPrimaryKeySelective(PhysicalExamRecordDetailMysqlPo record);

    int updateByPrimaryKey(PhysicalExamRecordDetailMysqlPo record);
}