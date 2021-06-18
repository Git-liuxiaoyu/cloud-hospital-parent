package com.example.registerservice.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.registerservice.outlet.client")
public class OpenFeignClientConfig {
}
