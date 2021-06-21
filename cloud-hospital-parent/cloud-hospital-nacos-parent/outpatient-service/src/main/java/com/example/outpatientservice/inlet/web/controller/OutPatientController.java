package com.example.outpatientservice.inlet.web.controller;

import com.example.outpatientservice.inlet.web.vo.OutPatientVo;
import com.example.outpatientservice.service.query.ExampleQueryOutPatientCommand;
import com.example.outpatientservice.util.ResponseResult;
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
    public ResponseResult<List<OutPatientVo>> findByExample(@RequestBody ExampleQueryOutPatientCommand command){
        List<OutPatientVo> voList = command.execute();
        log.info("{}",voList);
        return new ResponseResult<>(200,"success",voList);
    }
}
