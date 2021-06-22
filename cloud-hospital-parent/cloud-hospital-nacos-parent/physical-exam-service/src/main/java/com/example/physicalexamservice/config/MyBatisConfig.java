package com.example.physicalexamservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.example.physicalexamservice.outlet.dao.mysql")
public class MyBatisConfig {
}
