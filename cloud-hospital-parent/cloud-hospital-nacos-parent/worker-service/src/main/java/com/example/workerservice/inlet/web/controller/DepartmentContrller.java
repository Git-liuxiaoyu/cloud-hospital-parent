package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.command.department.queryallbydivision.QueryAllDepartmentByDivisionIdCommand;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制器类 - Department控制器
 */
@CrossOrigin
@Slf4j
@RequestMapping("depart")
@RestController
@Api(value = "科室 - 接口", description = "科室 API")
public class DepartmentContrller {

    /**
     * 通过DivisionId获得全部Department
     *
     * @param divisionId
     * @return
     */
    @GetMapping("all/{divisionId}")
    @ApiOperation(value = "根据科目大类别主键ID获取在该科目下所有的科室", notes = "根据科目大类别主键ID获取在该科目下所有的科室,科目大类别的意思是科室[心脏内科]和科室[心脏外科]均属于类别[心脏中心]", produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "divisionId", value = "科目大类别主键ID", required = true, dataType = "Integer", paramType = "path")
    })
    public ResponseResult<List<QueryAllDepartmentByDivisionIdCommand.DepartmentVo>> getDepartmentListByDivisionId(@PathVariable("divisionId") Integer divisionId) {
        log.debug("divisionId -> {}", divisionId);
        /* 实例化一个命令 */
        return new ResponseResult<>(new QueryAllDepartmentByDivisionIdCommand(divisionId).execute());
    }


}
