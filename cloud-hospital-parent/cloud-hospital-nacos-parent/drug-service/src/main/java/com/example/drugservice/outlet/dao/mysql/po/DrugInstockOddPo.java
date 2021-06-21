package com.example.drugservice.outlet.dao.mysql.po;

import java.util.Date;

public class DrugInstockOddPo {
    private Long id;

    private String no;

    private String instockperson;

    private Date createtime;

    private String status;

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

    public String getInstockperson() {
        return instockperson;
    }

    public void setInstockperson(String instockperson) {
        this.instockperson = instockperson == null ? null : instockperson.trim();
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
}