package com.example.registerservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/08/17:12
 * @Description:
 */
@Configuration
@EnableRedisRepositories(basePackages = "com.example.registerservice.outlet.dao.redis")
public class RedisConfig {
}
