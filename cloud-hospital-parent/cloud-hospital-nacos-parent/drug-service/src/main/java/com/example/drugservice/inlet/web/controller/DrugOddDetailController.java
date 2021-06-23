package com.example.drugservice.inlet.web.controller;

import com.example.drugservice.adapt.DrugTypeAdapt;
import com.example.drugservice.inlet.web.vo.DrugOddDetailVo;
import com.example.drugservice.inlet.web.vo.DrugTypeVo;
import com.example.drugservice.service.query.ExampleQueryDrugOddDetailCommand;
import com.example.drugservice.util.ResponseResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class DrugOddDetailController {


 @RequestMapping(value = "drugoddDetail/list/byId",method = RequestMethod.POST)
 @ApiOperation(value = "根据进货单id修改状态",notes = "传一个进货单id,修改状态,表示通过审核")
 public ResponseResult<List<DrugOddDetailVo>> list(@RequestBody ExampleQueryDrugOddDetailCommand command){
     List<DrugOddDetailVo> vos = command.execute();
     return new ResponseResult<>(200,"success",vos);
 }

}
