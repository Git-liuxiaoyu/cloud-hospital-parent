package com.example.takenumberservice.util;

import org.springframework.stereotype.Component;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Component
public class Email {
    public String staff(){
        try {
            final Properties props = new Properties();

            props.put("mail.user", "weiyixiEmail@163.com");//邮件发送方
            props.put("mail.password", "GHZCKFIPEJUIQIBQ"); //授权码
            props.put("mail.smtp.auth", "true");
            props.put("mail.transport.protocal", "smtp");
            props.put("mail.smtp.host", "smtp.163.com");
            props.put("mail.smtp.prot", "25");

            Session mailSession = Session.getDefaultInstance(props);

            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress("weiyixiEmail@163.com"));//发送方邮箱
            msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse("weiyixi13098351002@163.com"));//对方邮箱
            msg.setSubject("有消息发送失败"+"-"+"武汉第一人民医院");
            msg.setContent("<h2>此邮件为武汉第一人民医院错误消息邮件</h2><br>" +
                    "<h3>工作人员接收后请速度前往挂号取票微服务解决</h3>", "text/html;charset=UTF-8");

            msg.saveChanges();

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(props.getProperty("mail.smtp.host"), props.getProperty("mail.user"), props.getProperty("mail.password"));
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }

}
