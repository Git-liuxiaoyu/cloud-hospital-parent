package com.example.physicalexamservice.inlet.web.controller;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordDetailVo;
import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;
import com.example.physicalexamservice.service.command.physicalexamrecord.querydetaillistbyno.QueryPhysicalExamRecordDetailListByRecordNoCommand;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
     * 添加体检记录(体检单)
     *
     * @return
     */
    @PostMapping("add")
    @ApiOperation(value = "添加体检记录(体检单)", notes = "添加体检记录单,连带医生设置的体检记录详情添加并绑定在该体检记录单下", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<String> addPhysicalExamRecord(@Valid @RequestBody AddPhysicalExamRecordCommand command, BindingResult bindingResult) {
        /* 判断是否绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("获取信息失败 | 参数异常");
        }
        /* 执行命令并返回 */
        return new ResponseResult<>(command.execute());
    }

    /**
     * 根据体检记录编号No获得旗下体检记录详情
     *
     * @return
     */
    @GetMapping("view/detail/list/{recordNo}")
    @ApiOperation(value = "根据[体检记录编号No]查询得其下所有[体检记录详情]", notes = "根据[体检记录编号No]查询得其下所有[体检记录详情]", produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "recordNo", value = "体检记录编号No", required = true, dataType = "String", paramType = "path")
    })
    public ResponseResult<List<PhysicalExamRecordDetailVo>> findPhysicalExamRecordDetailListByNo(@PathVariable("recordNo") String recordNo) {
        /* 实例化一个命令 */
        QueryPhysicalExamRecordDetailListByRecordNoCommand command = new QueryPhysicalExamRecordDetailListByRecordNoCommand(recordNo);
        /* 执行命令并返回 */
        return new ResponseResult<>(command.execute());
    }

}
