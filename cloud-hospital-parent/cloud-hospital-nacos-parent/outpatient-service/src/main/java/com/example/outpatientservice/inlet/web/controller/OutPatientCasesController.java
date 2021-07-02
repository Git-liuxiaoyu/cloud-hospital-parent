package com.example.outpatientservice.inlet.web.controller;

import com.example.outpatientservice.outlet.dao.mysql.OutPatientCasesDao;
import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientCasesPo;
import com.example.outpatientservice.service.addcases.AddOutPatientCasesCommand;
import com.example.outpatientservice.util.ResponseResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
public class OutPatientCasesController {

    @Autowired
    private OutPatientCasesDao dao;

    @PostMapping("/outPatientCases/add")
    @ApiOperationSupport(ignoreParameters = "handle")
    public  ResponseResult<String> addCases(@RequestBody AddOutPatientCasesCommand command){
        log.info("command为{}",command);
        command.execute();
        return new ResponseResult<>(200,"success","添加成功");
    }

    @GetMapping("/outPatientCases/byId/{id}")
    public OutPatientCasesPo getById(@PathVariable Long id){
        OutPatientCasesPo po = dao.selectByPatientId(id);

        return po;
    }
}
