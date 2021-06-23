package com.example.outpatientservice.outlet.dao.mysql.po;

import java.util.Date;

public class OutPatientRecordPo {
    private Long id;

    private Long outpatientid;

    private String ischeck;

    private String isdrug;

    private String ishospital;

    private String isoperation;

    private Long checkoddid;

    private Long drugoddid;

    private Long hospitaloddid;

    private Integer operationoddid;

    private Date createtime;

    private String result;

    private String param1;

    private Long param2;

    private String param3;

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

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck == null ? null : ischeck.trim();
    }

    public String getIsdrug() {
        return isdrug;
    }

    public void setIsdrug(String isdrug) {
        this.isdrug = isdrug == null ? null : isdrug.trim();
    }

    public String getIshospital() {
        return ishospital;
    }

    public void setIshospital(String ishospital) {
        this.ishospital = ishospital == null ? null : ishospital.trim();
    }

    public String getIsoperation() {
        return isoperation;
    }

    public void setIsoperation(String isoperation) {
        this.isoperation = isoperation == null ? null : isoperation.trim();
    }

    public Long getCheckoddid() {
        return checkoddid;
    }

    public void setCheckoddid(Long checkoddid) {
        this.checkoddid = checkoddid;
    }

    public Long getDrugoddid() {
        return drugoddid;
    }

    public void setDrugoddid(Long drugoddid) {
        this.drugoddid = drugoddid;
    }

    public Long getHospitaloddid() {
        return hospitaloddid;
    }

    public void setHospitaloddid(Long hospitaloddid) {
        this.hospitaloddid = hospitaloddid;
    }

    public Integer getOperationoddid() {
        return operationoddid;
    }

    public void setOperationoddid(Integer operationoddid) {
        this.operationoddid = operationoddid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
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

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3 == null ? null : param3.trim();
    }
}