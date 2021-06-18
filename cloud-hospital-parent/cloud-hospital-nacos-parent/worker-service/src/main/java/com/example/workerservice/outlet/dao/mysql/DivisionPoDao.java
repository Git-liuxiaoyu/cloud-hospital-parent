package com.example.workerservice.outlet.dao.mysql;

import com.example.workerservice.outlet.dao.mysql.po.DivisionPo;
import com.example.workerservice.outlet.dao.mysql.po.DivisionPoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DivisionPoDao {
    long countByExample(DivisionPoExample example);

    int deleteByExample(DivisionPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DivisionPo record);

    int insertSelective(DivisionPo record);

    List<DivisionPo> selectByExample(DivisionPoExample example);

    DivisionPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DivisionPo record, @Param("example") DivisionPoExample example);

    int updateByExample(@Param("record") DivisionPo record, @Param("example") DivisionPoExample example);

    int updateByPrimaryKeySelective(DivisionPo record);

    int updateByPrimaryKey(DivisionPo record);
}