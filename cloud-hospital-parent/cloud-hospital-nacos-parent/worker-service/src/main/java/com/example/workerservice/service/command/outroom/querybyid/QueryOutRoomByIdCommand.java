package com.example.workerservice.service.command.outroom.querybyid;

import com.example.workerservice.inlet.web.vo.OutRoomVo;
import com.example.workerservice.service.api.outroom.IQueryOutRoomByIdCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.Data;

/**
 * 实体类 - 命令 - QueryOutRoomByIdCommand
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Data
public class QueryOutRoomByIdCommand {

    private Long id;

    private IQueryOutRoomByIdCommandHandler queryOutRoomByIdCommandHandler;

    public QueryOutRoomByIdCommand() {
        this.queryOutRoomByIdCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(IQueryOutRoomByIdCommandHandler.class);
    }

    public QueryOutRoomByIdCommand(Long id) {
        this();
        this.id = id;
    }

    public OutRoomVo execute(){
        /* 执行方法 */
        return this.queryOutRoomByIdCommandHandler.action(this);
    }

}
