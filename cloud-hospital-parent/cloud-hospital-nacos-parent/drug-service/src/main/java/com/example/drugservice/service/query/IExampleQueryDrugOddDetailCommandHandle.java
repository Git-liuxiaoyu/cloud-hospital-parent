package com.example.drugservice.service.query;

import com.example.drugservice.inlet.web.vo.DrugOddDetailVo;
import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


public interface IExampleQueryDrugOddDetailCommandHandle {
    List<DrugOddDetailVo> findListByDrugOddId(Long drugoddid);
}

