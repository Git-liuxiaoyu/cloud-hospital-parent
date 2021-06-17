package com.example.verificationcodeservice.service.api;

/**
 * 接口 - 邮箱服务
 */
public interface IMailService {


    /**
     * 发送简单邮箱
     *
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleMail(String to, String subject, String content);

}
