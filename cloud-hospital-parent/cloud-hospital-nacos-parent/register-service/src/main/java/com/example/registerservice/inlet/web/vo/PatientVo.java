package com.example.registerservice.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:07
 * @Description: 病人对象
 */
@Data
@ApiModel
public class PatientVo {

    @NotNull
    @ApiModelProperty(value = "患者id", example = "1", required = true)
    private Long id;//添加成功返回患者的Id

    @NotNull
    @ApiModelProperty(value = "患者姓名", example = "刘小雨", required = true)
    private String name;//患者姓名

    @NotNull
    @ApiModelProperty(value = "患者年龄", example = "21", required = true)
    private Integer age;//患者年龄

    @NotNull
    @ApiModelProperty(value = "患者性别", example = "0是男，1是女", required = true)
    private String gender;//患者性别

    @NotNull
    @ApiModelProperty(value = "患者电话", example = "17683858973", required = true)
    private String phone;//患者电话

    @NotNull
    @ApiModelProperty(value = "患者身份证", example = "42900620001234567X", required = true)
    private String identityId;//患者身份证

    /**
     * 根据id查询患者表的对象
     */
    @Data
    public static class QueryByIdVo {
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
}
