package com.example.physicalexamservice.service.command.physicalexam.queryall;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTreatVo;
import com.example.physicalexamservice.service.api.physicalexam.IQueryAllPhysicalExamListCommandHandler;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 实体类 - 命令 - QueryAllPhysicalExamListCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@Slf4j
public class QueryAllPhysicalExamListCommand {

    private IQueryAllPhysicalExamListCommandHandler queryAllPhysicalExamListCommandHandler;

    public QueryAllPhysicalExamListCommand() {
        this.queryAllPhysicalExamListCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryAllPhysicalExamListCommandHandler.class);
    }

    public List<PhysicalExamTreatVo> execute() {
        /* 执行命令 */
        return this.queryAllPhysicalExamListCommandHandler.action(this);
    }

}
