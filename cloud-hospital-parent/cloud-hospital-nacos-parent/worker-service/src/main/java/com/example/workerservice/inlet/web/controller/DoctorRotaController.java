package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.DoctorRotaSetVo;
import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.command.doctorrota.add.AddDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.cancel.CancelDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.querybyid.QueryDoctorRotaByIdCommand;
import com.example.workerservice.service.command.doctorrota.querylistbyidlist.QueryDoctorRotaListByIdListCommand;
import com.example.workerservice.service.command.doctorrota.regquery.RegBackQueryDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.regquery.RegQueryDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.rotaquery.RotaQueryDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.update.UpdateDoctorRotaCommand;
import com.example.workerservice.util.HttpUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 控制器类 - 医生排班控制器
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@CrossOrigin
@Slf4j
@RequestMapping("rota/doctor")
@RestController
public class DoctorRotaController {

    /**
     * 挂号用查询
     *
     * @param command
     * @param bindingResult
     * @return
     */
    @PostMapping("reg/back")
    @ApiOperation(value = "后台挂号获得排班信息", notes = "通过[日期]、[科室ID]获得当前科室、当日下的所有排班信息以供挂号", produces = "application/json", response = ResponseResult.class)
    @ApiOperationSupport(ignoreParameters = {"regQueryDoctorRotaCommandHandler"})
    public ResponseResult<List<RegBackQueryDoctorRotaCommand.DoctorRotaVo>> backRegGetDoctorRotaList(@Valid @RequestBody RegBackQueryDoctorRotaCommand command, BindingResult bindingResult) {
        /* 判断是否有绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("获取信息失败 | 参数异常");
        }
        /* 执行命令并返回 */
        return new ResponseResult<>(command.execute());
    }


    /**
     * 挂号用查询
     *
     * @param command
     * @param bindingResult
     * @return
     */
    @PostMapping("reg")
    @ApiOperation(value = "前台前端挂号获得排班信息", notes = "通过[日期]、[科室ID]获得当前科室、当日下的所有排班信息以供挂号", produces = "application/json", response = ResponseResult.class)
    public ResponseResult<List<RegQueryDoctorRotaCommand.DoctorRotaVo>> regGetDoctorRotaList(@Valid @RequestBody RegQueryDoctorRotaCommand command, BindingResult bindingResult) {
        /* 判断是否有绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("获取信息失败 | 参数异常");
        }
        /* 执行命令并返回 */
        return new ResponseResult<>(command.execute());
    }

