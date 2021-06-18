package com.example.workerservice.outlet.dao.redis;

import com.example.workerservice.outlet.dao.redis.po.DivisionRedisPo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/17
 */
@Repository
public interface DivisionRedisPoDao extends CrudRepository<DivisionRedisPo, Integer> {

    List<DivisionRedisPo> findAllByStatusEquals(String status);

}
