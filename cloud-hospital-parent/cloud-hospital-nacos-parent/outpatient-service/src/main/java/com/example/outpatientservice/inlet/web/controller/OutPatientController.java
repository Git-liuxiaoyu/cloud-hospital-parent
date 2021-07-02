package com.example.outpatientservice.inlet.web.controller;

import com.example.outpatientservice.inlet.web.exception.WebException;
import com.example.outpatientservice.inlet.web.vo.OutPatientVo;
import com.example.outpatientservice.service.add.AddOutPatientRecordCommand;
import com.example.outpatientservice.service.query.ExampleQueryOutPatientCommand;
import com.example.outpatientservice.service.update.UpdateOutPatientCommand;
import com.example.outpatientservice.util.PageUtils;
import com.example.outpatientservice.util.ResponseResult;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class OutPatientController {

    @PostMapping("/outpatient/list")
    @ApiOperationSupport(ignoreParameters = "handle")
    @ApiOperation(value = "门诊患者列表",notes = "根据条件查询,不传参数就是查所以,要传pageIndex和pageSize")
    public ResponseResult<PageInfo<OutPatientVo>> findByExample(@RequestBody ExampleQueryOutPatientCommand command){
        List<OutPatientVo> voList = command.execute();
        log.info("{}",voList);
        PageUtils<OutPatientVo> pageUtils = new PageUtils<>();
        PageInfo<OutPatientVo> pageInfo = pageUtils.getPageInfo(command.getPageIndex(), command.getPageSize(), voList);
        return new ResponseResult<>(200,"success",pageInfo);
    }

    @PostMapping("/outPatient/byPatientId")
    @ApiOperation(value = "查询门诊患者对象",notes = "根据患者id查询患者")
    @ApiOperationSupport(ignoreParameters = "handle")
    public ResponseResult<OutPatientVo> getByPatientId(@RequestBody ExampleQueryOutPatientCommand command){
        OutPatientVo vo = command.getById();
        return new ResponseResult<>(200,"success",vo);
    }

//    @PostMapping("/outPatient/add/record")
//    public ResponseResult<String> addRecord(@RequestBody AddOutPatientRecordCommand command){
//        log.info("command为{}",command);
//        return new ResponseResult<>(200,"success",null);
//    }

    //过号修改状态
    @PostMapping("/outpatient/update")
    @ApiOperationSupport(ignoreParameters = "handle")
    @ApiOperation(value = "修改患者表状态",notes = "根据患者id修改患者状态 表示叫号不成功 点击过号")
    public ResponseResult<String> updateOutPatient(@RequestBody UpdateOutPatientCommand command){
      try {
          command.execute();
          return  new ResponseResult<>(200,"success","修改成功");
      }catch (WebException e){
          e.printStackTrace();
          return  new ResponseResult<>(404,"error","修改失败");
      }

    }
}
