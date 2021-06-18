package com.example.workerservice.service.command.outroom.querybyid;

import com.example.workerservice.adapter.OutRoomDaoAdapter;
import com.example.workerservice.inlet.web.vo.OutRoomVo;
import com.example.workerservice.service.api.outroom.IQueryOutRoomByIdCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 - IQueryOutRoomByIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Component
@Slf4j
public class QueryOutRoomByIdCommandHandler implements IQueryOutRoomByIdCommandHandler {

    /* 构造注入 -BEGIN */
    private final OutRoomDaoAdapter outRoomDaoAdapter;

    public QueryOutRoomByIdCommandHandler(OutRoomDaoAdapter outRoomDaoAdapter) {
        this.outRoomDaoAdapter = outRoomDaoAdapter;
    }
    /* 构造注入 - END  */

    @Override
    public OutRoomVo action(QueryOutRoomByIdCommand command) {
        try {
            /* 执行方法并返回 */
            return outRoomDaoAdapter.queryOutRoomById(command.getId());
        } catch (NullPointerException e) {
            /* 捕获到异常 NullPointerException , 抛异常 OutRoomNotFoundException */
            throw new OutRoomNotFoundException();
        }
    }
}
