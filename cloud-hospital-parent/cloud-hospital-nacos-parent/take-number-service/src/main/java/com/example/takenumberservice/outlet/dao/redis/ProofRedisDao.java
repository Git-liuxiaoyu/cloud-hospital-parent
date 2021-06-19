package com.example.takenumberservice.outlet.dao.redis;


import com.example.takenumberservice.outlet.dao.redis.pojo.ProofRedisPo;
import org.springframework.data.repository.CrudRepository;


/**
 * no重复提交的redis
 */

public interface ProofRedisDao extends CrudRepository<ProofRedisPo, String> {


}
