package com.example.physicalexamservice.inlet.web.controller;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTypeTreatVo;
import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.example.physicalexamservice.service.command.physicalexamtype.add.AddPhysicalExamTypeCommand;
import com.example.physicalexamservice.service.command.physicalexamtype.queryall.QueryAllPhysicalExamTypeListCommand;
import com.example.physicalexamservice.service.command.physicalexamtype.update.UpdatePhysicalExamTypeCommand;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    /**
     * 修改检查类型
     *
     * @return
     */
    @GetMapping("update")
    @ApiOperation(value = "修改检查类型", notes = "修改检查类型", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<Void> updatePhysicalExamType(UpdatePhysicalExamTypeCommand command) {
        /* 执行方法 */
        command.execute();
        /* 执行方法并返回 */
        return ResponseResult.SUCCESS;
    }


    /**
     * 新增体检类型
     *
     * @return
     */
    @PostMapping("add")
    @ApiOperation(value = "添加检查类型", notes = "添加检查类型,返回值为添加检查类型的主键ID", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<Integer> addPhysicalExamType(@Valid @RequestBody AddPhysicalExamTypeCommand command, BindingResult bindingResult) {
        /* 绑定是否出错 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("添加检查类型失败 | 参数错误");
        }
        /* 执行方法并返回 */
        return new ResponseResult<>(command.execute());
    }

}
