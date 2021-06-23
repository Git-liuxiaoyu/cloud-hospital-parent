package com.example.takenumberservice.inlet.web.controller.vo;


import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addexamineProof.ExamineProofCommandHandle;
import com.example.takenumberservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamineProofVo {


    @NotNull
    @ApiModelProperty(value="主键id",required = true,example = "1")
    private Integer id;//id

    @NotNull
    @ApiModelProperty(value="取票号码",required = true,example = "JC0001")
    private String no;//取票号码

    @NotNull
    @ApiModelProperty(value="排队序号",required = true,example = "1")
    private Integer orderNum;//排队序号

    @NotNull
    @ApiModelProperty(value="取票时间",required = true,example = "2021-06-23 19:03:30")
    private String createTime;//取票时间

    @NotNull
    @ApiModelProperty(value="检查类型",required = true,example = "1")
    private String examineType;//检查类型




}
