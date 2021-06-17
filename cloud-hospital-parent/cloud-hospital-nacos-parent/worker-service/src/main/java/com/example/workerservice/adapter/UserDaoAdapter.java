package com.example.workerservice.adapter;

import com.example.workerservice.outlet.dao.mysql.UserPoDao;
import com.example.workerservice.outlet.dao.mysql.po.UserPo;
import com.example.workerservice.service.api.ILoginUserCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 适配器类 - User适配器
 */
@Component
@Slf4j
public class UserDaoAdapter {

    /* 构造注入 - 开始 */
    private final UserPoDao userPoDao;

    public UserDaoAdapter(UserPoDao userPoDao) {
        this.userPoDao = userPoDao;
    }
    /* 构造注入 - 结束 */

    /**
     * 登录方法
     * @param account
     * @param password
     * @return
     */
    public String login(String account, String password){
        /* 执行方法 */
        UserPo userPo = userPoDao.login(account, password).orElseThrow(ILoginUserCommandHandler.UserNotFountException::new);

        /* 返回返回值 */
        return userPo.getWorkerno();
    }

}
