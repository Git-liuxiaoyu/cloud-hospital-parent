package com.example.registerservice.service.query.queryregister.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/23:29
 * @Description: 根据手机号查询挂号信息
 */
@Data
@ApiModel
public class RegisterServicePo {
    @NotNull
    @ApiModelProperty(value = "挂号的id", required = true)
    private Long id;//挂号的id
    @NotNull
    @ApiModelProperty(value = "挂号的编号", required = true)
    private String no;//挂号的编号
    @NotNull
    @ApiModelProperty(value = "挂号的时间", required = true)
    private Date regTime;//挂号的时间
    @NotNull
    @ApiModelProperty(value = "科目Id", required = true)
    private String departmentId;//科目Id
    @NotNull
    @ApiModelProperty(value = "排班id", required = true)
    private String rotaId;//排班id
    @NotNull
    @ApiModelProperty(value = "挂号费用", required = true)
    private BigDecimal price;//挂号费用
    @NotNull
    @ApiModelProperty(value = "挂号类型", required = true)
    private String type;//挂号类型 （1、线上，2、线下）
    @NotNull
    @ApiModelProperty(value = "挂号状态", required = true)
    private String status;//挂号状态
    @NotNull
    @ApiModelProperty(value = "患者名字", required = true)
    private String name;//患者名字

    @NotNull
    @ApiModelProperty(value = "科目名字", required = true)
    private String departmentName;//科目名字

    @NotNull
    @ApiModelProperty(value = "医生名字", required = true)
    private String doctorName;//医生名字
}
