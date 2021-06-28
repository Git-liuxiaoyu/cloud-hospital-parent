package com.example.drugservice.outlet.dao.mysql;

import com.example.drugservice.outlet.dao.mysql.po.ReceivedPo;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivedDao {
    int deleteByPrimaryKey(String messageid);

    int insert(ReceivedPo record);

    int insertSelective(ReceivedPo record);
}