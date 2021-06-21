package com.example.drugservice.service.query;

import com.example.drugservice.inlet.web.vo.InventoryOddDetailVo;
import com.example.drugservice.inlet.web.vo.InventoryOddVo;

import java.util.List;


public interface IExampleQueryInventoryOddDetailCommandHandle {
    List<InventoryOddDetailVo> findList(ExampleQueryInventoryOddDetailCommand command);

}

