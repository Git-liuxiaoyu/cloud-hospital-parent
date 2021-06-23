package com.example.physicalexamservice.outlet.dao.mysql.po;

import java.math.BigDecimal;
import java.util.Date;

public class PhysicalExamRecordDetailMysqlPo {
    private Long id;

    private Long recordid;

    private Integer typeid;

    private Integer examid;

    private Integer count;

    private BigDecimal price;

    private Date examtime;

    private String resultfile;

    private String resulttext;

    private Integer examdocid;

    private String status;

    private String param1;

    private String param2;

    private Date param3;

    private Long param4;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecordid() {
        return recordid;
    }

    public void setRecordid(Long recordid) {
        this.recordid = recordid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getExamtime() {
        return examtime;
    }

    public void setExamtime(Date examtime) {
        this.examtime = examtime;
    }

    public String getResultfile() {
        return resultfile;
    }

    public void setResultfile(String resultfile) {
        this.resultfile = resultfile == null ? null : resultfile.trim();
    }

    public String getResulttext() {
        return resulttext;
    }

    public void setResulttext(String resulttext) {
        this.resulttext = resulttext == null ? null : resulttext.trim();
    }

    public Integer getExamdocid() {
        return examdocid;
    }

    public void setExamdocid(Integer examdocid) {
        this.examdocid = examdocid;
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