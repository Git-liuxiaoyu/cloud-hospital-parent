package com.example.workerservice.service.command.department.queryallbydivision;

import com.example.workerservice.adapter.DepartmentDaoAdapter;
import com.example.workerservice.inlet.web.vo.DepartmentVo;
import com.example.workerservice.service.api.department.IQueryAllDepartmentByDivisionIdCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口实现类 - 实现 - IQueryAllDepartmentByDivisionIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Component
@Slf4j
public class QueryAllDepartmentByDivisionIdCommandHandler implements IQueryAllDepartmentByDivisionIdCommandHandler {

    /* 构造注入 - 开始 */
    private final DepartmentDaoAdapter departmentDaoAdapter;

    public QueryAllDepartmentByDivisionIdCommandHandler(DepartmentDaoAdapter departmentDaoAdapter) {
        this.departmentDaoAdapter = departmentDaoAdapter;
    }
    /* 构造注入 - 结束 */


    @Override
    public List<DepartmentVo> action(QueryAllDepartmentByDivisionIdCommand command) {
        /* 执行方法并返回 */
        return departmentDaoAdapter.queryAllByDivisionIdAndStatus(command.getDivisionId(),DepartmentVo.STATUS_NORMAL);
    }
}
