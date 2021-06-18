package com.example.drugservice.outlet.dao.mysql.po;

public class DrugTypePo {
    private Integer id;

    private String drugtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugtype() {
        return drugtype;
    }

    public void setDrugtype(String drugtype) {
        this.drugtype = drugtype == null ? null : drugtype.trim();
    }
}