package com.example.drugservice.inlet.web.controller;

import com.example.drugservice.adapt.DrugOddAdapt;
import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.service.query.ExampleQueryDrugOddCommand;
import com.example.drugservice.service.update.UpdateDrugOddCommand;
import com.example.drugservice.util.PageUtils;
import com.example.drugservice.util.ResponseResult;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class DrugOddController {

    @RequestMapping("/drugodd/list")
    public ResponseResult<PageInfo<DrugOddVo>> findList(@RequestBody ExampleQueryDrugOddCommand command){
        System.out.println(command);

        List<DrugOddVo> drugOddVos = command.execute();

        PageUtils<DrugOddVo> pageUtils = new PageUtils<>();

        PageInfo<DrugOddVo> pageInfo = pageUtils.getPageInfo(command.getPageIndex(), command.getPageSize(), drugOddVos);

        return new ResponseResult<>(200,"success",pageInfo);
    }

    //修改药品单状态
    @RequestMapping("/drugodd/update/byId")
    public ResponseResult<String> updateStatusById(@RequestBody UpdateDrugOddCommand command){
        command.execute();
        return new ResponseResult<>(200,"success","成功哦");
    }

}
