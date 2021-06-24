package com.example.physicalexamservice.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class PhysicalExamRecordVo {

    @ApiModelProperty(value = "体检记录主键ID",example = "1")
    private Long id;

    @ApiModelProperty(value = "体检记录编号")
    private String no;

    /* 没有支付 */
    public static final String STATUS_NOTPAY = "9";

    public static final String STATUS_PAYED = "8";

}
