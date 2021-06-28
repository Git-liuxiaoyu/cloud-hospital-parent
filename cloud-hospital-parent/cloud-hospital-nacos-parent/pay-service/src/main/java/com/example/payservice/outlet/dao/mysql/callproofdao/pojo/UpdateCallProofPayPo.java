package com.example.payservice.outlet.dao.mysql.callproofdao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 修改订单状态
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCallProofPayPo {

    private String orderNum;//订单编号


    private String status;//状态（）

}
