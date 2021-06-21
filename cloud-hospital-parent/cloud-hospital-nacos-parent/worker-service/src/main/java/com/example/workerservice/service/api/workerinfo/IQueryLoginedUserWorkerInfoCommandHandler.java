package com.example.workerservice.service.api.workerinfo;

import com.example.workerservice.inlet.web.vo.WorkerInfoLoginedVo;
import com.example.workerservice.service.command.workerinfo.queryloginedbyno.QueryLoginedUserWorkerInfoCommand;

/**
 * 接口 - IQueryLoginedUserWorkedInfoCommndHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
public interface IQueryLoginedUserWorkerInfoCommandHandler {

    WorkerInfoLoginedVo action(QueryLoginedUserWorkerInfoCommand command);

}
