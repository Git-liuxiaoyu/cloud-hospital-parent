package com.example.workerservice.outlet.dao.mysql;

import com.example.workerservice.outlet.dao.mysql.po.UserPo;
import com.example.workerservice.outlet.dao.mysql.po.UserPoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPoDao {
    long countByExample(UserPoExample example);

    int deleteByExample(UserPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    Optional<UserPo> login(@Param("account") String account,@Param("password") String password);

    List<UserPo> selectByExample(UserPoExample example);

    UserPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPo record, @Param("example") UserPoExample example);

    int updateByExample(@Param("record") UserPo record, @Param("example") UserPoExample example);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);
}