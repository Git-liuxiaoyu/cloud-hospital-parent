package com.example.workerservice.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 实体类 - Vo - DoctorRota - Set(设置时反显用)
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel
public class DoctorRotaSetVo {

    @ApiModelProperty(value = "医生排班的主键ID", example = "1")
    private Long id;

    @ApiModelProperty(value = "排班的房间主键ID", example = "1")
    private Integer roomid;

    @ApiModelProperty(value = "医生主键ID", example = "1")
    private Integer doctorid;

    @ApiModelProperty(value = "单次排班最大看诊人数", example = "1")
    private Integer maxpatient;

    @ApiModelProperty(value = "排班的状态", example = "1")
    private String status;

    public static final String STATUS_NORMAL = "1";

    public static final String STATUS_CANCEL = "0";

}
