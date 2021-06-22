package com.example.workerservice.service.api.workerinfo;

import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.command.workerinfo.queryallbydepartid.QueryWorkerInfoListByDepartIdCommand;

import java.util.List;

/**
 * 接口 - IQueryWorkerInfoByDepartId
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
public interface IQueryWorkerInfoListByDepartIdCommandHandler {

    List<WorkerInfoVo> action(QueryWorkerInfoListByDepartIdCommand command);

}
