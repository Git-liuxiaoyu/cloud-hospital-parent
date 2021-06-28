package com.example.workerservice.outlet.dao.mysql;

import com.example.workerservice.outlet.dao.mysql.po.MessagePo;
import com.example.workerservice.outlet.dao.mysql.po.MessagePoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessagePoDao {
    long countByExample(MessagePoExample example);

    int deleteByExample(MessagePoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MessagePo record);

    int insertSelective(MessagePo record);

    List<MessagePo> selectByExample(MessagePoExample example);

    MessagePo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessagePo record, @Param("example") MessagePoExample example);

    int updateByExample(@Param("record") MessagePo record, @Param("example") MessagePoExample example);

    int updateByPrimaryKeySelective(MessagePo record);

    int updateByPrimaryKey(MessagePo record);
}