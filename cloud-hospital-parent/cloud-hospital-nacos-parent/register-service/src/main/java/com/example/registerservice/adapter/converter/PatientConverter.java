package com.example.registerservice.adapter.converter;

import com.example.registerservice.inlet.web.vo.PatientVo;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
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

    public PatientVo.QueryGetByIdVo converter(Patient patient) {
        PatientVo.QueryGetByIdVo vo = new PatientVo.QueryGetByIdVo();
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
}
