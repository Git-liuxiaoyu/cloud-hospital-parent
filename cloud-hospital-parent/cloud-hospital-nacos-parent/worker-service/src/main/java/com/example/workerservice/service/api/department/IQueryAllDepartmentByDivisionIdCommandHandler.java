package com.example.workerservice.service.api.department;

import com.example.workerservice.inlet.web.vo.DepartmentVo;
import com.example.workerservice.service.command.department.queryallbydivision.QueryAllDepartmentByDivisionIdCommand;

import java.util.List;

/**
 * 接口 - IQueryAllDepartmentByDivisionIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
public interface IQueryAllDepartmentByDivisionIdCommandHandler {

    List<QueryAllDepartmentByDivisionIdCommand.DepartmentVo> action(QueryAllDepartmentByDivisionIdCommand command);

    /**
     * 自定义业务异常 - 科室类别未发现
     **/
    class DivisionNotFoundException extends RuntimeException {
        public DivisionNotFoundException() {
            super("科室类别未发现");
        }
    }

}
