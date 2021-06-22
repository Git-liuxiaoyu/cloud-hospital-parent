package com.example.takenumberservice.outlet.dao.redis;

import com.example.takenumberservice.outlet.dao.redis.pojo.PharmacyRedisPo;
import com.example.takenumberservice.outlet.dao.redis.pojo.ProofRedisPo;
import org.springframework.data.repository.CrudRepository;

public interface PharmacyRedisDao extends CrudRepository<PharmacyRedisPo, String> {

}
