package com.example.drugservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugOddDetailVo {

    private Long id;

    private String drugNo;

    private Long drugoddid;

    private String drugName;

    private BigDecimal saleMoney;


    private Integer drugid;

    private Long drugnum;

}
