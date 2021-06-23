package com.example.drugservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.drugservice.outlet.dao.mysql")
public class MybatisConfig {
}
