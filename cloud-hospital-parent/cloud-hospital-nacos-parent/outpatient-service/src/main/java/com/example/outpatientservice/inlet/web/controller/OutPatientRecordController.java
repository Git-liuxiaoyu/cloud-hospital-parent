package com.example.outpatientservice.inlet.web.controller;

import com.example.outpatientservice.inlet.web.exception.WebException;
import com.example.outpatientservice.inlet.web.vo.OutPatientVo;
import com.example.outpatientservice.service.add.AddOutPatientDrugRecordCommand;
import com.example.outpatientservice.service.add.AddOutPatientRecordCommand;
import com.example.outpatientservice.service.query.ExampleQueryOutPatientCommand;
import com.example.outpatientservice.service.update.UpdateOutPatientCommand;
import com.example.outpatientservice.util.PageUtils;
import com.example.outpatientservice.util.ResponseResult;
import com.github.pagehelper.PageInfo;
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
public class OutPatientRecordController {

    //添加检查 检查的就诊记录
    @PostMapping("/outPatientRecord/add")
    @ApiOperation(value = "添加门诊患者就诊纪录",notes = "把就诊记录添加到就诊记录表里")
    public ResponseResult<Long> addRecord(@RequestBody AddOutPatientRecordCommand command){
        log.info("command为{}",command);
        Long checkOddId = command.updateOutpatientStatusById();
        return new ResponseResult<>(200,"success",checkOddId);
    }

    //添加开药 医嘱的就诊记录
    @PostMapping("/outPatientRecord/add/openDrug")
    public ResponseResult<Long> addDrugRecord(@RequestBody AddOutPatientDrugRecordCommand command){
        log.info("医生开药的参数{}",command);
        Long drugOddId = command.execute();
        return  new ResponseResult<>(200,"success",drugOddId);
    }


}
