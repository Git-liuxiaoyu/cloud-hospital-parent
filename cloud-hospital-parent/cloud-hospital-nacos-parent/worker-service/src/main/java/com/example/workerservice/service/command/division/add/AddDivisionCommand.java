package com.example.workerservice.service.command.division.add;

import com.example.workerservice.service.api.division.IAddDivisionCommandHandler;
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
public class AddDivisionCommand {

    @ApiModelProperty(value = "生成的科室大类别主键", hidden = true)
    private Integer id;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "科室大类别名称", example = "外科", required = true)
    private String name;

    @ApiModelProperty(value = "科室大类表描述", required = false)
    private String description;

    @ApiModelProperty(value = "状态", hidden = true)
    private String status;

    @ApiModelProperty(hidden = true)
    private IAddDivisionCommandHandler addDivisionCommandHandler;

    public AddDivisionCommand() {
        this.addDivisionCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IAddDivisionCommandHandler.class);
    }

    public AddDivisionCommand(Integer id, String name, String description, String status) {
        this();
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public void execute() {
        /* 执行方法 */
        this.addDivisionCommandHandler.action(this);
    }
}
