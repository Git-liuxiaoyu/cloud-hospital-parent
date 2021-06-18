package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.DepartmentVo;
import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.command.department.queryallbydivision.QueryAllDepartmentByDivisionIdCommand;
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
public class DepartmentContrller {

    /**
     * 通过DivisionId获得全部Department
     *
     * @param divisionId
     * @return
     */
    @GetMapping ("all/{divisionId}")
    public ResponseResult<List<DepartmentVo>> getDepartmentListByDivisionId(@PathVariable("divisionId") Integer divisionId) {
        /* 实例化一个命令 */
        return new ResponseResult<>(new QueryAllDepartmentByDivisionIdCommand(divisionId).execute());
    }


}
