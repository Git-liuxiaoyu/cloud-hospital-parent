package com.example.physicalexamservice.outlet.dao.redis;

import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamTypeRedisPo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
public interface PhysicalExamTypeRedisPoDao extends CrudRepository<PhysicalExamTypeRedisPo, Integer> {

    List<PhysicalExamTypeRedisPo> findAllByStatusEquals(String status);

}
