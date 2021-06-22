package com.example.outpatientservice.config;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.outpatientservice.outlet.client")
public class SpringCloudConfig {
}

