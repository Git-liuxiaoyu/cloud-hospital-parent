package com.example.physicalexamservice.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

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

    @ApiModelProperty(value = "体检记录主键ID", example = "1")
    private Long id;

    @ApiModelProperty(value = "体检记录编号")
    private String no;

    @ApiModelProperty(value = "就诊记录ID")
    private Long treatrecordid;

    @ApiModelProperty(value = "体检记录创造医生ID")
    private Integer doctorid;

    @ApiModelProperty(value = "体检记录病人ID")
    private Long patientid;

    @ApiModelProperty(value = "体检记录创建时间")
    private Date createtime;

    @ApiModelProperty(value = "体检记录状态")
    private String status;

    /* 没有支付 */
    public static final String STATUS_NOTPAY = "9";

    public static final String STATUS_PAYED = "8";

    public static final String STATUS_CLOSE = "7";

    public static final String STATUS_FINISH = "6";
}
