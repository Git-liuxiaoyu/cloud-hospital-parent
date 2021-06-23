package com.example.physicalexamservice.inlet.web.controller;

import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 控制器类 - PhysicalExamRecord
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("physical/exam/record")
public class PhysicalExamRecordController {

    /**
     * @return
     */
    @PostMapping("add")
    public ResponseResult<Long> addPhysicalExamRecord(@Valid @RequestBody AddPhysicalExamRecordCommand command, BindingResult bindingResult) {

        log.debug("{}",command);

        /* 判断是否绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("获取信息失败 | 参数异常");
        }

//        return ResponseResult.SUCCESS;

        /* 执行命令并返回 */
        return new ResponseResult<>(command.execute());
    }


}
