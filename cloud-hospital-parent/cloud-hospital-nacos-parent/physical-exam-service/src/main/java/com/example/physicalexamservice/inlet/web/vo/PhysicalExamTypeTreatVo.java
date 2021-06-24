package com.example.physicalexamservice.inlet.web.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 实体类 - Vo - For Treat - PhysicalExamType
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel
public class PhysicalExamTypeTreatVo {

    @ApiModelProperty(value = "体检类型主键ID", example = "1")
    private Integer id;

    @ApiModelProperty(value = "体检类型名称", example = "CT")
    private String name;

    @ApiModelProperty(value = "体检类型状态", example = "1")
    private String status;

    public static final String STATUS_NORMAL = "1";

}
