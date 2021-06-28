package com.example.drugservice.service.query;

import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.DrugVo;

import java.util.List;

public interface IExampleQueryDrugOddCommandHandle {
    public List<DrugOddVo> findList(ExampleQueryDrugOddCommand command);

    public DrugOddVo getByNo(String no);

    void updateById(Long drugOddId);
}
