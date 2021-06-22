package com.example.registerservice.outlet.dao.mysql.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RegisterMysqlPo {
    private Long id;

    private String no;

    private Long patientid;

    private String regtype;

    private Date regtime;

    private Long rotaid;

    private Integer departmentid;

    private Integer roomid;

    private Date visittime;

    private String visitsection;

    private BigDecimal price;

    private String type;

    private String status;

    private String phone;
}