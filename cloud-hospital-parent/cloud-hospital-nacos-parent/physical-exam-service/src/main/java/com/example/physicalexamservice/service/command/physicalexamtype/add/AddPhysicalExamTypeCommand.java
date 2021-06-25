package com.example.physicalexamservice.service.command.physicalexamtype.add;

import com.example.physicalexamservice.service.api.physicalexamtype.IAddPhysicalExamTypeCommandHandler;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 实体类 - 命令 AddPhysicalExamTypeCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@ApiModel
@Data
public class AddPhysicalExamTypeCommand {

    @ApiModelProperty(hidden = true)
    private Integer id;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "检查类型名称", example = "核磁共振")
    private String name;

    private String description;

    @ApiModelProperty(hidden = true)
    private IAddPhysicalExamTypeCommandHandler addPhysicalExamTypeCommandHandler;

    public AddPhysicalExamTypeCommand() {
        this.addPhysicalExamTypeCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IAddPhysicalExamTypeCommandHandler.class);
    }

    public AddPhysicalExamTypeCommand(Integer id, String name, String description) {
        this();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer execute() {
        /* 执行方法 */
        return this.addPhysicalExamTypeCommandHandler.action(this);
    }
}
