package com.example.physicalexamservice.outlet.dao.mysql.po;

import java.util.Date;

public class PhysicalExamTypeMysqlPo {
    private Integer id;

    private String name;

    private String description;

    private String status;

    private String param1;

    private String param2;

    private Date param3;

    private Long param4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
}