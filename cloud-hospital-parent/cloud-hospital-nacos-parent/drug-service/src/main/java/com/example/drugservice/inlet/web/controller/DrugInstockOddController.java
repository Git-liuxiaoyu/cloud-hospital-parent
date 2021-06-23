package com.example.drugservice.inlet.web.controller;

import com.example.drugservice.inlet.web.vo.DrugInstockOddVo;
import com.example.drugservice.inlet.web.vo.InventoryOddVo;
import com.example.drugservice.service.addinstockodd.AddInstockOddCommand;
import com.example.drugservice.service.addinventory.AddInventoryCommand;
import com.example.drugservice.service.query.ExampleQueryInventoryOddCommand;
import com.example.drugservice.service.queryinstockodd.ExampleQueryDrugInstockOddCommand;
import com.example.drugservice.service.update.UpdateDrugInstockOddCommand;
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
public class DrugInstockOddController {

    //进货单列表
    @RequestMapping(value = "/drug/instockOdd/list",method = RequestMethod.POST)
    @ApiOperation(value = "查询进货单列表",notes = "条件查询进货列表 只传pageIndex,和pageSize 就是查所有,传编号就是根据编号查,返回一个list集合")
    public ResponseResult<PageInfo<DrugInstockOddVo>> findList(@RequestBody ExampleQueryDrugInstockOddCommand command){
        List<DrugInstockOddVo> voList = command.execute();
        PageUtils<DrugInstockOddVo> pageUtils = new PageUtils<>();
        PageInfo<DrugInstockOddVo> pageInfo = pageUtils.getPageInfo(command.getPageIndex(), command.getPageSize(), voList);
        return new ResponseResult<>(200,"success",pageInfo);
    }


    //添加进货单
    @RequestMapping(value = "/drug/instockodd/add",method = RequestMethod.POST)
    @ApiOperation(value = "添加进货单",notes = "把参数添加到进货单里,需要传一个对象 对象里有个集合 集合装的是进的药品属性")
    public ResponseResult<String> add(@RequestBody AddInstockOddCommand command){
        log.info("进入{}",command);

        command.execute();
        return new ResponseResult<>(200,"success",null);
    }
    //修改状态
    @RequestMapping(value = "/drugInstockOdd/update/byId",method = RequestMethod.POST)
    @ApiOperation(value = "根据进货单id修改状态",notes = "传一个进货单id,修改状态,表示通过审核")
    public ResponseResult<String> updateStatusById(@RequestBody UpdateDrugInstockOddCommand command){
        log.info("id={}",command.getId());
        command.execute();
        return new ResponseResult<>(200,"success","成功哦");
    }

}
