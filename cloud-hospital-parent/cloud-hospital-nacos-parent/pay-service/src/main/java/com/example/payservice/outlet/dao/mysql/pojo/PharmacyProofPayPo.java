package com.example.payservice.outlet.dao.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PharmacyProofPayPo {

    private Long id;
    private Long drugoddId;//药品单Id
    private String orderNum;//订单编号
    private BigDecimal money;//金额
    private String no;//取药no
    private Long patientId;//患者id
    private String time;//交易时间
    private String status;//订单状态(0：未付款、1已付款)


}
