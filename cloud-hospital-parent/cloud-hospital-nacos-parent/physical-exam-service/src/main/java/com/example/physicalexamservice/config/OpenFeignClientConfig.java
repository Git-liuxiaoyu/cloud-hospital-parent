package com.example.physicalexamservice.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.physicalexamservice.outlet.client")
public class
OpenFeignClientConfig {
}
