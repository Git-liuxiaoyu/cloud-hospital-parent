package com.example.physicalexamservice.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 实体类 - Vo - 就诊用 - PhysicalExam
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel
public class PhysicalExamTreatVo {

    @ApiModelProperty(value = "检查项目主键ID", example = "1")
    private Integer id;

    @ApiModelProperty(value = "检查项目编号")
    private String no;

    @ApiModelProperty(value = "检查项目名称")
    private String name;

    @ApiModelProperty(value = "检查项目价格")
    private BigDecimal price;

    @ApiModelProperty(value = "检查项目类型主键ID")
    private Integer typeid;

    @ApiModelProperty(value = "检查项目剩余库存")
    private Long leftstock;

    @ApiModelProperty(value = "检查项目状态")
    private String status;

    public static final String STATUS_NORMAL = "1";

}
