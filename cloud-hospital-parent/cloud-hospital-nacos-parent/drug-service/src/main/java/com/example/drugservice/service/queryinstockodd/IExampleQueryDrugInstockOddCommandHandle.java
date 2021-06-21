package com.example.drugservice.service.queryinstockodd;

import com.example.drugservice.inlet.web.vo.DrugInstockOddVo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


public interface IExampleQueryDrugInstockOddCommandHandle {
    List<DrugInstockOddVo> findByExample(ExampleQueryDrugInstockOddCommand command);
}
