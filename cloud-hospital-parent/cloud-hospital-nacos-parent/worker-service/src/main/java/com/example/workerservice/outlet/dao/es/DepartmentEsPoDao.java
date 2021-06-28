package com.example.workerservice.outlet.dao.es;

import com.example.workerservice.outlet.dao.es.po.DepartmentEsPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 注解 - EsPoDao - Department
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/25
 */
public interface DepartmentEsPoDao extends ElasticsearchRepository<DepartmentEsPo, Integer> {

    List<DepartmentEsPo> findAllByStatusEqualsAndDivisionidEquals(String status, Integer divisionId);

}
