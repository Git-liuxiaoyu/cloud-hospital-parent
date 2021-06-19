package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.command.doctorrota.RegQueryDoctorRotaCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

}
