package com.example.outpatientservice.util;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder {

    private static ApplicationContext APPLICATION_CONTEXT;

    // 构造注入
    public ApplicationContextHolder(ApplicationContext context) {
        APPLICATION_CONTEXT = context;
    }

    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }

}


