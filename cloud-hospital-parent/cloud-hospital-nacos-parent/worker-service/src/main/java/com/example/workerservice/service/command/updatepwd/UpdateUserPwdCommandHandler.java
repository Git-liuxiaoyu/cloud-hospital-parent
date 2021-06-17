package com.example.workerservice.service.command.updatepwd;

import com.example.workerservice.adapter.UserDaoAdapter;
import com.example.workerservice.adapter.WorkerInfoDaoAdapter;
import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.api.IUpdateUserPwdCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 接口实现类 - 实现接口 - IUpdateUserPwdCommandHandler
 */
@Transactional
@Component
@Slf4j
public class UpdateUserPwdCommandHandler implements IUpdateUserPwdCommandHandler {

    /* 构造注入 - 开始 */
    private final UserDaoAdapter userDaoAdapter;

    private final WorkerInfoDaoAdapter workerInfoDaoAdapter;

    public UpdateUserPwdCommandHandler(UserDaoAdapter userDaoAdapter, WorkerInfoDaoAdapter workerInfoDaoAdapter) {
        this.userDaoAdapter = userDaoAdapter;
        this.workerInfoDaoAdapter = workerInfoDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public void action(UpdateUserPwdCommand command) {
        /* 获得工号 */
        String workerNo = command.getWorkerNo();
        /* 通过工号获得手机号 */
        WorkerInfoVo workerInfoVo = workerInfoDaoAdapter.queryByWorkerNo(workerNo);
        /* 获得手机号 */
        String phone = workerInfoVo.getPhone();
        /* 去userDaoAdapter查是否有该数据 */
        Boolean flag = null;
        try {
            flag = userDaoAdapter.checkVerifyCode(command.getVerifyCode(), phone);
        } catch (NullPointerException e) {
            /* 捕获到 NullPointerException 则抛异常 InvalidVerifyCodeException */
            throw new InvalidVerifyCodeException();
        }
        /* 判断flag */
        if (!flag) {
            /* 如果返回false,则抛异常 IncorrectVerifyCodeException 、如果返回true,则什么都不做 */
            throw new IncorrectVerifyCodeException();
        }
        try {
            /* 一切正常修改密码 */
            userDaoAdapter.updatePwd(workerNo, command.getPassword());
        } catch (NullPointerException e) {
            /* 捕获到 NullPointerException 则抛异常 UserNo */
            throw new UserNotFoundException();
        }
    }
}
