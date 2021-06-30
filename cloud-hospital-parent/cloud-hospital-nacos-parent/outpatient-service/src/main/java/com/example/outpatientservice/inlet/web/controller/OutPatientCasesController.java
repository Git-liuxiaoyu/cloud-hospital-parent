package com.example.outpatientservice.inlet.web.controller;

import com.example.outpatientservice.service.addcases.AddOutPatientCasesCommand;
import com.example.outpatientservice.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin
public class OutPatientCasesController {

    @PostMapping("/outPatientCases/add")
    public  ResponseResult<String> addCases(AddOutPatientCasesCommand command){

        return new ResponseResult<>(200,"success","添加成功");
    }
}
