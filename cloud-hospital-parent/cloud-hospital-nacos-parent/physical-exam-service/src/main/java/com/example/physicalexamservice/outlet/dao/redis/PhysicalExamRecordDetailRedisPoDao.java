package com.example.physicalexamservice.outlet.dao.redis;

import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamRecordDetailRedisPo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 接口 - RedisPoDao - PhysicalExamRecordDetail
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
public interface PhysicalExamRecordDetailRedisPoDao extends CrudRepository<PhysicalExamRecordDetailRedisPo, Long> {

    List<PhysicalExamRecordDetailRedisPo> findAllByRecordidEquals(Long recordId);

}
