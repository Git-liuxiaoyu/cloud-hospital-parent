package com.example.verificationcodeservice.util;


import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 工具类 - 获得 ApplicationContext 单例对象
 */
@Component
public class ApplicationContextHolder {

    private static ApplicationContext APPLICATION_CONTEXT;

    /**
     * 构造注入
     * @param applicationContext
     */
    public ApplicationContextHolder(ApplicationContext applicationContext) {
        APPLICATION_CONTEXT = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }


}
