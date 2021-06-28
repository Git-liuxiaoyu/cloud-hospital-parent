package com.example.workerservice.outlet.dao.es;

import com.example.workerservice.outlet.dao.es.po.PositionEsPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/26
 */
public interface PositionEsPoDao extends ElasticsearchRepository<PositionEsPo, Integer> {
}
