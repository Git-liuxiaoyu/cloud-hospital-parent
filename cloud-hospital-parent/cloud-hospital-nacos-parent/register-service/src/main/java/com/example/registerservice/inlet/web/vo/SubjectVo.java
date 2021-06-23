package com.example.registerservice.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/14:13
 * @Description:
 */
@Data
public class SubjectVo {
    @NotNull
    @ApiModelProperty(value = "科目id", required = true)
    private Long id;
    @NotNull
    @ApiModelProperty(value = "科目名称", required = true)
    private String name;
}
