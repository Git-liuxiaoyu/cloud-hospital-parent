package com.example.physicalexamservice.outlet.dao.es;

import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordEsPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 接口 - EsPoDao
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
public interface PhysicalExamRecordEsPoDao extends ElasticsearchRepository<PhysicalExamRecordEsPo, Long> {

    /* 根据No */
    PhysicalExamRecordEsPo findByNoEquals(String no);

}
