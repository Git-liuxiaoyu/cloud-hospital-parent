package com.example.drugservice.service.query;

import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.InventoryOddVo;
import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


public interface IExampleQueryInventoryOddCommandHandle {
    List<InventoryOddVo> findList(ExampleQueryInventoryOddCommand command);
}

