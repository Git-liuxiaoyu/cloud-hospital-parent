package com.example.workerservice.adapter;

import com.example.workerservice.outlet.dao.mysql.UserPoDao;
import com.example.workerservice.outlet.dao.mysql.po.UserPo;
import com.example.workerservice.outlet.dao.mysql.po.UserPoExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

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
        String correctVerifyCode = redisTemplate.boundValueOps("PWDUPDATE-" + phone).get();
        /* 判断该字符串是否为空 */
        if (StringUtils.isEmpty(correctVerifyCode)) {
            /* 假如为空,说明不存在该验证码 */
            throw new NullPointerException();
        }
        /* 不为空则判断两验证码是否一致,直接返回 */
        return correctVerifyCode.equals(verifyCode);
    }

    /**
     * 修改密码
     *
     * @param workerNo
     * @param password
     */
    public void updatePwd(String workerNo, String password) {
        /* 实例化UserPoExample */
        UserPoExample userPoExample = new UserPoExample();
        userPoExample.createCriteria().andWorkernoEqualTo(workerNo);
        /* 查询 */
        List<UserPo> userPoList = userPoDao.selectByExample(userPoExample);
        /* 判断是否唯一 */
        if (userPoList.size() != 1) {
            throw new NullPointerException();
        }
        /* 获得唯一对象 */
        UserPo userPo = userPoList.get(0);
        /* 修改密码 */
        userPo.setPassword(password);
        /* 调用 Update 方法 */
        userPoDao.updateByPrimaryKey(userPo);
        /* LOG */
        log.info("工号 [{}] 修改密码 [{}] 成功", workerNo, password);
    }

    /**
     * 存贮LoginToken到Redis
     *
     * @param ip
     * @param randomLoginToken
     */
    public void saveLoginToken(String ip, String randomLoginToken) {
        /* 存入Redis */
        redisTemplate.boundValueOps("LOGINTOKEN-" + ip).set(randomLoginToken);
    }

    /**
     * 核查该IP的LoginToken是否存在
     *
     * @param ip
     */
    public boolean checkIfLoginTokenExistedByIp(String ip, String loginToken) {
        System.out.println(ip + "=========" + loginToken);
        /* 是否存在该LoginToken */
        String redisLoginToken = redisTemplate.boundValueOps("LOGINTOKEN-" + ip).get();
        if (StringUtils.isEmpty(redisLoginToken) || StringUtils.isEmpty(loginToken)) {
            /* LOG */
            log.info("IP [{}] 无 loginToken 存在 Redis");
            return false;
        } else {
            /* Redis 存在 loginToken 再判断loginToken是否相等 */
            return redisLoginToken.equals(loginToken);
        }
    }

    /**
     * 根据IP删除LoginToken
     *
     * @param ip
     */
    public void deleteLoginTokenByIP(String ip) {
        /* Redis删除 */
        redisTemplate.delete("LOGINTOKEN-" + ip);
    }
}
