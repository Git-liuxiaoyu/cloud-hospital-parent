package com.example.physicalexamservice.service.command.physicalexamrecord.querydetaillistbyno;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordDetailVo;
import com.example.physicalexamservice.service.api.physicalexamrecord.IQueryPhysicalExamRecordDetailListByRecordNoCommandHandler;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import lombok.Data;

import java.util.List;

/**
 * 实体类 - 命令 - QueryPhysicalExamRecordDetailListByRecordNoCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/23
 */
@Data
public class QueryPhysicalExamRecordDetailListByRecordNoCommand {

    private String recordNo;

    private IQueryPhysicalExamRecordDetailListByRecordNoCommandHandler queryPhysicalExamRecordDetailListByRecordNoCommandHandler;

    public QueryPhysicalExamRecordDetailListByRecordNoCommand() {
        this.queryPhysicalExamRecordDetailListByRecordNoCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryPhysicalExamRecordDetailListByRecordNoCommandHandler.class);
    }

    public QueryPhysicalExamRecordDetailListByRecordNoCommand(String recordNo) {
        this();
        this.recordNo = recordNo;
    }

    public PhysicalExamRecordDetailVo execute() {
        /* 执行方法 */
        return this.queryPhysicalExamRecordDetailListByRecordNoCommandHandler.action(this);
    }

}
