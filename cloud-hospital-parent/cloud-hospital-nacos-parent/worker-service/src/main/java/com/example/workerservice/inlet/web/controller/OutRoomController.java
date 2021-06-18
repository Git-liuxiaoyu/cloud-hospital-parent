package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.OutRoomVo;
import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.command.outroom.querybyid.QueryOutRoomByIdCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 控制器类 - 控制 - OutRoom (门诊房间)
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@CrossOrigin
@RestController
@Slf4j
@RequestMapping("room/out")
public class OutRoomController {

    /**
     * 根据ID获取门诊房间
     * @param id
     * @return
     */
    @GetMapping("view/{id}")
    public ResponseResult<OutRoomVo> getOutRoomVoById(@PathVariable("id") Long id){
        /* 实例化,执行命令,返回 */
        return new ResponseResult<>(new QueryOutRoomByIdCommand(id).execute());
    }

}
