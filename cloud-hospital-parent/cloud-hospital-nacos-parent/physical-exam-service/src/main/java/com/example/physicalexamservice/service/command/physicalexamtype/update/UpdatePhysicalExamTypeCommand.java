package com.example.physicalexamservice.service.command.physicalexamtype.update;

import com.example.physicalexamservice.service.api.physicalexamtype.IUpdatePhysicalExamTypeCommandHandler;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 实体类 - 命令 - UpdatePhysicalExamTypeCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Data
@ApiModel
public class UpdatePhysicalExamTypeCommand {

    @NotNull
    @ApiModelProperty(value = "需要修改的检查类型的主键ID",required = true)
    private Integer id;

    @ApiModelProperty(value = "想要修改的检查类型的名称",required = true)
    @NotNull
    @NotBlank
    private String name;

    @ApiModelProperty(value = "想要修改的检查类型的描述")
    private String description;

    @ApiModelProperty(hidden = true)
    private IUpdatePhysicalExamTypeCommandHandler updatePhysicalExamTypeCommandHandler;

    public UpdatePhysicalExamTypeCommand() {
        this.updatePhysicalExamTypeCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IUpdatePhysicalExamTypeCommandHandler.class);
    }

    public UpdatePhysicalExamTypeCommand(Integer id, String name, String description) {
        this();
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public void execute(){
        /* 执行方法 */
        this.updatePhysicalExamTypeCommandHandler.action(this);
    }

}
