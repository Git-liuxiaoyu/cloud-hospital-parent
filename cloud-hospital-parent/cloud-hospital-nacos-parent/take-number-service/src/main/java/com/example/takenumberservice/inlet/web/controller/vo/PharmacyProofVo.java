package com.example.takenumberservice.inlet.web.controller.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 药房取票凭证表Vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PharmacyProofVo {


    @NotNull
    @ApiModelProperty(value="主键id",required = true,example = "1")
    private Integer id;//id

    @NotNull
    @ApiModelProperty(value="取票no",required = true,example = "YF0001")
    private String no;//取票no

    @NotNull
    @ApiModelProperty(value="排队序号",required = true,example = "1")
    private Integer orderNum;//排队序号


    @NotNull
    @ApiModelProperty(value="取票时间",required = true,example = "2021-06-23 19:03:30")
    private String createTime;//取票时间

}
