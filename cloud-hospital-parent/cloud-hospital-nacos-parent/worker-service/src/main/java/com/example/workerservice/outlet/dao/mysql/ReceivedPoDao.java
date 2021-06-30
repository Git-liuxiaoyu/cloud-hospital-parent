package com.example.workerservice.outlet.dao.mysql;

import com.example.workerservice.outlet.dao.mysql.po.ReceivedPo;
import com.example.workerservice.outlet.dao.mysql.po.ReceivedPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivedPoDao {
    long countByExample(ReceivedPoExample example);

    int deleteByExample(ReceivedPoExample example);

    int deleteByPrimaryKey(String messageid);

    int insert(ReceivedPo record);

    int insertSelective(ReceivedPo record);

    List<ReceivedPo> selectByExample(ReceivedPoExample example);

    int updateByExampleSelective(@Param("record") ReceivedPo record, @Param("example") ReceivedPoExample example);

    int updateByExample(@Param("record") ReceivedPo record, @Param("example") ReceivedPoExample example);
}