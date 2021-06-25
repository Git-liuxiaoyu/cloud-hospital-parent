package com.example.payservice.inlet.web.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallProofPayVo {

    private Long id;
    private String no;//挂号no
    private String orderNum;//订单编号
    private BigDecimal money;//订单支付金额
    private String type;//挂号类别（1专家 、 2普通）
    private Long patientId;//患者id
    private String status;//订单状态（1：已付款、2未付款、3：已退款、4订单超时）
}
