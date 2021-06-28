package com.example.workerservice.outlet.dao.es;

import com.example.workerservice.outlet.dao.es.po.DivisionEsPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/25
 */
public interface DivisionEsPoDao extends ElasticsearchRepository<DivisionEsPo, Integer> {

    List<DivisionEsPo> findByStatusEquals(String status);

}
