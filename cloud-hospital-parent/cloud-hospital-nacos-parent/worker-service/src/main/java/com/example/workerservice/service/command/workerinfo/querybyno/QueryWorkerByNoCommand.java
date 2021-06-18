package com.example.workerservice.service.command.workerinfo.querybyno;

import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.api.workerinfo.IQueryWorkerInfoByNoCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 实体类 - 命令 - QueryWorkerByNoCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Data
@Slf4j
public class QueryWorkerByNoCommand {

    private String no;

    private IQueryWorkerInfoByNoCommandHandler queryWorkerInfoByNoCommandHandler;

    public QueryWorkerByNoCommand() {
        this.queryWorkerInfoByNoCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryWorkerInfoByNoCommandHandler.class);
    }

    public QueryWorkerByNoCommand(String no) {
        this();
        this.no = no;
    }

    public WorkerInfoVo execute(){
        return this.queryWorkerInfoByNoCommandHandler.action(this);
    }

}
