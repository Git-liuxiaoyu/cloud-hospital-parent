package com.example.registerservice.inlet.web.controller;

import com.example.registerservice.inlet.web.vo.SubjectVo;
import com.example.registerservice.service.query.querysubject.QuerySubjectCommand;
import com.example.registerservice.util.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/14:31
 * @Description: 查询所有的科目的Controller
 */
@CrossOrigin
@RestController
public class SubjectController {
    @ApiOperation(value = "查询所有科室", notes = "查询所有科室发的是client",
            produces = "application/json", response = ResponseResult.class)
    @GetMapping("subject/querySubject")
    public ResponseResult<SubjectVo> findAll() {
        QuerySubjectCommand command = new QuerySubjectCommand();
        List<SubjectVo> execute = command.execute();
        return new ResponseResult(execute);
    }
}
