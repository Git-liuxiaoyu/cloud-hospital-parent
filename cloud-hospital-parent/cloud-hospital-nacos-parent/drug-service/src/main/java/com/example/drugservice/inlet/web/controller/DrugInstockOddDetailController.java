package com.example.drugservice.inlet.web.controller;

import com.example.drugservice.inlet.web.vo.DrugInstockOddDetailVo;
import com.example.drugservice.inlet.web.vo.InventoryOddDetailVo;
import com.example.drugservice.service.query.ExampleQueryInventoryOddDetailCommand;
import com.example.drugservice.service.queryinstockodddetail.ExampleQueryDrugInstockOddDetailCommand;
import com.example.drugservice.util.ResponseResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class DrugInstockOddDetailController {

    @RequestMapping(value = "/instockOddDetail/list/byId",method = RequestMethod.POST)
    @ApiOperation(value = "查询进货单详情",notes = "根据传一个进货单id,查询这个进货单里面进了哪些药")
    public ResponseResult<List<DrugInstockOddDetailVo>> list(@RequestBody ExampleQueryDrugInstockOddDetailCommand command){
        log.info("id={}",command.getInstockOddId());
        List<DrugInstockOddDetailVo> vos = command.execute();
        System.out.println(vos);
        return new ResponseResult<>(200,"success",vos);
    }

}
