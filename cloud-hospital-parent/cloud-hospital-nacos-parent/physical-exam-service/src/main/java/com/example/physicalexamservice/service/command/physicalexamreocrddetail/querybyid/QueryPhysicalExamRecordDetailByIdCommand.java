package com.example.physicalexamservice.service.command.physicalexamreocrddetail.querybyid;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordDetailVo;
import com.example.physicalexamservice.service.api.physicalexamrecorddetail.IQueryPhysicalExamRecordDetailByIdCommandHandler;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 接口 - 命令 - QueryPhysicalExamRecordDetailByIdCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
@Data
@Slf4j
@ApiModel
public class QueryPhysicalExamRecordDetailByIdCommand {

    @ApiModelProperty(value = "体检详情主键ID", example = "1")
    private Long id;

    @ApiModelProperty(hidden = true)
    private IQueryPhysicalExamRecordDetailByIdCommandHandler queryPhysicalExamRecordDetailByIdCommandHandler;

    public QueryPhysicalExamRecordDetailByIdCommand() {
        this.queryPhysicalExamRecordDetailByIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryPhysicalExamRecordDetailByIdCommandHandler.class);
    }

    public QueryPhysicalExamRecordDetailByIdCommand(Long id) {
        this();
        this.id = id;
    }

    public PhysicalExamRecordDetailVo execute() {
        /* 执行方法 */
        return this.queryPhysicalExamRecordDetailByIdCommandHandler.action(this);
    }
}
