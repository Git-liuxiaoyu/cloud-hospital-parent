package com.example.drugservice.inlet.web.controller;

import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.service.instock.InStockDrugCommand;
import com.example.drugservice.service.outstock.OutStockDrugCommand;
import com.example.drugservice.service.query.ExampleQueryDrugCommand;
import com.example.drugservice.util.PageUtils;
import com.example.drugservice.util.ResponseResult;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class DrugController {

    /*查询药品列表 分页*/
    @RequestMapping("/drug/list")
    public ResponseResult<PageInfo<DrugVo>> findDrugList(@RequestBody ExampleQueryDrugCommand command){
        System.out.println(command);
        List<DrugVo> drugVos = command.execute();

        PageUtils<DrugVo> pageUtils = new PageUtils<>();

        PageInfo<DrugVo> pageInfo = pageUtils.getPageInfo(command.getPageIndex(), command.getPageSize(), drugVos);

        return new ResponseResult<>(200,"success",pageInfo);
    }

    @RequestMapping("/")
    public String index(){
        InStockDrugCommand command = new InStockDrugCommand();
        command.setName("yy");
        System.out.println(command);
        return "666";
    }

    /*进货 功能*/
    @RequestMapping(value = "/drug/update",method = RequestMethod.POST)
    public String updateDrug( @RequestBody List<InStockDrugCommand> commands){
        System.out.println(commands);
        for (InStockDrugCommand command : commands) {
            command.execute();
        }
        return "success";
    }

    /*根据编号 减库存*/
    @RequestMapping("/drug/update/byno")
    public ResponseResult<String> updateDrugByNo(@RequestBody OutStockDrugCommand command){
        command.execute();
        return new ResponseResult<>(200,"success","减库存成功");
    }
}
