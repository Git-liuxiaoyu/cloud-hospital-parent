package com.example.outpatientservice.outlet.dao.mysql.po;

import lombok.ToString;

import java.util.Date;

@ToString
public class OutPatientPo {
    private Long id;

    private Long registerid;

    private Long patientid;

    private Long doctorid;

    private String status;

    private Long orderno;

    private Date endtime;

    private String param1;

    private Long param2;

    private Long param3;

    private String param4;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegisterid() {
        return registerid;
    }

    public void setRegisterid(Long registerid) {
        this.registerid = registerid;
    }

    public Long getPatientid() {
        return patientid;
    }

    public void setPatientid(Long patientid) {
        this.patientid = patientid;
    }

    public Long getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Long doctorid) {
        this.doctorid = doctorid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getOrderno() {
        return orderno;
    }

    public void setOrderno(Long orderno) {
        this.orderno = orderno;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1 == null ? null : param1.trim();
    }

    public Long getParam2() {
        return param2;
    }

    public void setParam2(Long param2) {
        this.param2 = param2;
    }

    public Long getParam3() {
        return param3;
    }

    public void setParam3(Long param3) {
        this.param3 = param3;
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4 == null ? null : param4.trim();
    }
}