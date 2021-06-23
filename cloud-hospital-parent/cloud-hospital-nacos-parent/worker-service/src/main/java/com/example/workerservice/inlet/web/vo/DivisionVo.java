package com.example.workerservice.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 实体类 - Division
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel
public class DivisionVo {

    @ApiModelProperty(value = "科目主键ID", example = "1")
    private Integer id;

    @ApiModelProperty(value = "科目名称", example = "心脏中心")
    private String name;

    /* 状态 - 正常状态 */
    public static final String STATUS_NORMAL = "1";

}
