package com.example.physicalexamservice.outlet.dao.es;

import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamEsPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/28
 */

public interface PhysicalExamEsPoDao extends ElasticsearchRepository<PhysicalExamEsPo, Integer> {

    List<PhysicalExamEsPo> findAllByStatusEquals(String status);


    List<PhysicalExamEsPo> findAllByStatusEqualsAndTypeidEquals(String status, Integer typeId);
}
