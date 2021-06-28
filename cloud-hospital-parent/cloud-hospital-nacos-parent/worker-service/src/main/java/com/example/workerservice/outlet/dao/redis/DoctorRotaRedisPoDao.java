package com.example.workerservice.outlet.dao.redis;

import com.example.workerservice.outlet.dao.redis.po.DoctorRotaRedisPo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 接口 - Redis - DoctorRotaRedisPoDao
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Repository
public interface DoctorRotaRedisPoDao extends CrudRepository<DoctorRotaRedisPo, Long> {

    List<DoctorRotaRedisPo> findAllByStatusEqualsAndDepartmentidEqualsAndDateEquals(String status, Integer departmentid, Date date);





}
