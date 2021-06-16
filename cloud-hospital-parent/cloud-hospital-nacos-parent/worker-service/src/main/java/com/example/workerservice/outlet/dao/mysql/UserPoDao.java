package com.example.workerservice.outlet.dao.mysql;

import com.example.workerservice.outlet.dao.mysql.po.UserPo;
import com.example.workerservice.outlet.dao.mysql.po.UserPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPoDao {
    long countByExample(UserPoExample example);

    int deleteByExample(UserPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    List<UserPo> selectByExample(UserPoExample example);

    UserPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPo record, @Param("example") UserPoExample example);

    int updateByExample(@Param("record") UserPo record, @Param("example") UserPoExample example);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);
}