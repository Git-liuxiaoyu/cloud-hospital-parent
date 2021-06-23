package com.example.workerservice.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 实体类 - Vo - OutRoom
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel
public class OutRoomVo {

    @ApiModelProperty(value = "房间主键ID", example = "1")
    private Long id;

    @ApiModelProperty(value = "房间所属科室主键ID", example = "1")
    private Integer departmentid;

    @ApiModelProperty(value = "房间名称", example = "诊室1")
    private String roomname;

    @ApiModelProperty(value = "房间状态", example = "1")
    private String status;

    public static final String STATUS_NORMAL = "1";

}
