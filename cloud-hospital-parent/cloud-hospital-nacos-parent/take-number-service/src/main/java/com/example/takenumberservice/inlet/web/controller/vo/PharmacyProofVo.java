package com.example.takenumberservice.inlet.web.controller.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 药房取票凭证表Vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PharmacyProofVo {

    private Integer id;//id
    private String no;//取票no
    private Integer orderNum;//排队序号
    private String createTime;//取票时间

}
