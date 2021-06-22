package com.example.workerservice.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * 如何向非 Spring 托管对象中【注入】托管对象。
 */
@Slf4j
@Data
public class DistributedLock {

    private final static long default_max_waiting_millis = 2 * 1000L;   // 默认尝试 2s 后超时
    private final static long default_try_interval_millis = 100L;       // 默认 100ms 尝试一次获得锁
    private final static long default_lock_expire_millis = 3 * 1000L;   // 单个业务持有锁的时间3秒

    /*　k-v 中的 key　*/
    private String name;
    /* k-v 中的 value */
    private String value;
    /* 过期时间 */
    private long lockExpireTime;
    /* 过期时间单位 */
    private TimeUnit timeUnit;

    private StringRedisTemplate redisTemplate;

    public DistributedLock(String name) {
        this(name, name, default_lock_expire_millis, TimeUnit.MILLISECONDS);
    }

    public DistributedLock(String name, String value) {
        this(name, value, default_lock_expire_millis, TimeUnit.MILLISECONDS);
    }

    public DistributedLock(String name, String value, long lockExpireTime, TimeUnit timeUnit) {
        this.name = name;
        this.value = value;
        this.lockExpireTime = lockExpireTime;
        this.timeUnit = timeUnit;
        this.redisTemplate = ApplicationContextHolder.getApplicationContext()
                .getBean(StringRedisTemplate.class);
    }

    public boolean lock() {
        return lock(default_max_waiting_millis, default_try_interval_millis);
    }

    public boolean lock(long maxWaitingMillis, long tryIntervalMillis) {
        try {
            // step 1: 参数校验，要求 setnx 命令要执行条件的 <键值对> 必须要有值。
            if (StringUtils.isEmpty(name) || StringUtils.isEmpty(value)) {
                throw new IllegalArgumentException("锁的 name 和 value 不能为空");
            }

            // step 2: 记录当前时间，在未来，用于判断【截止目前为止】有没有超出 maxWaitingMillis 这么久？
            long startTimeMillis = System.currentTimeMillis();

            // redisTemplate.opsForValue().setIfAbsent() 方法背后就是 Redis 的 setnx 命令。
            // 你调用这个方法，就是在执行 setnx 命令。
            ValueOperations<String, String> ops = redisTemplate.opsForValue();
            // 3, s ==> 3 秒； 3, m ==> 3 分钟； 3, h ==> 3 小时
            // set <lock.getName()> <lock.getValue> EX <lockExpireTime+timeUnit> NX
            while (!Boolean.TRUE.equals(ops.setIfAbsent(name, value, lockExpireTime, timeUnit))) {
                // 存在锁。setnx 失败就“进来”，执行下面代码
                log.debug("锁已存在！等待他人释放...");

                // 判断有没有到【放弃】的时间：maxWaitingMillis
                if (System.currentTimeMillis() - startTimeMillis > maxWaitingMillis) { // 尝试
                    log.debug("等待超时。无法获得分布式锁");
                    return false;
                }

                // 睡 tryIntervalMillis ：实现【每隔 tryIntervalMillis 起来试一次】的逻辑。
                log.debug("需要等待 {} 毫秒", tryIntervalMillis);
                Thread.sleep(tryIntervalMillis);
            }

            log.debug("成功获得分布式锁");
            return true;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            return false;
        }
    }

    public void unlock() {
        if (!StringUtils.isEmpty(name)) {
            redisTemplate.delete(name);
        }
    }
}