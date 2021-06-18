package com.example.workerservice.service.command.user.sendcode;

import com.example.workerservice.adapter.UserDaoAdapter;
import com.example.workerservice.adapter.WorkerInfoDaoAdapter;
import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.outlet.publisher.api.IUserMqEventPublisher;
import com.example.workerservice.service.api.user.ISendVerifyCodeCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 - SendVerifyCodeCommandHandler
 */
@Component
@Slf4j
public class SendVerifyCodeCommandHandler implements ISendVerifyCodeCommandHandler {

    /* 构造注入 - 开始 */
    private final UserDaoAdapter userDaoAdapter;

    private final WorkerInfoDaoAdapter workerInfoDaoAdapter;

    public SendVerifyCodeCommandHandler(UserDaoAdapter userDaoAdapter, WorkerInfoDaoAdapter workerInfoDaoAdapter) {
        this.userDaoAdapter = userDaoAdapter;
        this.workerInfoDaoAdapter = workerInfoDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public void action(SendVerifyCodeCommand command) {
        /* 通过workerNo获得phone */
        WorkerInfoVo workerInfoVo = workerInfoDaoAdapter.queryByWorkerNo(command.getWorkerNo());

        /* 推送 Event */
        ApplicationContextHolder.getApplicationContext().publishEvent(new IUserMqEventPublisher.SendVerifyCodeMqEvent(workerInfoVo.getPhone()));
    }
}
