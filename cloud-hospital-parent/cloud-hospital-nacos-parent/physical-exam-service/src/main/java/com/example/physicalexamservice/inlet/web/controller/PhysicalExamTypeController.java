package com.example.physicalexamservice.inlet.web.controller;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTypeTreatVo;
import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.example.physicalexamservice.service.command.physicalexamtype.queryall.QueryAllPhysicalExamTypeListCommand;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("physical/exam/type")
public class PhysicalExamTypeController {

    /**
     * 获得所有检查类型
     *
     * @return
     */
    @GetMapping("view/all")
    @ApiOperation(value = "获得所有的检查类型", notes = "获得所有的检查类型", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<List<PhysicalExamTypeTreatVo>> findAllPhysicalExamTypeList(QueryAllPhysicalExamTypeListCommand command) {
        /* 执行方法并返回 */
        return new ResponseResult<>(command.execute());
    }

}
