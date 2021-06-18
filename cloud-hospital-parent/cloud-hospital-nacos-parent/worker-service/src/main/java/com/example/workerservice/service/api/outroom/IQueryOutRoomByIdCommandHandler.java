package com.example.workerservice.service.api.outroom;

import com.example.workerservice.inlet.web.vo.OutRoomVo;
import com.example.workerservice.service.command.outroom.querybyid.QueryOutRoomByIdCommand;

/**
 * 接口 - IQueryOutRoomByIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
public interface IQueryOutRoomByIdCommandHandler {

    OutRoomVo action(QueryOutRoomByIdCommand command);

    /**
     * 自定义业务异常 - 门诊部房间未发现
     **/
    class OutRoomNotFoundException extends RuntimeException {
        public OutRoomNotFoundException() {
            super("门诊部房间未发现");
        }
    }


}
