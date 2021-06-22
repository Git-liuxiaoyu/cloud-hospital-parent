package com.example.workerservice.outlet.dao.redis;

import com.example.workerservice.outlet.dao.redis.po.OutRoomRedisPo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 接口 - RedisPoDao - OutRoomRedisPo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Repository
public interface OutRoomRedisPoDao extends CrudRepository<OutRoomRedisPo,Long> {

    List<OutRoomRedisPo> findAllByDepartmentidEqualsAndStatusEquals(Integer departmentId,String status);

}
