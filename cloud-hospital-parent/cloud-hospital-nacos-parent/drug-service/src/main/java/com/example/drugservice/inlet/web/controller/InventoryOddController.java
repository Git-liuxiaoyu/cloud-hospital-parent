package com.example.drugservice.inlet.web.controller;

import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.InventoryOddVo;
import com.example.drugservice.service.addinventory.AddInventoryCommand;
import com.example.drugservice.service.query.ExampleQueryInventoryOddCommand;
import com.example.drugservice.service.update.UpdateDrugOddCommand;
import com.example.drugservice.service.update.UpdateInventoryOddCommand;
import com.example.drugservice.util.PageUtils;
import com.example.drugservice.util.ResponseResult;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class InventoryOddController {

    //盘点单列表
    @RequestMapping("/inventoryOdd/list")
    public ResponseResult<PageInfo<InventoryOddVo>> findList(@RequestBody ExampleQueryInventoryOddCommand command){
        List<InventoryOddVo> voList = command.execute();

        PageUtils<InventoryOddVo> pageUtils = new PageUtils<>();

        PageInfo<InventoryOddVo> pageInfo = pageUtils.getPageInfo(command.getPageIndex(), command.getPageSize(), voList);
        return new ResponseResult<>(200,"success",pageInfo);
    }


    //添加盘点单
    @RequestMapping("/inventoryOdd/add")
    //public ResponseResult<String> add(@RequestBody List<AddInventoryCommand> command){
    public ResponseResult<String> add(@RequestBody AddInventoryCommand command){
        log.info("进入");
        command.execute();
        return new ResponseResult<>(200,"success",null);
    }
    //修改状态
    @RequestMapping("/inventoryodd/update/byId")
    public ResponseResult<String> updateStatusById(@RequestBody UpdateInventoryOddCommand command){
        command.execute();
        return new ResponseResult<>(200,"success","成功哦");
    }

}
