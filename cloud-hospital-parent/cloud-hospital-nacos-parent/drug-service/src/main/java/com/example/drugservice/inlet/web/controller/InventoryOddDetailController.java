package com.example.drugservice.inlet.web.controller;

import com.example.drugservice.inlet.web.vo.DrugOddDetailVo;
import com.example.drugservice.inlet.web.vo.InventoryOddDetailVo;
import com.example.drugservice.service.query.ExampleQueryDrugOddDetailCommand;
import com.example.drugservice.service.query.ExampleQueryInventoryOddDetailCommand;
import com.example.drugservice.util.ResponseResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class InventoryOddDetailController {

    @RequestMapping(value = "/inventoryOddDetail/list/byId",method = RequestMethod.POST)
    @ApiOperation(value = "查询盘点表的详情",notes = "根据盘点表id 查询盘点详情表",produces = "application/json",response = ResponseResult.class)
    public ResponseResult<List<InventoryOddDetailVo>> list(@RequestBody ExampleQueryInventoryOddDetailCommand command){
        List<InventoryOddDetailVo> vos = command.execute();
        System.out.println(vos);
        return new ResponseResult<>(200,"success",vos);
    }

}
