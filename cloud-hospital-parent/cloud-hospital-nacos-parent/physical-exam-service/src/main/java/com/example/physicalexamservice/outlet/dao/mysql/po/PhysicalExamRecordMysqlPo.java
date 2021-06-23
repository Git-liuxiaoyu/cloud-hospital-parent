package com.example.physicalexamservice.outlet.dao.mysql.po;

import java.math.BigDecimal;
import java.util.Date;

public class PhysicalExamRecordMysqlPo {
    private Long id;

    private String no;

    private Long treatrecordid;

    private Integer doctorid;

    private Long patientid;

    private Date createtime;

    private String status;

    private String param1;

    private String param2;

    private Date param3;

    private Long param4;

    private BigDecimal param5;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Long getTreatrecordid() {
        return treatrecordid;
    }

    public void setTreatrecordid(Long treatrecordid) {
        this.treatrecordid = treatrecordid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public Long getPatientid() {
        return patientid;
    }

    public void setPatientid(Long patientid) {
        this.patientid = patientid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1 == null ? null : param1.trim();
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2 == null ? null : param2.trim();
    }

    public Date getParam3() {
        return param3;
    }

    public void setParam3(Date param3) {
        this.param3 = param3;
    }

    public Long getParam4() {
        return param4;
    }

    public void setParam4(Long param4) {
        this.param4 = param4;
    }

    public BigDecimal getParam5() {
        return param5;
    }

    public void setParam5(BigDecimal param5) {
        this.param5 = param5;
    }
}