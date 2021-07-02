package com.example.physicalexamservice.outlet.dao.mysql;

import com.example.physicalexamservice.outlet.dao.mysql.po.ReceivedMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.ReceivedMysqlPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivedMysqlPoDao {
    long countByExample(ReceivedMysqlPoExample example);

    int deleteByExample(ReceivedMysqlPoExample example);

    int deleteByPrimaryKey(String messageid);

    int insert(ReceivedMysqlPo record);

    int insertSelective(ReceivedMysqlPo record);

    List<ReceivedMysqlPo> selectByExample(ReceivedMysqlPoExample example);

    int updateByExampleSelective(@Param("record") ReceivedMysqlPo record, @Param("example") ReceivedMysqlPoExample example);

    int updateByExample(@Param("record") ReceivedMysqlPo record, @Param("example") ReceivedMysqlPoExample example);
}