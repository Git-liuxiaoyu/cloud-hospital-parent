package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.DivisionVo;
import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.command.division.add.AddDivisionCommand;
import com.example.workerservice.service.command.division.queryById.QueryDivisionByIdCommand;
import com.example.workerservice.service.command.division.queryall.QueryAllDivisionCommand;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/17
 */
@RestController
@RequestMapping("division")
@Slf4j
@CrossOrigin
@Api(value = "科室大类别(科目) - 接口", description = "科目 API")
public class DivisionController {

    /**
     * 查询所有正常Division
     *
     * @return
     */
    @PostMapping("all")
    @ApiOperation(value = "获取全部科室大类别(科目)", notes = "获取全部科室大类别(科目)", produces = "application/json", response = ResponseResult.class)
    @ApiOperationSupport(ignoreParameters = "queryAllDivisionCommandHandler")
    public ResponseResult<List<QueryAllDivisionCommand.DivisionVo>> getDivisionList(QueryAllDivisionCommand command) {
        /* 执行命令并返回值 */
        return new ResponseResult<>(command.execute());
    }


    /**
     * 添加Division
     *
     * @return
     */
    @PostMapping("add")
    @ApiOperation(value = "添加新的科室大类别(科目)", notes = "添加新的科室大类别(科目)", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<Void> addDivision(AddDivisionCommand command) {
        /* 执行命令并返回值 */
        command.execute();
        return ResponseResult.SUCCESS;
    }

    /**
     * 修改Division
     *
     * @return
     */
    @PostMapping("update")
    @ApiOperation(value = "修改已知科室大类别(科目)", notes = "修改已知科室大类别(科目)", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<Void> updateDivision(AddDivisionCommand command) {
        /* 执行命令并返回值 */
        command.execute();
        return ResponseResult.SUCCESS;
    }


    /**
     * 根据DivisionId查询
     *
     * @return
     */
    @PostMapping("view/{id}")
    @ApiOperation(value = "根据科室大类别(科目)主键ID查询详细信息", notes = "根据科室大类别(科目)主键ID查询详细信息", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<DivisionVo> viewDivision(@PathVariable("id") Integer id) {
        /* 执行命令并返回值 */
        return new ResponseResult<>(new QueryDivisionByIdCommand(id).execute());
    }

}
