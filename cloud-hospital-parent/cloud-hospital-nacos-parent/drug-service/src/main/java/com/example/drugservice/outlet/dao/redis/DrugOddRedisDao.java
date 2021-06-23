package com.example.drugservice.outlet.dao.redis;

import com.example.drugservice.outlet.dao.redis.po.DrugOddRedisPo;
import com.example.drugservice.outlet.dao.redis.po.DrugRedisPo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrugOddRedisDao extends CrudRepository<DrugOddRedisPo,Long> {

        public DrugOddRedisPo getAllByNo(String no);

}
