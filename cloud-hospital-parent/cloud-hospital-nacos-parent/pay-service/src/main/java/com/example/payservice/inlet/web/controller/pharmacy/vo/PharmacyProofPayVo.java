package com.example.payservice.inlet.web.controller.pharmacy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PharmacyProofPayVo {

    private Long id;
    private Long drugoddId;//药品单Id
    private String orderNum;//订单编号
    private BigDecimal money;//金额
    private String time;//交易时间
    private String status;//订单状态
}
