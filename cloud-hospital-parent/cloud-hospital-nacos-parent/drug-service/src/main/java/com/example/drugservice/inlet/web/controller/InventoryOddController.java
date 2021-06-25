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
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class InventoryOddController {

    //盘点单列表
    @RequestMapping(value = "/inventoryOdd/list",method = RequestMethod.POST)
    @ApiOperation(value = "药品盘点列表",notes = "根据条件查询所有盘点表单,可以传no,pageIndex,pageSize")
    public ResponseResult<PageInfo<InventoryOddVo>> findList(@RequestBody ExampleQueryInventoryOddCommand command){
        List<InventoryOddVo> voList = command.execute();

        PageUtils<InventoryOddVo> pageUtils = new PageUtils<>();

        PageInfo<InventoryOddVo> pageInfo = pageUtils.getPageInfo(command.getPageIndex(), command.getPageSize(), voList);
        return new ResponseResult<>(200,"success",pageInfo);
    }


    //添加盘点单
    @RequestMapping(value = "/inventoryOdd/add",method = RequestMethod.POST)
    @ApiOperation(value = "添加数据到盘点表和盘点详情表",notes = "传一个对象,里面有一个集合,集合的参数会存入详情表,不在集合里的参数会存入盘点表里")
    //public ResponseResult<String> add(@RequestBody List<AddInventoryCommand> command){
    public ResponseResult<String> add(@RequestBody AddInventoryCommand command){
        log.info("进入");
        command.execute();
        return new ResponseResult<>(200,"success",null);
    }
    //修改状态
    @RequestMapping(value = "/inventoryodd/update/byId",method = RequestMethod.POST)
    @ApiOperation(value = "修改盘点表的状态",notes = "传一个盘点表id 修改状态,表示审核通过,审核通过会对药品单的库存进行修改")
    public ResponseResult<String> updateStatusById(@RequestBody UpdateInventoryOddCommand command){
        command.execute();
        return new ResponseResult<>(200,"success","成功哦");
    }

}
