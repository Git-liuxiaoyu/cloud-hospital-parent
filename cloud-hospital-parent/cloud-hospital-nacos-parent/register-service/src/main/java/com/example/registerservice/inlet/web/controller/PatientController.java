package com.example.registerservice.inlet.web.controller;

import com.example.registerservice.adapter.converter.PatientConverter;
import com.example.registerservice.service.command.addpatient.AddPatientCommand;
import com.example.registerservice.service.command.updatepatient.UpdatePatientCommand;
import com.example.registerservice.service.query.querypatient.QueryPatientByIdCommand;
import com.example.registerservice.service.query.querypatient.QueryPatientByIdentityIdCommand;
import com.example.registerservice.service.query.querypatient.domain.Patient;
import com.example.registerservice.util.ResponseResult;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:05
 * @Description: 病人的Controller
 */
@CrossOrigin
@RestController
@Slf4j
@Api(value = "患者服务", description = "用户操作 API")
@ApiModel
public class PatientController {

    @Autowired
    private PatientConverter converter;

    /**
     * 添加患者信息
     *
     * @param command
     * @return
     */
    @PostMapping("Patient/add")
    @ApiOperation(value = "添加患者信息", notes = "根据患者的信息添加患者," +
            "如果添加患者的时候，患者的身份证存在了数据库里面,是不让添加的",
            produces = "application/json", response = ResponseResult.class)
    public ResponseResult addPatient(@RequestBody AddPatientCommand command) {
        log.debug("添加的患者的信息为{}", command);
        /*添加成功返回该患者的Id*/
        Long patientId = command.execute();
        log.debug("身份证为{}患者添加成功返回的id是{}", command.getIdentityId(), patientId);
        return new ResponseResult(patientId);
    }

    /**
     * 根据患者id查询患者信息
     *
     * @param id
     * @return
     */
    @GetMapping("Patient/query/byId/{id}")
    @ApiOperation(value = "根据Id查询患者信息", notes = "根据患者id查询患者信息",
            produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "患者id", example = "38",
                    required = true, dataType = "Long", paramType = "path")
    })
    public ResponseResult<Patient> getByIdVoResponseResult(@PathVariable("id") Long id) {
        /*返回给页面的数据*/
        return new ResponseResult(new QueryPatientByIdCommand(id).execute());
    }

    /**
     * 根据患者身份证查询患者信息
     *
     * @param identityId
     * @return
     */
    @ApiOperation(value = "根据身份证identityId查询患者信息", notes = "根据患者身份证查询患者信息",
            produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "identityId", value = "患者身份证",
                    example = "374362452554532656", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping("Patient/query/byIdentityId/{identityId}")
    public ResponseResult<Patient> getByIdentityIdVoResponseResult(@PathVariable("identityId") String identityId) {
        /*返回给页面的数据*/
        return new ResponseResult(new QueryPatientByIdentityIdCommand(identityId).execute());
    }

    /**
     * 修改患者的信息
     *
     * @param command
     * @return
     */
    @PostMapping("Patient/update")
    @ApiOperation(value = "修改患者", notes = "修改患者的信息",
            produces = "application/json", response = ResponseResult.class)
    public ResponseResult update(@RequestBody UpdatePatientCommand command) {
        /*执行修改方法*/
        command.execute();
        return ResponseResult.SUCCESS;
    }
}
