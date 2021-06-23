package com.example.workerservice.inlet.web.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 实体类 - WorkerInfoVo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
@ApiModel
public class WorkerInfoVo {

    @ApiModelProperty(value = "员工表主键ID", example = "1")
    private Integer id;

    @ApiModelProperty(value = "员工名称", example = "张方松")
    private String name;

    @ApiModelProperty(value = "员工手机号", example = "18888888888")
    private String phone;

    public static final String STATUS_NORMAL = "1";

}
