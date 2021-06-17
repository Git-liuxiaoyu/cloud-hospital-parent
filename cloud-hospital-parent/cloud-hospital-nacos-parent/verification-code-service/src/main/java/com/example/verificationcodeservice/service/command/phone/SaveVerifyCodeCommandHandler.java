package com.example.verificationcodeservice.service.command.phone;

import com.example.verificationcodeservice.service.api.ISaveVerifyCodeCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 ISaveVerifyCodeCommandHandler
 */
@Component
@Slf4j
public class SaveVerifyCodeCommandHandler implements ISaveVerifyCodeCommandHandler {

    /* 构造注入 - 开始 */
    private final StringRedisTemplate redisTemplate;

    public SaveVerifyCodeCommandHandler(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    /* 构造注入 - 结束 */

    @Override
    public void action(SaveVerifyCodeCommand command) {
        /* 存到 Redis */
        /* 记得最后要加过期时间 */
        redisTemplate.boundValueOps(command.getType() + "-" + command.getPhone()).set(command.getCode());
    }
}
