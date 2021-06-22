package com.example.workerservice.service.command.workerinfo.queryallbydepartid;

import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.api.workerinfo.IQueryWorkerInfoListByDepartIdCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 实体类 - 命令 - QueryWorkerInfoListByDepartIdCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Data
@Slf4j
public class QueryWorkerInfoListByDepartIdCommand {

    private Integer departmentId;

    private IQueryWorkerInfoListByDepartIdCommandHandler queryWorkerInfoListByDepartIdCommandHandler;

    public QueryWorkerInfoListByDepartIdCommand() {
        this.queryWorkerInfoListByDepartIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryWorkerInfoListByDepartIdCommandHandler.class);
    }

    public QueryWorkerInfoListByDepartIdCommand(Integer departmentId) {
        this();
        this.departmentId = departmentId;
    }

    public List<WorkerInfoVo> execute() {
        /* 执行方法 */
        return this.queryWorkerInfoListByDepartIdCommandHandler.action(this);
    }

}
