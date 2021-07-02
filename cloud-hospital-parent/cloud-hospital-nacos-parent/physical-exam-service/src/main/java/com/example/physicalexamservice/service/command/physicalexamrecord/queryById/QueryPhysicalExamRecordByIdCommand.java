package com.example.physicalexamservice.service.command.physicalexamrecord.queryById;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.service.api.physicalexamrecord.IQueryPhysicalExamRecordByIdCommandHandler;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 实体类 - 命令 - QueryPhysicalExamRecordCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
@Data
@ApiModel
public class QueryPhysicalExamRecordByIdCommand {

    @ApiModelProperty(value = "体检单主键ID")
    private Long id;

    @ApiModelProperty(hidden = true)
    private IQueryPhysicalExamRecordByIdCommandHandler queryPhysicalExamRecordByIdCommandHandler;

    public QueryPhysicalExamRecordByIdCommand() {
        this.queryPhysicalExamRecordByIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryPhysicalExamRecordByIdCommandHandler.class);
    }

    public QueryPhysicalExamRecordByIdCommand(Long id) {
        this();
        this.id = id;
    }

    public PhysicalExamRecordVo execute() {
        return this.queryPhysicalExamRecordByIdCommandHandler.action(this);
    }
}
