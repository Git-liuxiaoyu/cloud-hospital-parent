package com.example.takenumberservice.util;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 用来给service构造注入bin的
 */
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


