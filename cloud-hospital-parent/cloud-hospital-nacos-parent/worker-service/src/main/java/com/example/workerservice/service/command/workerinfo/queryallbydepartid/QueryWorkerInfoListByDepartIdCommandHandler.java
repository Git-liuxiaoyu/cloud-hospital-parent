package com.example.workerservice.service.command.workerinfo.queryallbydepartid;

import com.example.workerservice.adapter.WorkerInfoDaoAdapter;
import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.api.workerinfo.IQueryWorkerInfoListByDepartIdCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口实现类 - 实现 -
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Component
@Slf4j
public class QueryWorkerInfoListByDepartIdCommandHandler implements IQueryWorkerInfoListByDepartIdCommandHandler {
    /* 构造注入 - BEGIN */
    private final WorkerInfoDaoAdapter workerInfoDaoAdapter;

    public QueryWorkerInfoListByDepartIdCommandHandler(WorkerInfoDaoAdapter workerInfoDaoAdapter) {
        this.workerInfoDaoAdapter = workerInfoDaoAdapter;
    }
    /* 构造注入 - END */

    @Override
    public List<WorkerInfoVo> action(QueryWorkerInfoListByDepartIdCommand command) {
        /* 执行方法并返回 */
        return workerInfoDaoAdapter.queryListByDepartId(command.getDepartmentId(), WorkerInfoVo.STATUS_NORMAL);
    }
}
