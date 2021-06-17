package com.example.workerservice.adapter;

import com.example.workerservice.outlet.dao.mysql.UserPoDao;
import com.example.workerservice.outlet.dao.mysql.po.UserPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 适配器类 - User适配器
 */
@Component
@Slf4j
public class UserDaoAdapter {

    /* 构造注入 - 开始 */
    private final UserPoDao userPoDao;

    private final StringRedisTemplate redisTemplate;

    public UserDaoAdapter(UserPoDao userPoDao, StringRedisTemplate redisTemplate) {
        this.userPoDao = userPoDao;
        this.redisTemplate = redisTemplate;
    }
    /* 构造注入 - 结束 */

    /**
     * 登录方法
     *
     * @param account
     * @param password
     * @return
     */
    public String login(String account, String password) {
        /* 执行方法 */
        UserPo userPo = userPoDao.login(account, password).orElseThrow(NullPointerException::new);

        /* 返回返回值 */
        return userPo.getWorkerno();
    }


    /**
     * 检验随机验证码
     *
     * @param verifyCode 验证码
     * @param phone      手机号
     */
    public Boolean checkVerifyCode(String verifyCode, String phone) {
        /* 获得 k-v 对象 */
        String correctVerifyCode = redisTemplate.boundValueOps("PWDUPDATE:" + phone).get();
        /* 判断该字符串是否为空 */
        if (StringUtils.isEmpty(correctVerifyCode)) {
            /* 假如为空,说明不存在该验证码 */
            throw new NullPointerException();
        }
        /* 不为空则判断两验证码是否一致 */
        if (!correctVerifyCode.equals(verifyCode)) {
            /* 不相等则返回false */
            return false;
        }
        /* 正常则返回true */
        return true;
    }

}
