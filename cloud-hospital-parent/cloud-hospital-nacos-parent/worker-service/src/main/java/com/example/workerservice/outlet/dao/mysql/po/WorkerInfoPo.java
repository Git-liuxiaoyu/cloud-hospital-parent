package com.example.workerservice.outlet.dao.mysql.po;

import java.util.Date;

public class WorkerInfoPo {
    private Integer id;

    private String no;

    private String name;

    private Date birthday;

    private String gender;

    private String identityno;

    private String topeducation;

    private String career;

    private Integer departmentid;

    private Integer positionid;

    private Date signtime;

    private Date resigntime;

    private String avatar;

    private String status;

    private String phone;

    private String param2;

    private Long param3;

    private Date param4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getIdentityno() {
        return identityno;
    }

    public void setIdentityno(String identityno) {
        this.identityno = identityno == null ? null : identityno.trim();
    }

    public String getTopeducation() {
        return topeducation;
    }

    public void setTopeducation(String topeducation) {
        this.topeducation = topeducation == null ? null : topeducation.trim();
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career == null ? null : career.trim();
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    public Date getResigntime() {
        return resigntime;
    }

    public void setResigntime(Date resigntime) {
        this.resigntime = resigntime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2 == null ? null : param2.trim();
    }

    public Long getParam3() {
        return param3;
    }

    public void setParam3(Long param3) {
        this.param3 = param3;
    }

    public Date getParam4() {
        return param4;
    }

    public void setParam4(Date param4) {
        this.param4 = param4;
    }
}