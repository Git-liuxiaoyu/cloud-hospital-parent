package com.example.workerservice.service.command.workerinfo.querybyno;

import com.example.workerservice.adapter.WorkerInfoDaoAdapter;
import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.api.workerinfo.IQueryWorkerInfoByNoCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 - IQueryWorkerInfoByNoCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Component
@Slf4j
public class QueryWorkerInfoByNoCommandHandler implements IQueryWorkerInfoByNoCommandHandler {

    /* 构造注入 - BEGIN */
    private final WorkerInfoDaoAdapter workerInfoDaoAdapter;

    public QueryWorkerInfoByNoCommandHandler(WorkerInfoDaoAdapter workerInfoDaoAdapter) {
        this.workerInfoDaoAdapter = workerInfoDaoAdapter;
    }
    /* 构造注入 - END */

    @Override
    public WorkerInfoVo action(QueryWorkerByNoCommand command) {
        try {
            return workerInfoDaoAdapter.queryByWorkerNo(command.getNo());
        } catch (NullPointerException e) {
            /* 捕获到异常 NullPointerException , 则抛异常 WorkerInfoNotFoundException */
            throw new WorkerInfoNotFoundException();
        }
    }
}
