package com.example.drugservice.inlet.web.controller;

import com.example.drugservice.inlet.web.vo.DrugOddDetailVo;
import com.example.drugservice.inlet.web.vo.InventoryOddDetailVo;
import com.example.drugservice.service.query.ExampleQueryDrugOddDetailCommand;
import com.example.drugservice.service.query.ExampleQueryInventoryOddDetailCommand;
import com.example.drugservice.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class InventoryOddDetailController {

    @RequestMapping("/inventoryOddDetail/list/byId")
    public ResponseResult<List<InventoryOddDetailVo>> list(@RequestBody ExampleQueryInventoryOddDetailCommand command){
        List<InventoryOddDetailVo> vos = command.execute();
        System.out.println(vos);
        return new ResponseResult<>(200,"success",vos);
    }

}
