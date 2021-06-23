package com.example.drugservice.outlet.dao.es;

import com.example.drugservice.outlet.dao.es.po.DrugInstockOddEsPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DrugInstockOddEsDao extends ElasticsearchRepository<DrugInstockOddEsPo,String> {


}
