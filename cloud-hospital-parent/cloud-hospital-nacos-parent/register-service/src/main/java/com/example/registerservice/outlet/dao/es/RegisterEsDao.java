package com.example.registerservice.outlet.dao.es;

import com.example.registerservice.outlet.dao.es.po.RegisterEsPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/25/16:48
 * @Description:
 */
@Repository
public interface RegisterEsDao extends ElasticsearchRepository<RegisterEsPo, Long> {
}
