package com.example.workerservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.example.workerservice.outlet.dao.mysql")
public class MyBatisConfig {
}
