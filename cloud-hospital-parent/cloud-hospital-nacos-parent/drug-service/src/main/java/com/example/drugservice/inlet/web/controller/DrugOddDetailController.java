package com.example.drugservice.inlet.web.controller;

import com.example.drugservice.adapt.DrugTypeAdapt;
import com.example.drugservice.inlet.web.vo.DrugOddDetailVo;
import com.example.drugservice.inlet.web.vo.DrugTypeVo;
import com.example.drugservice.service.query.ExampleQueryDrugOddDetailCommand;
import com.example.drugservice.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class DrugOddDetailController {


 @RequestMapping("drugoddDetail/list/byId")
    public ResponseResult<List<DrugOddDetailVo>> list(@RequestBody ExampleQueryDrugOddDetailCommand command){
     List<DrugOddDetailVo> vos = command.execute();
     return new ResponseResult<>(200,"success",vos);
 }

}
