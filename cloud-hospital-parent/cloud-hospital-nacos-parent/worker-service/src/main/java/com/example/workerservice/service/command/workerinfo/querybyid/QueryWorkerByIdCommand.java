package com.example.workerservice.service.command.workerinfo.querybyid;

import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.api.workerinfo.IQueryWorkerInfoByIdCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 实体类 - 命令 - QueryWorkerByIdCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Data
@Slf4j
public class QueryWorkerByIdCommand {

    private Integer id;

    private IQueryWorkerInfoByIdCommandHandler queryWorkerInfoByIdCommandHandler;

    public QueryWorkerByIdCommand() {
        this.queryWorkerInfoByIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryWorkerInfoByIdCommandHandler.class);
    }

    public QueryWorkerByIdCommand(Integer id) {
        this();
        this.id = id;
    }

    public WorkerInfoVo execute() {
        return queryWorkerInfoByIdCommandHandler.action(this);
    }

}
