package com.example.outpatientservice.inlet.web.controller;

import com.example.outpatientservice.inlet.web.exception.WebException;
import com.example.outpatientservice.inlet.web.vo.OutPatientVo;
import com.example.outpatientservice.service.add.AddOutPatientRecordCommand;
import com.example.outpatientservice.service.query.ExampleQueryOutPatientCommand;
import com.example.outpatientservice.service.update.UpdateOutPatientCommand;
import com.example.outpatientservice.util.PageUtils;
import com.example.outpatientservice.util.ResponseResult;
import com.github.pagehelper.PageInfo;
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

    @PostMapping("/outPatientRecord/add")
    public ResponseResult<String> addRecord(@RequestBody AddOutPatientRecordCommand command){
        log.info("command为{}",command);
        command.updateOutpatientStatusById();
        return new ResponseResult<>(200,"success",null);
    }


}
