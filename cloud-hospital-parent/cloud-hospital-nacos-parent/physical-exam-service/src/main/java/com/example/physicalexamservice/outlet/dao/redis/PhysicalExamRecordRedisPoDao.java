package com.example.physicalexamservice.outlet.dao.redis;

import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamRecordRedisPo;
import org.springframework.data.repository.CrudRepository;

/**
 * 接口 - RedisPoDao
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
public interface PhysicalExamRecordRedisPoDao extends CrudRepository<PhysicalExamRecordRedisPo,Long> {

    PhysicalExamRecordRedisPo findByNoEquals(String no);

}
