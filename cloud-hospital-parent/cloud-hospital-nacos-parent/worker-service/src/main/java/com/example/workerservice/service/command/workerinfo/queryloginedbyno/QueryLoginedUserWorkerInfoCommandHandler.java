package com.example.workerservice.service.command.workerinfo.queryloginedbyno;

import com.example.workerservice.adapter.WorkerInfoDaoAdapter;
import com.example.workerservice.inlet.web.vo.WorkerInfoLoginedVo;
import com.example.workerservice.service.api.workerinfo.IQueryLoginedUserWorkerInfoCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 -
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Component
@Slf4j
public class QueryLoginedUserWorkerInfoCommandHandler implements IQueryLoginedUserWorkerInfoCommandHandler {

    /* 构造注入 - 开始 */
    private final WorkerInfoDaoAdapter workerInfoDaoAdapter;

    public QueryLoginedUserWorkerInfoCommandHandler(WorkerInfoDaoAdapter workerInfoDaoAdapter) {
        this.workerInfoDaoAdapter = workerInfoDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public WorkerInfoLoginedVo action(QueryLoginedUserWorkerInfoCommand command) {
        return workerInfoDaoAdapter.queryLoginedByWorkerNo(command.getWorkerNo());
    }
}
