package com.example.workerservice.outlet.dao.redis;

import com.example.workerservice.outlet.dao.redis.po.DepartmentRedisPo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 接口 - RedisPo - Department
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Repository
public interface DepartmentRedisPoDao extends CrudRepository<DepartmentRedisPo, Integer> {

    /**
     * 根据 DivisionId 和 Status 查所有
     *
     * @param divisionId
     * @param status
     * @return
     */
    List<DepartmentRedisPo> findAllByDivisionidEqualsAndStatusEquals(Integer divisionId, String status);

}
