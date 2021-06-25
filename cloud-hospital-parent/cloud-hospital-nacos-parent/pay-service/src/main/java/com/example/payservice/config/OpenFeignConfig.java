package com.example.payservice.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.payservice.outlet.cliten")
public class OpenFeignConfig {
}
