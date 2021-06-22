package com.example.takenumberservice.outlet.dao.mysql.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 药房取票Po
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PharmacyProofPo {

    private Integer id;//id
    private String no;//取票no
    private Integer orderNum;//排队序号
    private String createTime;//取票时间


}
