package com.example.workerservice.inlet.web.controller;

import com.example.workerservice.inlet.web.vo.OutRoomVo;
import com.example.workerservice.inlet.web.vo.ResponseResult;
import com.example.workerservice.service.command.outroom.querybyid.QueryOutRoomByIdCommand;
import com.example.workerservice.service.command.outroom.querylistbydepartid.QueryOutRoomByDepartIdCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@Api(value = "门诊房间 - 接口", description = "门诊房间 API")
public class OutRoomController {

    /**
     * 根据ID获取门诊房间
     * @param id
     * @return
     */
    @GetMapping("view/{id}")
    @ApiOperation(value = "通过[房间主键ID]获得房间信息", notes = "通过[房间主键ID]获得房间信息", produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "房间主键ID", required = true, dataType = "Long", paramType = "path")
    })
    public ResponseResult<OutRoomVo> getOutRoomVoById(@PathVariable("id") Long id){
        /* 实例化,执行命令,返回 */
        return new ResponseResult<>(new QueryOutRoomByIdCommand(id).execute());
    }

    /**
     * 根据科室ID获得全部该科室房间
     * @param departmentId 科室ID
     * @return
     */
    @GetMapping("view/all/{departmentId}")
    @ApiOperation(value = "通过[科室主键ID]获得其下所有房间(诊室)信息", notes = "通过[科室主键ID]获得其下所有房间(诊室)信息", produces = "application/json", response = ResponseResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departmentId", value = "科室主键ID", required = true, dataType = "Integer", paramType = "path")
    })
    public ResponseResult<List<OutRoomVo>> getOutRoomVoListByDepartmentId(@PathVariable("departmentId") Integer departmentId){
        log.debug("{}",departmentId);
        /* 实例化,执行命令,返回 */
        return new ResponseResult<>(new QueryOutRoomByDepartIdCommand(departmentId).execute());
    }


}
