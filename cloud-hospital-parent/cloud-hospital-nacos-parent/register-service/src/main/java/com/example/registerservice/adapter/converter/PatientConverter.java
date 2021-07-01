package com.example.registerservice.adapter.converter;

import com.example.registerservice.outlet.dao.es.po.PatientEsPo;
import com.example.registerservice.outlet.dao.mysql.po.PatientMysqlPo;
import com.example.registerservice.outlet.dao.redis.po.PatientRedisPo;
import com.example.registerservice.service.command.updatepatient.UpdatePatientCommand;
import com.example.registerservice.service.query.querypatient.domain.Patient;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/22/16:49
 * @Description:
 */

@Component
public class PatientConverter {

    /**
     * 根据id查询患者对象
     * mysql对象转换成domain对象
     *
     * @param po
     * @return
     */
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

    /**
     * 根据id查询患者对象
     * mysql对象转换成Redis对象
     *
     * @param po
     * @return
     */
    public PatientRedisPo redisConverter(PatientMysqlPo po) {
        PatientRedisPo patientRedisPo = new PatientRedisPo();
        patientRedisPo.setId(po.getId());
        patientRedisPo.setNo(po.getNo());
        patientRedisPo.setName(po.getName());
        patientRedisPo.setAge(po.getAge());
        patientRedisPo.setGender(po.getGender());
        patientRedisPo.setPhone(po.getPhone());
        patientRedisPo.setIdentityid(po.getIdentityid());
        patientRedisPo.setStatus(po.getStatus());
        patientRedisPo.setCreatetime(po.getCreatetime());
        patientRedisPo.setMedicard(po.getMedicard());
        return patientRedisPo;
    }

    /**
     * 根据id查询患者对象
     * mysql对象转换成es对象
     *
     * @param po
     * @return
     */
    public PatientEsPo esConverter(PatientMysqlPo po) {
        PatientEsPo patientEsPo = new PatientEsPo();
        patientEsPo.setId(po.getId());
        patientEsPo.setNo(po.getNo());
        patientEsPo.setName(po.getName());
        patientEsPo.setAge(po.getAge());
        patientEsPo.setGender(po.getGender());
        patientEsPo.setPhone(po.getPhone());
        patientEsPo.setIdentityid(po.getIdentityid());
        patientEsPo.setStatus(po.getStatus());
        patientEsPo.setCreatetime(po.getCreatetime());
        patientEsPo.setMedicard(po.getMedicard());
        return patientEsPo;
    }

    public PatientMysqlPo converter(UpdatePatientCommand command) {
        PatientMysqlPo po = new PatientMysqlPo();
        po.setId(command.getId());
        po.setName(command.getName());
        po.setAge(command.getAge());
        po.setGender(command.getGender());
        po.setPhone(command.getPhone());
        po.setIdentityid(command.getIdentityId());
        return po;
    }

    /**
     * 根据id查询患者对象
     * redis对象转换成domain对象
     *
     * @param redisPo
     * @return
     */
    public Patient converter(PatientRedisPo redisPo) {
        Patient patient = new Patient();
        patient.setId(redisPo.getId());
        patient.setNo(redisPo.getNo());
        patient.setName(redisPo.getName());
        patient.setAge(redisPo.getAge());
        patient.setGender(redisPo.getGender());
        patient.setPhone(redisPo.getPhone());
        patient.setIdentityid(redisPo.getIdentityid());
        patient.setStatus(redisPo.getStatus());
        patient.setCreatetime(redisPo.getCreatetime());
        patient.setMedicard(redisPo.getMedicard());
        return patient;
    }

    /**
     * 根据id查询患者对象
     * es对象转换成domain对象
     *
     * @param esPo
     * @return
     */
    public Patient converter(PatientEsPo esPo) {
        Patient patient = new Patient();
        patient.setId(esPo.getId());
        patient.setNo(esPo.getNo());
        patient.setName(esPo.getName());
        patient.setAge(esPo.getAge());
        patient.setGender(esPo.getGender());
        patient.setPhone(esPo.getPhone());
        patient.setIdentityid(esPo.getIdentityid());
        patient.setStatus(esPo.getStatus());
        patient.setCreatetime(esPo.getCreatetime());
        patient.setMedicard(esPo.getMedicard());
        return patient;
    }
}