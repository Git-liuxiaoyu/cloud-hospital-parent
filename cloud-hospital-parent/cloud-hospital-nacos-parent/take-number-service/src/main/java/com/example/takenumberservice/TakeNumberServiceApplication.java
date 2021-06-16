package com.example.takenumberservice;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.takenumberservice.outlet.dao.mysql")
public class TakeNumberServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TakeNumberServiceApplication.class, args);
    }

}
