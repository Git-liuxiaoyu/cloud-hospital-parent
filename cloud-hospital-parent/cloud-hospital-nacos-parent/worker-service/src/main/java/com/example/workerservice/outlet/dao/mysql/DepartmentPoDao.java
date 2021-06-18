package com.example.workerservice.outlet.dao.mysql;

import com.example.workerservice.outlet.dao.mysql.po.DepartmentPo;
import com.example.workerservice.outlet.dao.mysql.po.DepartmentPoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentPoDao {
    long countByExample(DepartmentPoExample example);

    int deleteByExample(DepartmentPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DepartmentPo record);

    int insertSelective(DepartmentPo record);

    List<DepartmentPo> selectByExample(DepartmentPoExample example);

    DepartmentPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DepartmentPo record, @Param("example") DepartmentPoExample example);

    int updateByExample(@Param("record") DepartmentPo record, @Param("example") DepartmentPoExample example);

    int updateByPrimaryKeySelective(DepartmentPo record);

    int updateByPrimaryKey(DepartmentPo record);
}