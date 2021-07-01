package com.example.payservice.outlet.dao.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 修改药房订单po
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePharmacyProofPayPo {

    private String orderNum;//订单编号

    private String status;//订单状态（1：已付款、0未付款、2：已退款）

    private Long drugoddId;//药品单id
}
