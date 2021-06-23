package com.example.registerservice.service.query.queryregister.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/22/17:40
 * @Description: Register的domian对象
 */
@Data
public class Register {
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
