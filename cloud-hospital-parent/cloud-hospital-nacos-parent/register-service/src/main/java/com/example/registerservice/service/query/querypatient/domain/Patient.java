package com.example.registerservice.service.query.querypatient.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/22/16:49
 * @Description: 患者的事务对象
 */

@Data
public class Patient {
    @ApiModelProperty(value = "患者id", hidden = true)
    private Long id;
    @ApiModelProperty(value = "患者编号", hidden = true)
    private String no;
    @ApiModelProperty(value = "患者姓名", hidden = true)
    private String name;
    @ApiModelProperty(value = "患者年龄", hidden = true)
    private Integer age;
    @ApiModelProperty(value = "患者性别", hidden = true)
    private String gender;
    @ApiModelProperty(value = "患者电话", hidden = true)
    private String phone;
    @ApiModelProperty(value = "患者身份证", hidden = true)
    private String identityid;
    @ApiModelProperty(value = "患者状态", hidden = true)
    private String status;
    @ApiModelProperty(value = "患者建档时间", hidden = true)
    private Date createtime;
    @ApiModelProperty(value = "患者医保卡号", hidden = true)
    private String medicard;
}
