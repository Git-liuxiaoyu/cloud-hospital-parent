package com.example.registerservice.inlet.web.controller;

import com.example.registerservice.adapter.converter.PatientConverter;
import com.example.registerservice.inlet.web.vo.PatientVo;
import com.example.registerservice.service.command.addpatient.AddPatientCommand;
import com.example.registerservice.service.command.updatepatient.UpdatePatientCommand;
import com.example.registerservice.service.query.querypatient.QueryPatientByIdCommand;
import com.example.registerservice.service.query.querypatient.QueryPatientByIdentityIdCommand;
import com.example.registerservice.service.query.querypatient.domain.Patient;
import com.example.registerservice.util.ResponseResult;
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
public class PatientController {

    @Autowired
    private PatientConverter converter;

    /**
     * 添加患者信息
     *
     * @param vo
     * @return
     */
    @PostMapping("Patient/add")
    public ResponseResult addPatient(@RequestBody PatientVo vo) {
        AddPatientCommand command = new AddPatientCommand(vo);
        log.debug("添加的患者的信息为{}", vo);
        //先查询一下看看有没有该患者
        QueryPatientByIdentityIdCommand cmd = new QueryPatientByIdentityIdCommand(vo.getIdentityId());
        try {
            Patient execute = null;//如果数据库已有该患者信息
            try {
                execute = cmd.execute();
                log.debug("身份证{}已存在该患者不能添加", vo.getIdentityId());
                return new ResponseResult(444, "存在该患者");
            } catch (Exception e) {
                log.debug("添加身份证{}患者可以添加", vo.getIdentityId());
            }
            Long patientId = command.execute();//添加成功返回该患者的Id
            log.debug("身份证为{}患者添加成功返回的id是{}", vo.getIdentityId(), patientId);
            return new ResponseResult(patientId);
        } catch (Exception e) {
            log.debug("添加身份证{}患者失败", vo.getIdentityId());
            return new ResponseResult(404, "添加失败");
        }
    }

    /**
     * 根据患者id查询患者信息
     *
     * @param id
     * @return
     */
    @GetMapping("Patient/query/byId/{id}")
    public ResponseResult<PatientVo.QueryGetByIdVo> getByIdVoResponseResult(@PathVariable("id") Long id) {
        QueryPatientByIdCommand command = new QueryPatientByIdCommand(id);
        Patient execute = null;
        try {
            execute = command.execute();
        } catch (Exception e) {
            return new ResponseResult<>(444, "");
        }
        PatientVo.QueryGetByIdVo converter = this.converter.converter(execute);
        return new ResponseResult(converter);
    }

    /**
     * 根据患者身份证查询患者信息
     *
     * @param identityId
     * @return
     */
    @GetMapping("Patient/query/byIdentityId/{identityId}")
    public ResponseResult<PatientVo.QueryGetByIdVo> getByIdentityIdVoResponseResult(@PathVariable("identityId") String identityId) {
        QueryPatientByIdentityIdCommand command = new QueryPatientByIdentityIdCommand(identityId);
        Patient execute = null;
        try {
            execute = command.execute();
        } catch (NullPointerException e) {
            return new ResponseResult(444, "没有该患者信息");
        }
        PatientVo.QueryGetByIdVo converter = this.converter.converter(execute);
        return new ResponseResult(converter);
    }

    /**
     * 修改患者的信息
     *
     * @param vo
     * @return
     */
    @PostMapping("Patient/update")
    public ResponseResult update(@RequestBody PatientVo vo) {
        UpdatePatientCommand command = new UpdatePatientCommand(vo);
        try {
            command.execute();
            log.debug("修改用户成功");
        } catch (Exception e) {
            log.debug("修改用户失败");
            return new ResponseResult(444, "");
        }
        return ResponseResult.SUCCESS;
    }
}
