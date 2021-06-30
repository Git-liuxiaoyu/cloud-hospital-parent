package com.example.workerservice.outlet.dao.mysql.po;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReceivedPo {
    private String messageid;

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid == null ? null : messageid.trim();
    }
}