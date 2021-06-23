package com.example.physicalexamservice.service.command.physicalexam.queryallbytypeid;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTreatVo;
import com.example.physicalexamservice.service.api.physicalexam.IQueryPhysicalExamListByTypeIdCommandHandler;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 实体类 - 命令 - QueryPhysicalExamListByTypeIdCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@Slf4j
public class QueryPhysicalExamListByTypeIdCommand {

    private Integer typeId;

    private IQueryPhysicalExamListByTypeIdCommandHandler queryPhysicalExamListByTypeIdCommandHandler;

    public QueryPhysicalExamListByTypeIdCommand() {
        this.queryPhysicalExamListByTypeIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryPhysicalExamListByTypeIdCommandHandler.class);
    }

    public QueryPhysicalExamListByTypeIdCommand(Integer typeId) {
        this();
        this.typeId = typeId;
    }

    public List<PhysicalExamTreatVo> execute(){
        return this.queryPhysicalExamListByTypeIdCommandHandler.action(this);
    }
}
