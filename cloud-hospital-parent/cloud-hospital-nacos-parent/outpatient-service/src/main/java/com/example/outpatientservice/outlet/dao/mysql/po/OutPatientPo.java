package com.example.outpatientservice.outlet.dao.mysql.po;

public class OutPatientPo {
    private Long id;

    private String patientno;

    private String patientname;

    private String gender;

    private String idcard;

    private String patientage;

    private Long registerid;

    private Long patientid;

    private Long departmentid;

    private Long doctorid;

    private Long rotaid;

    private String status;

    private Long queueno;

    private String medicard;

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

    public String getPatientno() {
        return patientno;
    }

    public void setPatientno(String patientno) {
        this.patientno = patientno == null ? null : patientno.trim();
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname == null ? null : patientname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPatientage() {
        return patientage;
    }

    public void setPatientage(String patientage) {
        this.patientage = patientage == null ? null : patientage.trim();
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

    public Long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Long departmentid) {
        this.departmentid = departmentid;
    }

    public Long getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Long doctorid) {
        this.doctorid = doctorid;
    }

    public Long getRotaid() {
        return rotaid;
    }

    public void setRotaid(Long rotaid) {
        this.rotaid = rotaid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getQueueno() {
        return queueno;
    }

    public void setQueueno(Long queueno) {
        this.queueno = queueno;
    }

    public String getMedicard() {
        return medicard;
    }

    public void setMedicard(String medicard) {
        this.medicard = medicard == null ? null : medicard.trim();
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