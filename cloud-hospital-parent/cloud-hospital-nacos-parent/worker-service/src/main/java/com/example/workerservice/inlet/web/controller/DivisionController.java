package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.DivisionVo;
import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.command.division.queryall.QueryAllDivisionCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseResult<List<DivisionVo>> getDivisionList(){
        QueryAllDivisionCommand command = new QueryAllDivisionCommand();
        /* 执行命令并返回值 */
        return new ResponseResult<>(command.execute());
    }

}
