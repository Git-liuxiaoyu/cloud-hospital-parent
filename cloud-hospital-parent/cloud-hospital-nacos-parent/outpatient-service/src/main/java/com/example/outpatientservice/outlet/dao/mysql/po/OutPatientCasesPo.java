package com.example.outpatientservice.outlet.dao.mysql.po;

import java.util.Date;

public class OutPatientCasesPo {
    private Long id;

    private Long outpatientid;

    private Long doctorid;

    private Long departmentid;

    private String temperature;

    private String pulse;

    private String blood;

    private String result;

    private String advice;

    private Long drugoddid;

    private Long checkoddid;

    private Long hospitaloddid;

    private String param1;

    private String param3;

    private Date createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOutpatientid() {
        return outpatientid;
    }

    public void setOutpatientid(Long outpatientid) {
        this.outpatientid = outpatientid;
    }

    public Long getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Long doctorid) {
        this.doctorid = doctorid;
    }

    public Long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Long departmentid) {
        this.departmentid = departmentid;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse == null ? null : pulse.trim();
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood == null ? null : blood.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public Long getDrugoddid() {
        return drugoddid;
    }

    public void setDrugoddid(Long drugoddid) {
        this.drugoddid = drugoddid;
    }

    public Long getCheckoddid() {
        return checkoddid;
    }

    public void setCheckoddid(Long checkoddid) {
        this.checkoddid = checkoddid;
    }

    public Long getHospitaloddid() {
        return hospitaloddid;
    }

    public void setHospitaloddid(Long hospitaloddid) {
        this.hospitaloddid = hospitaloddid;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1 == null ? null : param1.trim();
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3 == null ? null : param3.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}