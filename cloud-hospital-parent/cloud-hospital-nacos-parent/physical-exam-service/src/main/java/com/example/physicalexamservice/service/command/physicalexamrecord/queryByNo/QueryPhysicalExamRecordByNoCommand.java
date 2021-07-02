package com.example.physicalexamservice.service.command.physicalexamrecord.queryByNo;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.service.api.physicalexamrecord.IQueryPhysicalExamRecordByNoCommandHandler;
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
public class QueryPhysicalExamRecordByNoCommand {

    @ApiModelProperty(value = "体检单编号No")
    private String no;

    @ApiModelProperty(hidden = true)
    private IQueryPhysicalExamRecordByNoCommandHandler queryPhysicalExamRecordByNoCommandHandler;

    public QueryPhysicalExamRecordByNoCommand() {
        this.queryPhysicalExamRecordByNoCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryPhysicalExamRecordByNoCommandHandler.class);
    }

    public QueryPhysicalExamRecordByNoCommand(String no) {
        this();
        this.no = no;
    }

    public PhysicalExamRecordVo execute() {
        return this.queryPhysicalExamRecordByNoCommandHandler.action(this);
    }
}
