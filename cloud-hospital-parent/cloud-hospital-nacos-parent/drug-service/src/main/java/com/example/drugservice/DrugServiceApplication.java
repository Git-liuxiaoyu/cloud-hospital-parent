package com.example.drugservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.example.drugservice.outlet.dao.mysql")
public class DrugServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DrugServiceApplication.class, args);
    }

}
