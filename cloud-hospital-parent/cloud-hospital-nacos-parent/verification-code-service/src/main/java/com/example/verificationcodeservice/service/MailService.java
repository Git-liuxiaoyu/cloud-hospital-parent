package com.example.verificationcodeservice.service;

import com.example.verificationcodeservice.service.api.IMailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * 接口实现类 - 邮箱Service
 */
@Service
public class MailService implements IMailService {

    /* 构造注入 - 开始 */
    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    /* 构造注入 - 结束 */

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送简单邮箱
     * @param to 邮件发送给谁
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        /*  实例化一个SimpleMailMessage对象 */
        SimpleMailMessage message = new SimpleMailMessage();
        /* 设置信息 */
        message.setFrom(from); // 邮件发送者
        message.setTo(to); // 邮件接受者
        message.setSubject(subject); // 主题
        message.setText(content); // 内容
        /* 发送邮件 */
        mailSender.send(message);
    }
}
