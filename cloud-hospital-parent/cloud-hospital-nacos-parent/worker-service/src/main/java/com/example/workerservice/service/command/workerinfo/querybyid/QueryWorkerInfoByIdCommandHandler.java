package com.example.workerservice.service.command.workerinfo.querybyid;

import com.example.workerservice.adapter.WorkerInfoDaoAdapter;
import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.api.workerinfo.IQueryWorkerInfoByIdCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 - IQueryWorkerInfoByIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Component
@Slf4j
public class QueryWorkerInfoByIdCommandHandler implements IQueryWorkerInfoByIdCommandHandler {

    /* 构造注入 - BEGIN */
    private final WorkerInfoDaoAdapter workerInfoDaoAdapter;

    public QueryWorkerInfoByIdCommandHandler(WorkerInfoDaoAdapter workerInfoDaoAdapter) {
        this.workerInfoDaoAdapter = workerInfoDaoAdapter;
    }
    /* 构造注入 -END */

    @Override
    public WorkerInfoVo action(QueryWorkerByIdCommand command) {
        try {
            return workerInfoDaoAdapter.queryById(command.getId());
        } catch (NullPointerException e) {
            /* 捕获到 NullPointerException , 则抛 WorkerInfoNotFoundException */
            throw new WorkerInfoNotFoundException();
        }
    }
}
