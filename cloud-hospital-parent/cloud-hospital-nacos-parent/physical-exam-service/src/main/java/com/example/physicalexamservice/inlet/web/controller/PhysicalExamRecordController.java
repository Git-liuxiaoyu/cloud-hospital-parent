package com.example.physicalexamservice.inlet.web.controller;

import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.VoidType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器类 - PhysicalExamRecord
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("physica/exam/record")
public class PhysicalExamRecordController {

    /**
     *
     * @return
     */
    @GetMapping("add")
    public ResponseResult<Void> addPhysicalExamRecord(){



        /* 返回 */
        return ResponseResult.SUCCESS;
    }


}
