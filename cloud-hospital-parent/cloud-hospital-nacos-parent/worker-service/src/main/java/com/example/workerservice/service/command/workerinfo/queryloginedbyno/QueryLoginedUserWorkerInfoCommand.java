package com.example.workerservice.service.command.workerinfo.queryloginedbyno;

import com.example.workerservice.inlet.web.vo.WorkerInfoLoginedVo;
import com.example.workerservice.service.api.workerinfo.IQueryLoginedUserWorkerInfoCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;

/**
 * 实体类 - 命令 - QueryLoginedUserWorkerInfoCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Data
public class QueryLoginedUserWorkerInfoCommand {

    private String workerNo;

    private IQueryLoginedUserWorkerInfoCommandHandler queryLoginedUserWorkerInfoCommandHandler;

    public QueryLoginedUserWorkerInfoCommand() {
        this.queryLoginedUserWorkerInfoCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryLoginedUserWorkerInfoCommandHandler.class);
    }

    public QueryLoginedUserWorkerInfoCommand(String workerNo) {
        this();
        this.workerNo = workerNo;
    }

    public WorkerInfoLoginedVo execute() {
        /* 执行方法 */
        return this.queryLoginedUserWorkerInfoCommandHandler.action(this);
    }

}
