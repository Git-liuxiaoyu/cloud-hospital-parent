package com.example.drugservice.outlet.dao.redis;

import com.example.drugservice.outlet.dao.redis.po.DrugRedisPo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrugRedisDao extends CrudRepository<DrugRedisPo,Long> {

    List<DrugRedisPo> findAllByNameAndNoAndLocation(String name,String no,String location,Integer typeid);

    DrugRedisPo getAllByNameAndLocation(String name,String location);

    DrugRedisPo getAllByNo(String no);



    int deleteByNo(String no);

}
