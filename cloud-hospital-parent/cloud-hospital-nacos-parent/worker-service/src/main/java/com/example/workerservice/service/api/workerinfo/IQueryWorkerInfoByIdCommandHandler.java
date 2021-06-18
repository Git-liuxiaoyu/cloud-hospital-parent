package com.example.workerservice.service.api.workerinfo;

import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.command.workerinfo.querybyid.QueryWorkerByIdCommand;

/**
 * 接口 - IQueryWorkerInfoByIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
public interface IQueryWorkerInfoByIdCommandHandler {

    WorkerInfoVo action(QueryWorkerByIdCommand command);

    /**
     * 自定义业务异常 - 员工未发现
     **/
    class WorkerInfoNotFoundException extends RuntimeException {
        public WorkerInfoNotFoundException() {
            super("找不到该员工");
        }
    }

}
