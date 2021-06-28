package com.example.drugservice.inlet.web.controller;

import com.example.drugservice.adapt.DrugOddAdapt;
import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.service.add.AddDrugOddCommand;
import com.example.drugservice.service.query.ExampleQueryDrugOddCommand;
import com.example.drugservice.service.update.UpdateDrugOddCommand;
import com.example.drugservice.util.PageUtils;
import com.example.drugservice.util.ResponseResult;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class DrugOddController {

    @RequestMapping(value = "/drugodd/list",method = RequestMethod.POST)
    @ApiOperation(value = "查询药品单集合",notes = "分页条件查询药品单集合,可以传一个药品单编号 来查询集合,还要传pageindex和pageSize表示查询第几页每页几条数据")
    @ApiOperationSupport(ignoreParameters = "handle")
    public ResponseResult<PageInfo<DrugOddVo>> findList(@RequestBody ExampleQueryDrugOddCommand command){
        List<DrugOddVo> drugOddVos = command.execute();
        PageUtils<DrugOddVo> pageUtils = new PageUtils<>();
        PageInfo<DrugOddVo> pageInfo = pageUtils.getPageInfo(command.getPageIndex(), command.getPageSize(), drugOddVos);
        return new ResponseResult<>(200,"success",pageInfo);
    }

    //修改药品单状态
    @RequestMapping(value = "/drugodd/update/byId",method = RequestMethod.POST)
    @ApiOperation(value = "根据药品单id修改状态",notes = "传一个药品单id,修改状态,表示通过审核")
    public ResponseResult<String> updateStatusById(@RequestBody UpdateDrugOddCommand command){
        command.execute();
        return new ResponseResult<>(200,"success","成功哦");
    }

    //添加药品单
    @RequestMapping(value = "/drugodd/add",method = RequestMethod.POST)
    @ApiOperation(value = "添加药品单",notes = "要传一个对象,对象里有添加药品的人,添加时间,对象里面还有个集合里面是添加了哪些药")
    public ResponseResult<Long> addDrugOdd(@RequestBody AddDrugOddCommand command){
        log.info("药房接收到的参数"+command);
         Long drugOddId = command.execute();
         log.info("返回给门诊的药品单id为{}",drugOddId);
        return  new ResponseResult<>(200,"success",drugOddId);
    }

    //根据编号查询药品单
    @RequestMapping(value = "/drugOdd/byNo/{no}",method = RequestMethod.GET)
    @ApiOperation(value = "根据编号查询药品单对象",notes = "根据药品单编号,查询这个编号存不存在,不存在就返回500,存在返回200")
    public ResponseResult<Void> getByNo(@PathVariable String no){
        ExampleQueryDrugOddCommand command =new ExampleQueryDrugOddCommand();
        command.setNo(no);
        DrugOddVo vo = command.getByNo();
        if (vo==null){
            return new ResponseResult<>(500,"success",null);
        }
        return new ResponseResult<>(200,"success",null);
    }


}
