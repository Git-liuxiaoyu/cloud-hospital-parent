package com.example.takenumberservice.inlet.web.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProofControllerVo {

    @NotNull
    @ApiModelProperty(value="主键",required = true,example = "1")
    private Integer id;//id

    @NotNull
    @ApiModelProperty(value="挂号Id",required = true,example = "12")
    private Integer regId;//挂号id

    @NotNull
    @ApiModelProperty(value="取票码",required = true,example = "GH1018")
    private String no;//取票码

    @NotNull
    @ApiModelProperty(value="科室id",required = true,example = "1")
    private Integer departmentId;//科室id

    @NotNull
    @ApiModelProperty(value="房间名",required = true,example = "诊室1")
    private String roomName;//房间名

    @NotNull
    @ApiModelProperty(value="排队序号",required = true,example = "2")
    private Integer orderNum;//排队序号

    @NotNull
    @ApiModelProperty(value="取票时间",required = true,example = "2021-06-23 19:03:30")
    private String createTime;//取票时间

    @NotNull
    @ApiModelProperty(value="取票状态",required = true,example = "1")
    private char status;//取票状态

}
