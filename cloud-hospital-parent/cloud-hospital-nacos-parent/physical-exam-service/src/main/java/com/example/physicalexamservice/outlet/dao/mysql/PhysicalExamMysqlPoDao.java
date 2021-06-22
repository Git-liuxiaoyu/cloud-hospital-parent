package com.example.physicalexamservice.outlet.dao.mysql;

import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamMysqlPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalExamMysqlPoDao {
    long countByExample(PhysicalExamMysqlPoExample example);

    int deleteByExample(PhysicalExamMysqlPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PhysicalExamMysqlPo record);

    int insertSelective(PhysicalExamMysqlPo record);

    List<PhysicalExamMysqlPo> selectByExample(PhysicalExamMysqlPoExample example);

    PhysicalExamMysqlPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PhysicalExamMysqlPo record, @Param("example") PhysicalExamMysqlPoExample example);

    int updateByExample(@Param("record") PhysicalExamMysqlPo record, @Param("example") PhysicalExamMysqlPoExample example);

    int updateByPrimaryKeySelective(PhysicalExamMysqlPo record);

    int updateByPrimaryKey(PhysicalExamMysqlPo record);
}