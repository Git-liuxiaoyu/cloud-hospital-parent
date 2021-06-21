package com.example.drugservice.service.queryinstockodddetail;

import com.example.drugservice.inlet.web.vo.DrugInstockOddDetailVo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


public interface IExampleQueryDrugInstockOddDetailCommandHanle {
    List<DrugInstockOddDetailVo> findByInstockId(Long instockOddId);
}
