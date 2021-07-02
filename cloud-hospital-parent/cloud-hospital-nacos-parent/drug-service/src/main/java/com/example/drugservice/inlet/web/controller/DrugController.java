package com.example.drugservice.inlet.web.controller;

import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.service.instock.InStockDrugCommand;
import com.example.drugservice.service.outstock.OutStockDrugCommand;
import com.example.drugservice.service.query.ExampleQueryDrugCommand;
import com.example.drugservice.util.PageUtils;
import com.example.drugservice.util.ResponseResult;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@ApiModel
@Api(value = "药房服务", description = "用户操作 API")
public class DrugController {

    /*查询药品列表 分页*/
    @RequestMapping(value = "/drug/list",method = RequestMethod.POST)
    @ApiOperationSupport(ignoreParameters ="handle",params = @DynamicParameters(properties = {
            @DynamicParameter(name = "no",value = "编号",example = "001")
    }))
    @ApiOperation(value = "查询药品列表",notes = "条件查询药品列表 只传pageIndex,和pageSize 就是查所有,加上药品名就是根据药品名查询,返回一个list集合")
    public ResponseResult<PageInfo<DrugVo>> findDrugList(@RequestBody ExampleQueryDrugCommand command){
        System.out.println(command);
        List<DrugVo> drugVos = command.execute();

        PageUtils<DrugVo> pageUtils = new PageUtils<>();

        PageInfo<DrugVo> pageInfo = pageUtils.getPageInfo(command.getPageIndex(), command.getPageSize(), drugVos);

        return new ResponseResult<>(200,"success",pageInfo);
    }


    /*进货 功能*/
    @RequestMapping(value = "/drug/update",method = RequestMethod.POST)
    @ApiOperation(value = "药品进货功能",notes = "根据参数新增药品或修改库存")
    @ApiOperationSupport(ignoreParameters = "handle")
    public String updateDrug( @RequestBody List<InStockDrugCommand> commands){
        log.info("commd为{}",commands);
        System.out.println(commands);
        for (InStockDrugCommand command : commands) {
            command.execute();
        }
        return "success";
    }

    /*根据编号 减库存*/
    @RequestMapping(value = "/drug/update/byno",method = RequestMethod.POST)
    @ApiOperation(value = "药品减库存功能",notes = "根据药品编号和数量减库存")
    @ApiOperationSupport(ignoreParameters = "handle")
    public ResponseResult<String> updateDrugByNo(@RequestBody OutStockDrugCommand command){
        command.execute();
        return new ResponseResult<>(200,"success","减库存成功");
    }

    @PostMapping("/drug/bytypeid")
    @ApiOperationSupport(ignoreParameters = "handle")
    public ResponseResult<List<DrugVo>> findByTypeId(@RequestBody ExampleQueryDrugCommand command){
       log.info("{}",command);
        List<DrugVo> execute = command.execute();
        log.info("{}",execute);
        return new ResponseResult(200,"success",execute);
    }
}
