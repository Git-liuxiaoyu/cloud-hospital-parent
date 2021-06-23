package com.example.registerservice.adapter.converter;

import com.example.registerservice.inlet.web.vo.PatientVo;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.service.command.updatepatient.UpdatePatientCommand;
import com.example.registerservice.service.query.querypatient.domain.Patient;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/22/16:49
 * @Description:
 */

@Component
public class PatientConverter {
    public Patient converter(PatientMysqlPo po) {
        Patient patient = new Patient();
        patient.setId(po.getId());
        patient.setNo(po.getNo());
        patient.setName(po.getName());
        patient.setAge(po.getAge());
        patient.setGender(po.getGender());
        patient.setPhone(po.getPhone());
        patient.setIdentityid(po.getIdentityid());
        patient.setStatus(po.getStatus());
        patient.setCreatetime(po.getCreatetime());
        patient.setMedicard(po.getMedicard());
        return patient;
    }

    public PatientVo.QueryByIdVo converter(Patient patient) {
        PatientVo.QueryByIdVo vo = new PatientVo.QueryByIdVo();
        vo.setId(patient.getId());
        vo.setNo(patient.getNo());
        vo.setName(patient.getName());
        vo.setAge(patient.getAge());
        vo.setGender(patient.getGender());
        vo.setPhone(patient.getPhone());
        vo.setIdentityid(patient.getIdentityid());
        vo.setStatus(patient.getStatus());
        vo.setCreatetime(patient.getCreatetime());
        vo.setMedicard(patient.getMedicard());
        return vo;
    }


    /**
     *
     * @param command
     * @return
     */
    public PatientMysqlPo converter(UpdatePatientCommand command) {
        PatientMysqlPo po = new PatientMysqlPo();
        po.setName(command.getName());
        po.setAge(command.getAge());
        po.setGender(command.getGender());
        po.setPhone(command.getPhone());
        po.setIdentityid(command.getIdentityId());
        return po;
    }
}
