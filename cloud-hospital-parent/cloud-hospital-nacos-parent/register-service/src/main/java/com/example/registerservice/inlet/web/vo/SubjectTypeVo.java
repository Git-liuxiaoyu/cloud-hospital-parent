package com.example.registerservice.inlet.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/14:15
 * @Description: 科目类型的对象
 */
@Data
public class SubjectTypeVo {
    @NotNull
    @ApiModelProperty(value = "科目类型id", required = true)
    private Long id;
    @NotNull
    @ApiModelProperty(value = "科目类型名称", required = true)
    private String name;
}
