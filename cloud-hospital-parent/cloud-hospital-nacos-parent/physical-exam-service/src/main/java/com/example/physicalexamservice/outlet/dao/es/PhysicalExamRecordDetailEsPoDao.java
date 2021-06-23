package com.example.physicalexamservice.outlet.dao.es;

import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordDetailEsPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
public interface PhysicalExamRecordDetailEsPoDao extends ElasticsearchRepository<PhysicalExamRecordDetailEsPo,Long> {
}
