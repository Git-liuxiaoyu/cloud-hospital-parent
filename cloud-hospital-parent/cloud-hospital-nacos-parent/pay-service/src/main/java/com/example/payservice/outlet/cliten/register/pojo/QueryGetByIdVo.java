package com.example.payservice.outlet.cliten.register.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryGetByIdVo {
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
