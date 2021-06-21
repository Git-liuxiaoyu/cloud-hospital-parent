package com.example.outpatientservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.outpatientservice.outlet.dao.mysql")
public class MybatisConfig {
}
