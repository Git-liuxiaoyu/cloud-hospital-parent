package com.example.registerservice.outlet.dao.mysql;

import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPo;
import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterMysqlDao {
    long countByExample(RegisterMysqlPoExample example);

    int deleteByExample(RegisterMysqlPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RegisterMysqlPo record);

    int insertSelective(RegisterMysqlPo record);

    List<RegisterMysqlPo> selectByExample(RegisterMysqlPoExample example);

    RegisterMysqlPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RegisterMysqlPo record, @Param("example") RegisterMysqlPoExample example);

    int updateByExample(@Param("record") RegisterMysqlPo record, @Param("example") RegisterMysqlPoExample example);

    int updateByPrimaryKeySelective(RegisterMysqlPo record);

    int updateByPrimaryKey(RegisterMysqlPo record);
}