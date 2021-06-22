package com.example.workerservice.service.command.outroom.querylistbydepartid;

import com.example.workerservice.adapter.OutRoomDaoAdapter;
import com.example.workerservice.inlet.web.vo.OutRoomVo;
import com.example.workerservice.service.api.outroom.IQueryOutRoomByDepartIdCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口实现类 - 实现 - IQueryOutRoomByDepartIdCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Component
@Slf4j
public class QueryOutRoomByDepartIdCommandHandler implements IQueryOutRoomByDepartIdCommandHandler {

    /* 构造注入 - 开始 */
    private final OutRoomDaoAdapter outRoomDaoAdapter;

    public QueryOutRoomByDepartIdCommandHandler(OutRoomDaoAdapter outRoomDaoAdapter) {
        this.outRoomDaoAdapter = outRoomDaoAdapter;
    }
    /* 构造注入 - 结束 */


    @Override
    public List<OutRoomVo> action(QueryOutRoomByDepartIdCommand command) {
        /* 执行方法 */
        return outRoomDaoAdapter.queryOutRoomListByDepartId(command.getDepartmentId(),OutRoomVo.STATUS_NORMAL);
    }
}
