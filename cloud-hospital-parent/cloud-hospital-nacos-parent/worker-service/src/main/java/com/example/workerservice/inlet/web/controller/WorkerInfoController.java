package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.inlet.web.vo.WorkerInfoLoginedVo;
import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.command.workerinfo.queryallbydepartid.QueryWorkerInfoListByDepartIdCommand;
import com.example.workerservice.service.command.workerinfo.querybyid.QueryWorkerByIdCommand;
import com.example.workerservice.service.command.workerinfo.querybyno.QueryWorkerByNoCommand;
import com.example.workerservice.service.command.workerinfo.queryloginedbyno.QueryLoginedUserWorkerInfoCommand;
import com.example.workerservice.util.HttpUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @ApiOperation(value = "通过员工主键ID获得员工信息", notes = "通过员工主键ID获得员工信息", produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "员工主键ID", required = true, dataType = "Integer", paramType = "path")
    })
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
    @ApiOperation(value = "通过员工工号获得员工信息", notes = "通过员工工号获得员工信息", produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "no", value = "员工工号", required = true, dataType = "String", paramType = "path")
    })
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
    @ApiOperation(value = "获得登录用户的员工信息", notes = "登录成功后,跳转到首页,根据登录后获得的Token,通过请求头获得Token,解析得到登录用户的工号,以得到其员工信息", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<WorkerInfoLoginedVo> getLoginedUsersWorkerInfo(HttpServletRequest request) {
        /* 获得工号 workerNo */
        String workerNo = HttpUtil.getWorkerNoFromRequest(request, "BackLoginedToken");
        /* LOG */
        log.info("工号 [{}] 正在使用管理系统", workerNo);
        /* 有参构造传送该工号信息,执行命令,返回返回值 */
        return new ResponseResult<>(new QueryLoginedUserWorkerInfoCommand(workerNo).execute());
    }


    /**
     * 后台登陆后,获得其信息
     *
     * @return
     */
    @GetMapping("view/all/department/{departmentId}")
    @ApiOperation(value = "通过科室ID获得该科室下所有员工信息", notes = "通过科室ID获得该科室下所有员工信息", produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departmentId", value = "科室主键ID", required = true, dataType = "Integer", paramType = "path")
    })
    public ResponseResult<List<WorkerInfoVo>> getAllDoctorInfoByDepartmentId(@PathVariable Integer departmentId) {
        /* 有参构造传送该工号信息,执行命令,返回返回值 */
        return new ResponseResult<>(new QueryWorkerInfoListByDepartIdCommand(departmentId).execute());
    }

}
