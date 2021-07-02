package com.example.physicalexamservice.service.command.physicalexamrecord.payed;

import com.example.physicalexamservice.service.api.physicalexamrecord.IUpdatePhysicalExamRecordPayedCommandHandler;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 实体类 - 命令 - UpdatePhysicalExamRecordPayedCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
@Data
@ApiModel
public class UpdatePhysicalExamRecordPayedCommand {

    @ApiModelProperty(value = "要修改为支付状态的体检单主键ID", example = "1")
    private Long id;

    @ApiModelProperty(hidden = true)
    private IUpdatePhysicalExamRecordPayedCommandHandler updatePhysicalExamRecordPayedCommandHandler;

    public UpdatePhysicalExamRecordPayedCommand() {
        this.updatePhysicalExamRecordPayedCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IUpdatePhysicalExamRecordPayedCommandHandler.class);
    }

    public UpdatePhysicalExamRecordPayedCommand(Long id) {
        this();
        this.id = id;
    }

    public void execute() {
        /* 执行方法 */
        this.updatePhysicalExamRecordPayedCommandHandler.action(this);
    }

}
