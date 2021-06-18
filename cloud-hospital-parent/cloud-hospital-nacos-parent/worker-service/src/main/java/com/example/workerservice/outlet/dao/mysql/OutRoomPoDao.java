package com.example.workerservice.outlet.dao.mysql;

import com.example.workerservice.outlet.dao.mysql.po.OutRoomPo;
import com.example.workerservice.outlet.dao.mysql.po.OutRoomPoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OutRoomPoDao {
    long countByExample(OutRoomPoExample example);

    int deleteByExample(OutRoomPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OutRoomPo record);

    int insertSelective(OutRoomPo record);

    List<OutRoomPo> selectByExample(OutRoomPoExample example);

    Optional<OutRoomPo> selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OutRoomPo record, @Param("example") OutRoomPoExample example);

    int updateByExample(@Param("record") OutRoomPo record, @Param("example") OutRoomPoExample example);

    int updateByPrimaryKeySelective(OutRoomPo record);

    int updateByPrimaryKey(OutRoomPo record);
}