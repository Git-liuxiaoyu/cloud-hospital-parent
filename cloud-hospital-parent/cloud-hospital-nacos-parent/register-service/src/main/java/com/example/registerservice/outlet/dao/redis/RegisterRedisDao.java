package com.example.registerservice.outlet.dao.redis;

import com.example.registerservice.outlet.dao.redis.po.RegisterRedisPo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/25/14:51
 * @Description:存挂号订单的redis
 */
public interface RegisterRedisDao extends CrudRepository<RegisterRedisPo, Long> {
}
