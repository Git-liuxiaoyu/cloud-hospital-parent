package com.example.drugservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugOddVo {

    private Long id;

    private String no;

    private Date createtime;

    private Integer doctorid;

    private BigDecimal totalmoney;

    private Integer patientid;

    //0 待付款 1 已付款 2 已完成
    private String status;
}
