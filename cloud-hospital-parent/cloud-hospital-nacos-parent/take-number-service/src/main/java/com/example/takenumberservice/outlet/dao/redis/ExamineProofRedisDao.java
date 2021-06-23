package com.example.takenumberservice.outlet.dao.redis;

import com.example.takenumberservice.outlet.dao.redis.pojo.ExamineProofRedisPo;
import com.example.takenumberservice.outlet.dao.redis.pojo.ProofRedisPo;
import org.springframework.data.repository.CrudRepository;

public interface ExamineProofRedisDao extends CrudRepository<ExamineProofRedisPo, String> {


}
