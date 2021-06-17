package com.example.registerservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.example.registerservice.outlet.dao.mysql")
public class MyBatisConfig {
}
