package com.example.physicalexamservice.outlet.dao.redis;

import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamRedisPo;
import io.swagger.models.auth.In;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
public interface PhysicalExamRedisPoDao extends CrudRepository<PhysicalExamRedisPo, Integer> {

    List<PhysicalExamRedisPo> findAllByStatusEquals(String status);

}
