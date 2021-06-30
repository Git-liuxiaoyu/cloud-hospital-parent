package com.example.workerservice.service.command.division.queryById;

import com.example.workerservice.inlet.web.vo.DivisionVo;
import com.example.workerservice.service.api.division.IQueryDivisionByIdCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/28
 */
@Data
@ApiModel
public class QueryDivisionByIdCommand {

    @ApiModelProperty(value = "科室大类别ID", example = "1", required = true)
    private Integer divisionId;

    private IQueryDivisionByIdCommandHandler queryDivisionByIdCommandHandler;

    public QueryDivisionByIdCommand() {
        this.queryDivisionByIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryDivisionByIdCommandHandler.class);
    }

    public QueryDivisionByIdCommand(Integer divisionId) {
        this();
        this.divisionId = divisionId;
    }

    public DivisionVo execute() {
        /* 执行方法 */
        return this.queryDivisionByIdCommandHandler.action(this);
    }

}
