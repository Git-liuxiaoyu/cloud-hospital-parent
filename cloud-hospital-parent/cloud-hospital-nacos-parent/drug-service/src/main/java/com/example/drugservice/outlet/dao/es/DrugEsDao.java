package com.example.drugservice.outlet.dao.es;

import com.example.drugservice.outlet.dao.es.po.DrugEsPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface DrugEsDao extends ElasticsearchRepository<DrugEsPo,String> {
    public List<DrugEsPo> findAllByNo(String no);
    public List<DrugEsPo> findAllByName(String name);
    public List<DrugEsPo> findAll();

    public DrugEsPo getAllByNo(String no);
}
