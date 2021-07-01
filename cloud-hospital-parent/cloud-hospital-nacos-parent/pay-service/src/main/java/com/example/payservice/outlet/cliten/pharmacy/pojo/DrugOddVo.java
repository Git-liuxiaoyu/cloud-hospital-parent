package com.example.payservice.outlet.cliten.pharmacy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 药房接口调用数据接收
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugOddVo {
    private Long id;
    //private Long drugoddId;//药品单Id
    private String no;//取药no
    private String status;//药品单状态
    private BigDecimal totalmoney;//总金额
    private Long patientid;//患者id

}
