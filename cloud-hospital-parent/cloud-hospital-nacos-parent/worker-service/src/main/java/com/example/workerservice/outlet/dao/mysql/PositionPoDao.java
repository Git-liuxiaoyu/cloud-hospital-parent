package com.example.workerservice.outlet.dao.mysql;

import com.example.workerservice.outlet.dao.mysql.po.PositionPo;
import com.example.workerservice.outlet.dao.mysql.po.PositionPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionPoDao {
    long countByExample(PositionPoExample example);

    int deleteByExample(PositionPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PositionPo record);

    int insertSelective(PositionPo record);

    List<PositionPo> selectByExample(PositionPoExample example);

    PositionPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PositionPo record, @Param("example") PositionPoExample example);

    int updateByExample(@Param("record") PositionPo record, @Param("example") PositionPoExample example);

    int updateByPrimaryKeySelective(PositionPo record);

    int updateByPrimaryKey(PositionPo record);
}