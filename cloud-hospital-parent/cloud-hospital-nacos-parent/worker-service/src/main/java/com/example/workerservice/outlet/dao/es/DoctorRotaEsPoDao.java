package com.example.workerservice.outlet.dao.es;

import com.example.workerservice.outlet.dao.es.po.DoctorRotaEsPo;
import com.example.workerservice.outlet.dao.redis.po.DoctorRotaRedisPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Date;
import java.util.List;

/**
 * 接口 - DoctorRotaEsPoDao
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/26
 */
public interface DoctorRotaEsPoDao extends ElasticsearchRepository<DoctorRotaEsPo, Long> {

    List<DoctorRotaEsPo> findAllByDateEqualsAndDepartmentidEqualsAndStatusEquals(Date date, Integer departmentId, String status);

    List<DoctorRotaEsPo> findAllByStatusEqualsAndDepartmentidEqualsAndDateEqualsAndShifttypeEquals(String status, Integer departmentid, Date date, String shiftType);

}
