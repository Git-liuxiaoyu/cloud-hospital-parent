package com.example.drugservice.outlet.dao.mysql.po;

import java.util.Date;

public class InventoryOddPo {
    private Long id;

    private String no;

    private Date createtime;

    private String inventoryperson;

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getInventoryperson() {
        return inventoryperson;
    }

    public void setInventoryperson(String inventoryperson) {
        this.inventoryperson = inventoryperson == null ? null : inventoryperson.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}