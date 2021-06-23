package com.example.workerservice.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 实体类 - DepartmentVo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel
public class DepartmentVo {

    @ApiModelProperty(value = "科室主键ID", example = "1")
    private Integer id;

    @ApiModelProperty(value = "科室大类别主键ID", example = "1")
    private Integer divisionid;

    @ApiModelProperty(value = "科室名称", example = "心脏外科")
    private String name;

    @ApiModelProperty(value = "科室状态", example = "1")
    private String status;

    public static final String STATUS_NORMAL = "1";

}
