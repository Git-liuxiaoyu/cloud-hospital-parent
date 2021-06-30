package com.example.workerservice.service.api.division;

import com.example.workerservice.inlet.web.vo.DivisionVo;
import com.example.workerservice.service.command.division.queryById.QueryDivisionByIdCommand;

/**
 * 接口 - IQueryDivisionByIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/28
 */
public interface IQueryDivisionByIdCommandHandler {

    DivisionVo action(QueryDivisionByIdCommand command);

}
