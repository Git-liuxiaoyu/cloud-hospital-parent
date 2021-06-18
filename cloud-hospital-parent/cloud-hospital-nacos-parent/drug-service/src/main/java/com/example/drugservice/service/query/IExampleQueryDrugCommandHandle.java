package com.example.drugservice.service.query;

import com.example.drugservice.inlet.web.vo.DrugVo;

import java.util.List;

public interface IExampleQueryDrugCommandHandle {
    public List<DrugVo> findList(ExampleQueryDrugCommand command);
}
