package com.example.physicalexamservice.outlet.dao.mysql.po;

import java.math.BigDecimal;
import java.util.Date;

public class PhysicalExamMysqlPo {
    private Integer id;

    private String no;

    private Integer typeid;

    private String name;

    private BigDecimal price;

    private Long leftstock;

    private Long maxstock;

    private String status;

    private String param1;

    private String param2;

    private Long param3;

    private Date param4;

    private BigDecimal param5;

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

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getLeftstock() {
        return leftstock;
    }

    public void setLeftstock(Long leftstock) {
        this.leftstock = leftstock;
    }

    public Long getMaxstock() {
        return maxstock;
    }

    public void setMaxstock(Long maxstock) {
        this.maxstock = maxstock;
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

    public BigDecimal getParam5() {
        return param5;
    }

    public void setParam5(BigDecimal param5) {
        this.param5 = param5;
    }
}