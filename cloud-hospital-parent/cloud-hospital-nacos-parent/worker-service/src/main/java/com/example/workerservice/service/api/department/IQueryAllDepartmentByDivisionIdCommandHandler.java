package com.example.workerservice.service.api.department;

import com.example.workerservice.inlet.web.vo.DepartmentVo;
import com.example.workerservice.service.command.department.queryallbydivision.QueryAllDepartmentByDivisionIdCommand;
import com.example.workerservice.service.command.division.queryall.QueryAllDivisionCommand;

import java.util.List;

/**
 * 接口 - IQueryAllDepartmentByDivisionIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
public interface IQueryAllDepartmentByDivisionIdCommandHandler {

    List<DepartmentVo> action(QueryAllDepartmentByDivisionIdCommand command);

}
