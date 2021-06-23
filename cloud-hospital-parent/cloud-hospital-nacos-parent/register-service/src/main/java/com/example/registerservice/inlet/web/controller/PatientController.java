package com.example.registerservice.inlet.web.controller;

import com.example.registerservice.adapter.converter.PatientConverter;
import com.example.registerservice.inlet.web.vo.PatientVo;
import com.example.registerservice.service.command.addpatient.AddPatientCommand;
import com.example.registerservice.service.query.querypatient.QueryPatientByIdCommand;
import com.example.registerservice.service.query.querypatient.domain.Patient;
import com.example.registerservice.util.ResponseResult;
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
        try {
            Long patientId = command.execute();
            return new ResponseResult(patientId);
        } catch (Exception e) {
            return new ResponseResult(404, "添加失败");
        }
    }

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
}
