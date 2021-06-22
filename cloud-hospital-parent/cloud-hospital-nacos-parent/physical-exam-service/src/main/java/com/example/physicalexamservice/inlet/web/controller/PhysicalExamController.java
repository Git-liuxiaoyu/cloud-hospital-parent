package com.example.physicalexamservice.inlet.web.controller;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTreatVo;
import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.example.physicalexamservice.service.command.physicalexam.queryall.QueryAllPhysicalExamListCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseResult<List<PhysicalExamTreatVo>> findAllPhysicalExamList(QueryAllPhysicalExamListCommand command) {
        /* 执行命令并返回 */
        return new ResponseResult<>(command.execute());
    }

}
