package com.example.workerservice.service.command.division.queryall;

import com.example.workerservice.service.api.division.IQueryAllDivisionCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
 * 实体类 - 命令 - 查询所有Division
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/17
 */
@ApiModel
public class QueryAllDivisionCommand {

    @ApiModelProperty(hidden = true)
    private IQueryAllDivisionCommandHandler queryAllDivisionCommandHandler;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder(toBuilder = true)
    public static class DivisionVo {

        @ApiModelProperty(value = "科目主键ID", example = "1")
        private Integer id;

        @ApiModelProperty(value = "科目名称", example = "心脏中心")
        private String name;


    }

    public QueryAllDivisionCommand() {
        this.queryAllDivisionCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryAllDivisionCommandHandler.class);
    }

    public List<DivisionVo> execute() {
        /* 执行方法并返回 */
        return this.queryAllDivisionCommandHandler.action();
    }
}
