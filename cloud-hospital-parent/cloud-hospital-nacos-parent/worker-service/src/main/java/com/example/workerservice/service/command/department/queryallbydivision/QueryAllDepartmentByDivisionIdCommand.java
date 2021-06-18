package com.example.workerservice.service.command.department.queryallbydivision;

import com.example.workerservice.inlet.web.vo.DepartmentVo;
import com.example.workerservice.service.api.department.IQueryAllDepartmentByDivisionIdCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;

import java.util.List;

/**
 * 实体类 - 命令 - 根据DivisionId查所有
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Data
public class QueryAllDepartmentByDivisionIdCommand {

    private Integer divisionId;

    private IQueryAllDepartmentByDivisionIdCommandHandler queryAllDepartmentByDivisionIdCommandHandler;


    public QueryAllDepartmentByDivisionIdCommand() {
        this.queryAllDepartmentByDivisionIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryAllDepartmentByDivisionIdCommandHandler.class);
    }

    public QueryAllDepartmentByDivisionIdCommand(Integer divisionId) {
        this();
        this.divisionId = divisionId;
    }

    public List<DepartmentVo> execute(){
        /* 执行方法 */
        return queryAllDepartmentByDivisionIdCommandHandler.action(this);
    }

}
