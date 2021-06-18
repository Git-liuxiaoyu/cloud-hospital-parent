package com.example.workerservice.service.command.division.queryall;

import com.example.workerservice.inlet.web.vo.DivisionVo;
import com.example.workerservice.service.api.division.IQueryAllDivisionCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;

import java.util.List;

/**
 * 实体类 - 命令 - 查询所有Division
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/17
 */
public class QueryAllDivisionCommand {

    private IQueryAllDivisionCommandHandler queryAllDivisionCommandHandler;

    public QueryAllDivisionCommand() {
        this.queryAllDivisionCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryAllDivisionCommandHandler.class);
    }

    public List<DivisionVo> execute() {
        /* 执行方法并返回 */
        return this.queryAllDivisionCommandHandler.action();
    }
}
