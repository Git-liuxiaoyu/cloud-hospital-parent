package com.example.workerservice.inlet.web.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 登陆后传送给页面的 WorkerInfo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel
public class WorkerInfoLoginedVo {

    @ApiModelProperty(value = "员工表主键ID", example = "1")
    private Integer id;

    @ApiModelProperty(value = "员工工号", example = "STAFF20210616175114619751")
    private String no;

    @ApiModelProperty(value = "员工名字", example = "张方松")
    private String name;

    @ApiModelProperty(value = "员工所属科室主键ID", example = "1")
    private Integer departmentId;

    @ApiModelProperty(value = "员工所属科室名称", example = "心脏外科")
    private String departmentName;

    @ApiModelProperty(value = "员工所属类型(医生/护士)", example = "1")
    private String positionType;

    @ApiModelProperty(value = "员工等级(普通/高级/主任)", example = "1")
    private String positionLevel;

    @ApiModelProperty(value = "员工是否在门诊工作", example = "1")
    private String positionIsOut;

    @ApiModelProperty(value = "员工是否在住院工作", example = "1")
    private String positionIsIn;

    @ApiModelProperty(value = "员工是否在药房工作", example = "1")
    private String positionIsMdc;

    @ApiModelProperty(value = "员工是否在体检中心工作", example = "1")
    private String positionIsExam;

    @ApiModelProperty(value = "员工职位状态", example = "1")
    private String positionStatus;

    @ApiModelProperty(value = "员工头像路径")
    private String avatar;

    @ApiModelProperty(value = "员工状态", example = "1")
    private String status;

}
