package com.example.registerservice.inlet.web.controller;

import com.example.registerservice.inlet.web.vo.SubjectTypeVo;
import com.example.registerservice.inlet.web.vo.SubjectVo;
import com.example.registerservice.service.query.querysubjecttype.QuerySubjectTypeCommand;
import com.example.registerservice.util.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/14:31
 * @Description: 查询所有的科目类型的Controller
 */
@CrossOrigin
@RestController
public class SubjectTypeController {

    @ApiOperation(value = "查询所有科目类型", notes = "查询所有科目类型发的是client",
            produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "科目id",
                    example = "1", required = true, dataType = "Long", paramType = "path")
    })
    @GetMapping("subject/querySubject/getById/{id}")
    public ResponseResult<SubjectTypeVo> getDepartmentListByDivisionId(@PathVariable("id") Long id) {
        QuerySubjectTypeCommand command = new QuerySubjectTypeCommand(id);
        List<SubjectTypeVo> execute = command.execute();
        return new ResponseResult(execute);
    }
}
