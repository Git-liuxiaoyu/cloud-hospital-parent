package com.example.workerservice.outlet.dao.mysql.po;

public class PositionPo {
    private Integer id;

    private String type;

    private String level;

    private String name;

    private String isout;

    private String isin;

    private String ismdc;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIsout() {
        return isout;
    }

    public void setIsout(String isout) {
        this.isout = isout == null ? null : isout.trim();
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin == null ? null : isin.trim();
    }

    public String getIsmdc() {
        return ismdc;
    }

    public void setIsmdc(String ismdc) {
        this.ismdc = ismdc == null ? null : ismdc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}