package com.example.workerservice.service.command.outroom.querylistbydepartid;

import com.example.workerservice.inlet.web.vo.OutRoomVo;
import com.example.workerservice.service.api.outroom.IQueryOutRoomByDepartIdCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 实体类 - 命令 - QueryOutRoomByDepartIdCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Data
@Slf4j
public class QueryOutRoomByDepartIdCommand {

    private Integer departmentId;

    private IQueryOutRoomByDepartIdCommandHandler queryOutRoomByDepartIdCommandHandler;

    public QueryOutRoomByDepartIdCommand() {
        this.queryOutRoomByDepartIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryOutRoomByDepartIdCommandHandler.class);
    }

    public QueryOutRoomByDepartIdCommand(Integer departmentId) {
        this();
        this.departmentId = departmentId;
    }

    public List<OutRoomVo> execute() {
        return this.queryOutRoomByDepartIdCommandHandler.action(this);
    }
}
