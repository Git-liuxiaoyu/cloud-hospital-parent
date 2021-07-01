package com.example.registerservice.outlet.dao.redis;

import com.example.registerservice.outlet.dao.redis.po.PatientRedisPo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/25/14:50
 * @Description: 存患者的redis
 */
public interface PatientRedisDao extends CrudRepository<PatientRedisPo, Long> {

//    void deleteById(Long id);
}
