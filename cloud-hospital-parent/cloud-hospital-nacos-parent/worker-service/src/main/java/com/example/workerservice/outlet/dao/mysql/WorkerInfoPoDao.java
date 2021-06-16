package com.example.workerservice.outlet.dao.mysql;

import com.example.workerservice.outlet.dao.mysql.po.WorkerInfoPo;
import com.example.workerservice.outlet.dao.mysql.po.WorkerInfoPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkerInfoPoDao {
    long countByExample(WorkerInfoPoExample example);

    int deleteByExample(WorkerInfoPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkerInfoPo record);

    int insertSelective(WorkerInfoPo record);

    List<WorkerInfoPo> selectByExample(WorkerInfoPoExample example);

    WorkerInfoPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkerInfoPo record, @Param("example") WorkerInfoPoExample example);

    int updateByExample(@Param("record") WorkerInfoPo record, @Param("example") WorkerInfoPoExample example);

    int updateByPrimaryKeySelective(WorkerInfoPo record);

    int updateByPrimaryKey(WorkerInfoPo record);
}