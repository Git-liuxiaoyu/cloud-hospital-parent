package com.example.physicalexamservice.inlet.web.controller;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTreatVo;
import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.example.physicalexamservice.service.command.physicalexam.queryall.QueryAllPhysicalExamListCommand;
import com.example.physicalexamservice.service.command.physicalexam.queryallbytypeid.QueryPhysicalExamListByTypeIdCommand;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制器类 - PhysicalExamController
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("physical/exam")
public class PhysicalExamController {

    /**
     * 找到所有检查项目
     *
     * @return
     */
    @GetMapping("view/all")
    @ApiOperation(value = "获得所有的检查项目", notes = "获得所有的检查项目", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<List<PhysicalExamTreatVo>> findAllPhysicalExamList(QueryAllPhysicalExamListCommand command) {
        /* 执行命令并返回 */
        return new ResponseResult<>(command.execute());
    }

    /**
     * 根据typeId查找
     *
     * @return
     */
    @GetMapping("view/list/{typeId}")
    @ApiOperation(value = "根据[检查类型主键ID]查询所有的检查项目", notes = "根据[检查类型主键ID]查询所有的检查项目", produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeId", value = "检查类型主键ID", required = true, dataType = "Integer", paramType = "path")
    })
    public ResponseResult<List<PhysicalExamTreatVo>> findPhysicalExamListByTypeId(@PathVariable("typeId") Integer typeId) {
        /* 匿名实例化命令类,执行命令并返回 */
        return new ResponseResult<>(new QueryPhysicalExamListByTypeIdCommand(typeId).execute());
    }


}
