package com.example.takenumberservice;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling//开启定时任务
@SpringBootApplication
@MapperScan(basePackages = "com.example.takenumberservice.outlet.dao.mysql")//包扫描
public class TakeNumberServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TakeNumberServiceApplication.class, args);
    }

}
