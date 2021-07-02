package com.example.physicalexamservice.inlet.web.controller;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordDetailVo;
import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.example.physicalexamservice.service.command.physicalexamreocrddetail.querybyid.QueryPhysicalExamRecordDetailByIdCommand;
import com.example.physicalexamservice.service.command.physicalexamreocrddetail.update.UpdatePhysicalExamRecordDetailCommand;
import com.example.physicalexamservice.util.HttpUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 控制器类 - 控制 - PhysicalExamRecordDetailController
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("physical/exam/record/detail")
public class PhysicalExamRecordDetailController {

    /**
     * 查看体检详情
     *
     * @return
     */
    @GetMapping("view/{id}")
    @ApiOperation(value = "根据体检详情主键ID查看体检详情", notes = "根据体检详情主键ID查看体检详情", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<PhysicalExamRecordDetailVo> getPhysicalExamRecordDetailById(@PathVariable("id") Long id) {
        /* 实例化一个命令 */
        QueryPhysicalExamRecordDetailByIdCommand command = new QueryPhysicalExamRecordDetailByIdCommand(id);

        /* 执行命令并返回 */
        return new ResponseResult<>(command.execute());
    }


    /**
     * 修改体检详情
     *
     * @return
     */
    @PostMapping("update")
    @ApiOperation(value = "根据体检详情主键ID修改体检详情", notes = "根据体检详情主键ID修改体检详情", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<Void> updatePhysicalExamRecordDetail(@Valid @RequestBody UpdatePhysicalExamRecordDetailCommand command, BindingResult bindingResult, HttpServletRequest request) {
        /* 判断是否绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("获取信息失败 | 参数异常");
        }

        /* 获得登录Token */
        String workerNoFromRequest = HttpUtil.getWorkerNoFromRequest(request,"BackLoginedToken");
        command.setWorkerNo(workerNoFromRequest);

        /* 执行命令 */
        command.execute();

        /* 执行命令并返回 */
        return ResponseResult.SUCCESS;
    }

}
