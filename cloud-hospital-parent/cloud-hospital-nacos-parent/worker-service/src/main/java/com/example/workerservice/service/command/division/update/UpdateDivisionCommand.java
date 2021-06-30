package com.example.workerservice.service.command.division.update;

import com.example.workerservice.service.api.division.IUpdateDivisionCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/28
 */
@Data
@ApiModel
public class UpdateDivisionCommand {

    @NotNull
    @ApiModelProperty(value = "需要修改的科室大类别主键ID", example = "1", required = true)
    private Integer id;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "科室大类别名称", example = "外科", required = true)
    private String name;

    @ApiModelProperty(value = "科室大类别状态", required = true)
    private String status;


    @ApiModelProperty(value = "科室大类表描述", required = false)
    private String description;

    @ApiModelProperty(hidden = true)
    private IUpdateDivisionCommandHandler updateDivisionCommandHandler;

    public UpdateDivisionCommand() {
        this.updateDivisionCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IUpdateDivisionCommandHandler.class);
    }

    public UpdateDivisionCommand(Integer id, String name, String status, String description) {
        this();
        this.id = id;
        this.name = name;
        this.status = status;
        this.description = description;
    }

    public void execute() {
        /* 执行方法 */
        this.updateDivisionCommandHandler.action(this);
    }
}
