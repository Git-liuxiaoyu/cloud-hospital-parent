package com.example.workerservice.outlet.dao.es;

import com.example.workerservice.outlet.dao.es.po.WorkerInfoEsPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/26
 */
public interface WorkerInfoEsPoDao extends ElasticsearchRepository<WorkerInfoEsPo,Integer> {
}
