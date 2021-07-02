package com.example.physicalexamservice.outlet.dao.mysql;

import com.example.physicalexamservice.outlet.dao.mysql.po.MessageMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.MessageMysqlPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageMysqlPoDao {
    long countByExample(MessageMysqlPoExample example);

    int deleteByExample(MessageMysqlPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MessageMysqlPo record);

    int insertSelective(MessageMysqlPo record);

    List<MessageMysqlPo> selectByExample(MessageMysqlPoExample example);

    MessageMysqlPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageMysqlPo record, @Param("example") MessageMysqlPoExample example);

    int updateByExample(@Param("record") MessageMysqlPo record, @Param("example") MessageMysqlPoExample example);

    int updateByPrimaryKeySelective(MessageMysqlPo record);

    int updateByPrimaryKey(MessageMysqlPo record);
}