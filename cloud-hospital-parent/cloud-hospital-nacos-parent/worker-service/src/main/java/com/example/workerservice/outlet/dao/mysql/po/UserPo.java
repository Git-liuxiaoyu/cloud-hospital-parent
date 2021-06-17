package com.example.workerservice.outlet.dao.mysql.po;

import lombok.ToString;

import java.util.Date;

@ToString
public class UserPo {
    private Integer id;

    private String account;

    private String password;

    private String workerno;

    private Date lastlogintime;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getWorkerno() {
        return workerno;
    }

    public void setWorkerno(String workerno) {
        this.workerno = workerno == null ? null : workerno.trim();
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}