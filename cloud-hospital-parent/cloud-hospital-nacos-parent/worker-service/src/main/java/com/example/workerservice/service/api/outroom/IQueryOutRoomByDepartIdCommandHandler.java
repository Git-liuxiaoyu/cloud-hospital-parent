package com.example.workerservice.service.api.outroom;

import com.example.workerservice.inlet.web.vo.OutRoomVo;
import com.example.workerservice.service.command.outroom.querylistbydepartid.QueryOutRoomByDepartIdCommand;

import java.util.List;

/**
 * 接口 - QueryOutRoomByDepartIdCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
public interface IQueryOutRoomByDepartIdCommandHandler {

    List<OutRoomVo> action(QueryOutRoomByDepartIdCommand command);

}
