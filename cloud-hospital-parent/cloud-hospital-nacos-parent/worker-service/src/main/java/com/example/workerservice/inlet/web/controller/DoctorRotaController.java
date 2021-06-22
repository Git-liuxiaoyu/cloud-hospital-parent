package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.DoctorRotaSetVo;
import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.command.doctorrota.add.AddDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.cancel.CancelDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.regquery.RegQueryDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.rotaquery.RotaQueryDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.update.UpdateDoctorRotaCommand;
import com.example.workerservice.util.HttpUtil;
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
    @PostMapping("reg")
    public ResponseResult<List<DoctorRotaVo>> regGetDoctorRotaList(@Valid @RequestBody RegQueryDoctorRotaCommand command, BindingResult bindingResult) {
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
    public ResponseResult<Long> addDoctorRota(@Valid @RequestBody AddDoctorRotaCommand command, BindingResult bindingResult, HttpServletRequest request) {
        /* 判断是否有绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("添加排班失败 | 参数异常");
        }

        /* LOG */
        log.info("添加医生排班信息 [{}]", command);

        /* 获得workerNo,并赋值 */
        command.setCreateWorkerNo(HttpUtil.getWorkerNoFromRequest(request, "BackLoginedToken"));

        /* 执行命令并返回(返回的为生成的主键ID) */
        return new ResponseResult<>(command.execute());
    }

    /**
     * 修改排班
     *
     * @param command
     * @param bindingResult
     * @return
     */
    @PostMapping("update")
    public ResponseResult<Void> updateDoctorRota(@Valid @RequestBody UpdateDoctorRotaCommand command, BindingResult bindingResult, HttpServletRequest request) {
        /* 判断是否有绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("添加排班失败 | 参数异常");
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
    public ResponseResult<List<DoctorRotaSetVo>> rotaGetDoctorRotaList(@Valid @RequestBody RotaQueryDoctorRotaCommand command, BindingResult bindingResult) {
        /* 判断是否有绑定错误 */
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("获取信息失败 | 参数异常");
        }
        /* 执行命令并返回 */
        return new ResponseResult<>(command.execute());
    }

}
