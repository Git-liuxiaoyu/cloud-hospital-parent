package com.example.drugservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryOddDetailVo {

    private String drugNo;
    private String drugName;
    private BigDecimal drugSaleMoney;

    private Integer drugNum;

    private String reason;



}
