package com.example.takenumberservice.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.takenumberservice.outlet.client")
public class OpenFeignConfig {
}