    /**
     * 添加排班
     *
     * @param rotaId
     * @return
     */
    @GetMapping("cancel/{rotaId}")
    @ApiOperation(value = "撤销医生排班", notes = "通过排班的主键ID,将该排班状态改为[撤销]", produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rotaId", value = "医生排班表主键ID", required = true, dataType = "Long", paramType = "path")
    })
    public ResponseResult<Void> cancelDoctorRota(@PathVariable("rotaId") Long rotaId) {
        /* LOG */
        log.info("取消的医生排班为 rotaId -> [{}]", rotaId);

        /* 实例化命令并执行 */
        new CancelDoctorRotaCommand(rotaId).execute();

        /* 执行命令并返回 */
        return ResponseResult.SUCCESS;
    }

    /**
     * 添加排班
     *
     * @param command
     * @param bindingResult
     * @return
     */
    @PostMapping("add")
    @ApiOperation(value = "添加医生排班", notes = "[选择的医生]、[选择的日期]、[选择排班在上午还是在下午]、[每班最大的看诊人数]、[科室ID]、[选择门诊部排班还是住院部排班]、[在哪个房间看诊]创建排班", produces = "application/json", response = ResponseResult.class)
    @ApiOperationSupport(ignoreParameters = {"addDoctorRotaCommandHandler", "id", "createWorkerNo", "createId", "createTime", "status"})
    public ResponseResult<Long> addDoctorRota(@Valid @RequestBody AddDoctorRotaCommand command, BindingResult bindingResult, HttpServletRequest request) {
        /* 判断是否有绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("添加排班失败 | 参数异常");
        }

        /* LOG */
        log.info("添加医生排班信息 [{}]", command);

        /* 获得workerNo,并赋值 */
        command.setCreateWorkerNo(HttpUtil.getWorkerNoFromRequest(request, "BackLoginedToken"));
        /* 执行命令 */
        Long execute = command.execute();
        log.debug("{}", execute);
        /* 执行命令并返回(返回的为生成的主键ID) */
        return new ResponseResult<>(execute);
    }

    /**
     * 修改排班
     *
     * @param command
     * @param bindingResult
     * @return
     */
    @PostMapping("update")
    @ApiOperation(value = "修改医生排班", notes = "通过[医生排班主键ID],找到对应的医生排班信息,修改其[排班医生]、[最大看诊人数]", produces = "application/json", response = ResponseResult.class)
    @ApiOperationSupport(ignoreParameters = {"updateDoctorRotaCommandHandler", "status", "createTime", "createId", "createWorkerNo"})
    public ResponseResult<Void> updateDoctorRota(@Valid @RequestBody UpdateDoctorRotaCommand command, BindingResult bindingResult, HttpServletRequest request) {
        /* 判断是否有绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("修改排班失败 | 参数异常");
        }
        /* LOG */
        log.info("更新医生排班信息 [{}]", command);
        /* 获得workerNo,并赋值 */
        command.setCreateWorkerNo(HttpUtil.getWorkerNoFromRequest(request, "BackLoginedToken"));
        /* 执行命令 */
        command.execute();
        /* 返回 */
        return ResponseResult.SUCCESS;
    }


    /**
     * 排班查询用于反显
     *
     * @param command
     * @param bindingResult
     * @return
     */
    @PostMapping("view/set/rota")
    @ApiOperation(value = "后台系统反显医生排班信息", notes = "通过[医生排班主键ID]集合,找到这些医生排班信息", produces = "application/json", response = ResponseResult.class)
    @ApiOperationSupport(ignoreParameters = {"rotaQueryDoctorRotaCommandHandler"})
    public ResponseResult<List<RotaQueryDoctorRotaCommand.DoctorRotaVo>> rotaGetDoctorRotaList(@Valid @RequestBody RotaQueryDoctorRotaCommand command, BindingResult bindingResult) {
        /* 判断是否有绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("获取信息失败 | 参数异常");
        }
        /* 执行命令并返回 */
        return new ResponseResult<>(command.execute());
    }

    /**
     * 根据rotaIdList查DoctorRota信息
     *
     * @param
     * @return
     */
    @GetMapping("view/list/reg/{idList}")
    @ApiOperation(value = "前台前端挂号系统查询历史挂号的排班信息", notes = "通过[医生排班主键ID]集合,找到这些医生排班信息", produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idList", value = "[医生排班主键ID]集合", required = true, dataType = "List<Long>", paramType = "path")
    })
    public ResponseResult<List<QueryDoctorRotaListByIdListCommand.DoctorRotaVo>> findDoctorRotaListByIdList(@PathVariable("idList") List<Long> idList) {
        /* 实例化命令实体类,执行命令并返回 */
        return new ResponseResult<>(new QueryDoctorRotaListByIdListCommand(idList).execute());
    }

    /**
     * 根据rotaId查DoctorRota信息
     *
     * @param
     * @return
     */
    @GetMapping("view/reg/{id}")
    @ApiOperation(value = "前台根据[医生排班主键ID]获得该排班的信息", notes = "通过[医生排班主键ID],获得该排班的信息", produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "医生排班主键ID", required = true, dataType = "Long", paramType = "path")
    })
    public ResponseResult<DoctorRotaVo> getDoctorRotaById(@PathVariable("id") Long id) {
        /* 实例化命令实体类,执行命令并返回 */
        return new ResponseResult<>(new QueryDoctorRotaByIdCommand(id).execute());
    }

}
