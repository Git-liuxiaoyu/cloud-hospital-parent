package com.example.registerservice.service.query.querypatient.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/22/16:49
 * @Description:
 */

@Data
public class Patient {
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
