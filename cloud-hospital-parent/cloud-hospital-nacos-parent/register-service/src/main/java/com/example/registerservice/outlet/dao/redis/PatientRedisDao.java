package com.example.registerservice.outlet.dao.redis;

import com.example.registerservice.outlet.dao.redis.po.PatientRedisPo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/17/15:03
 * @Description: 存手机号的redis
 */
public interface PatientRedisDao extends CrudRepository<PatientRedisPo, String> {
}
