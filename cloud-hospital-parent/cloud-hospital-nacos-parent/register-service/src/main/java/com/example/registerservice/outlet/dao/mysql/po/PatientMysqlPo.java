package com.example.registerservice.outlet.dao.mysql.po;

import lombok.Data;

import java.util.Date;


@Data
public class PatientMysqlPo {
    private Long id;
    private String no;
    private String name;
    private Integer age;
    private String gender;
    private String phone;
    private String identityid;
    private String status;
    private Date createtime;
    private String medicard;
}