package com.example.drugservice.inlet.web.controller;

import com.example.drugservice.adapt.DrugTypeAdapt;
import com.example.drugservice.inlet.web.vo.DrugTypeVo;
import com.example.drugservice.util.ResponseResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class DrugTypeController {
    @Autowired
    private DrugTypeAdapt adapt;

 @RequestMapping(value = "/drugType/list",method = RequestMethod.POST)
 @ApiOperation(value = "查询药品类型",notes = "没有参数 直接查询所有")
 public ResponseResult<List<DrugTypeVo>> list(){
     List<DrugTypeVo> list = adapt.findList();
     return new ResponseResult<>(200,"success",list);
 }

}
