package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.command.workerinfo.querybyid.QueryWorkerByIdCommand;
import com.example.workerservice.service.command.workerinfo.querybyno.QueryWorkerByNoCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 转换器类 - WorkerInfo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("worker")
public class WorkerInfoController {

    /**
     * 根据ID获取员工信息
     *
     * @param id
     * @return
     */
    @GetMapping("view/{id}")
    public ResponseResult<WorkerInfoVo> getWorkerInfoById(@PathVariable("id") Integer id) {
        /* 实例化 QueryWorkerByIdCommand , 执行命令并返回 */
        return new ResponseResult<>(new QueryWorkerByIdCommand(id).execute());
    }

    /**
     * 根据工号no获取员工信息
     *
     * @param no
     * @return
     */
    @GetMapping("view/no/{no}")
    public ResponseResult<WorkerInfoVo> getWorkerInfoByNo(@PathVariable("no") String no) {
        /* 实例化 QueryWorkerByIdCommand , 执行命令并返回 */
        return new ResponseResult<>(new QueryWorkerByNoCommand(no).execute());
    }


}
