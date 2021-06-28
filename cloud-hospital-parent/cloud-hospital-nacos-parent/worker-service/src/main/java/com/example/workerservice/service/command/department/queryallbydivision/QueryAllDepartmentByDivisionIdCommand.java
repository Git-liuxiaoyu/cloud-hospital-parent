package com.example.workerservice.service.command.department.queryallbydivision;

import com.example.workerservice.service.api.department.IQueryAllDepartmentByDivisionIdCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 实体类 - 命令 - 根据DivisionId查所有
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Data
@ApiModel
public class QueryAllDepartmentByDivisionIdCommand {

    @ApiModelProperty(value = "科室大类别主键ID")
    private Integer divisionId;

    @ApiModelProperty(hidden = true)
    private IQueryAllDepartmentByDivisionIdCommandHandler queryAllDepartmentByDivisionIdCommandHandler;


    /*  */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class DepartmentVo {

        @ApiModelProperty(value = "科室主键ID", example = "1")
        private Integer id;

        @ApiModelProperty(value = "科室大类别主键ID", example = "1")
        private Integer divisionid;

        @ApiModelProperty(value = "科室名称", example = "心脏外科")
        private String name;

        @ApiModelProperty(value = "科室状态", example = "1")
        private String status;

        public static final String STATUS_NORMAL = "1";

    }

    public QueryAllDepartmentByDivisionIdCommand() {
        this.queryAllDepartmentByDivisionIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryAllDepartmentByDivisionIdCommandHandler.class);
    }

    public QueryAllDepartmentByDivisionIdCommand(Integer divisionId) {
        this();
        this.divisionId = divisionId;
    }

    public List<DepartmentVo> execute() {
        /* 执行方法 */
        return queryAllDepartmentByDivisionIdCommandHandler.action(this);
    }

}
