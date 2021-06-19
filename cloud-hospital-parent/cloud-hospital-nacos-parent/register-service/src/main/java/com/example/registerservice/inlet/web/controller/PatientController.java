package com.example.registerservice.inlet.web.controller;

import com.example.registerservice.inlet.web.vo.PatientVo;
import com.example.registerservice.service.command.addpatient.AddPatientCommand;
import com.example.registerservice.util.ResponseResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("Patient/add")
    public ResponseResult addPatient(@RequestBody PatientVo vo) {
        AddPatientCommand command=new AddPatientCommand(vo);
        try {
            command.execute();
        } catch (Exception e) {
            return new ResponseResult(404,"添加失败");
        }
        return ResponseResult.SUCCESS;
    }
}
