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
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class DrugInstockOddController {

    //进货单列表
    @RequestMapping("/drug/instockOdd/list")
    public ResponseResult<PageInfo<DrugInstockOddVo>> findList(@RequestBody ExampleQueryDrugInstockOddCommand command){
        List<DrugInstockOddVo> voList = command.execute();
        PageUtils<DrugInstockOddVo> pageUtils = new PageUtils<>();
        PageInfo<DrugInstockOddVo> pageInfo = pageUtils.getPageInfo(command.getPageIndex(), command.getPageSize(), voList);
        return new ResponseResult<>(200,"success",pageInfo);
    }


    //添加进货单
    @RequestMapping("/drug/instockodd/add")
    public ResponseResult<String> add(@RequestBody AddInstockOddCommand command){
        log.info("进入{}",command);

        command.execute();
        return new ResponseResult<>(200,"success",null);
    }
    //修改状态
    @RequestMapping("/drugInstockOdd/update/byId")
    public ResponseResult<String> updateStatusById(@RequestBody UpdateDrugInstockOddCommand command){
        log.info("id={}",command.getId());
        command.execute();
        return new ResponseResult<>(200,"success","成功哦");
    }

}
