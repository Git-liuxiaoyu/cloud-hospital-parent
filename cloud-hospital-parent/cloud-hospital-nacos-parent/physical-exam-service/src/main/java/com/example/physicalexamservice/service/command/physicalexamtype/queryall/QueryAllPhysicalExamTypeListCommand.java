package com.example.physicalexamservice.service.command.physicalexamtype.queryall;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTreatVo;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTypeTreatVo;
import com.example.physicalexamservice.service.api.physicalexamtype.IQueryAllPhysicalExamTypeListCommandHandler;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 实体类 - Command  - QueryAllPhysicalExamTypeListCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@Slf4j
public class QueryAllPhysicalExamTypeListCommand {

    private IQueryAllPhysicalExamTypeListCommandHandler queryAllPhysicalExamTypeListCommandHandler;

    public QueryAllPhysicalExamTypeListCommand() {
        this.queryAllPhysicalExamTypeListCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryAllPhysicalExamTypeListCommandHandler.class);
    }

    public List<PhysicalExamTypeTreatVo> execute() {
        /* 执行方法 */
        return this.queryAllPhysicalExamTypeListCommandHandler.action(this);
    }
}
