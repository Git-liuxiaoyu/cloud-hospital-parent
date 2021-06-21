package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.inlet.web.vo.WorkerInfoLoginedVo;
import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.command.workerinfo.querybyid.QueryWorkerByIdCommand;
import com.example.workerservice.service.command.workerinfo.querybyno.QueryWorkerByNoCommand;
import com.example.workerservice.service.command.workerinfo.queryloginedbyno.QueryLoginedUserWorkerInfoCommand;
import com.example.workerservice.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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


    /**
     * 后台登陆后,获得其信息
     *
     * @return
     */
    @GetMapping("view")
    public ResponseResult<WorkerInfoLoginedVo> getLoginedUsersWorkerInfo(HttpServletRequest request) {
        /* 获得工号 workerNo */
        String workerNo = HttpUtil.getWorkerNoFromRequest(request, "BackLoginedToken");
        /* LOG */
        log.info("工号 [{}] 正在使用管理系统", workerNo);
        /* 有参构造传送该工号信息,执行命令,返回返回值 */
        return new ResponseResult<>(new QueryLoginedUserWorkerInfoCommand(workerNo).execute());
    }


}
