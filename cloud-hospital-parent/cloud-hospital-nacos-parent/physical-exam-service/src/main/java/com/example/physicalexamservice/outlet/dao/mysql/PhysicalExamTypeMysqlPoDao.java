package com.example.physicalexamservice.outlet.dao.mysql;

import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamTypeMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamTypeMysqlPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalExamTypeMysqlPoDao {
    long countByExample(PhysicalExamTypeMysqlPoExample example);

    int deleteByExample(PhysicalExamTypeMysqlPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PhysicalExamTypeMysqlPo record);

    int insertSelective(PhysicalExamTypeMysqlPo record);

    List<PhysicalExamTypeMysqlPo> selectByExample(PhysicalExamTypeMysqlPoExample example);

    PhysicalExamTypeMysqlPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PhysicalExamTypeMysqlPo record, @Param("example") PhysicalExamTypeMysqlPoExample example);

    int updateByExample(@Param("record") PhysicalExamTypeMysqlPo record, @Param("example") PhysicalExamTypeMysqlPoExample example);

    int updateByPrimaryKeySelective(PhysicalExamTypeMysqlPo record);

    int updateByPrimaryKey(PhysicalExamTypeMysqlPo record);
}