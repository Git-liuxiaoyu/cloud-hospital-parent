package com.example.verificationcodeservice.inlet.subscriber;

import com.example.verificationcodeservice.service.command.phone.SaveVerifyCodeCommand;
import com.example.verificationcodeservice.util.CreateRandomUtil;
import com.example.verificationcodeservice.util.SendPhoneMsgUtil;
import com.github.qcloudsms.httpclient.HTTPException;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 订阅者类 - 验证码队列订阅
 */
@Slf4j
@Component
public class VerifyCodeSubscriber {

    /**
     * 订阅 phone_code
     *
     * @param message
     * @param channel
     */
    @RabbitListener(queues = "phone_code_queue")
    public void subscribePhoneVerifyCodeQueue(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {

        /* 获得消息主体并分割为数组 */
        String[] msgArr = new String(message.getBody()).split("-");
        /* 获取手机号 */
        String phone = msgArr[1];
        /* 获取一个随机验证码 */
        String code = CreateRandomUtil.createRandomVerifyCode(true, 6);

        try {
            /* 判断是否发送成功 */
            if (SendPhoneMsgUtil.sendSMS(phone, code)) {
                log.debug("发送短信到手机号 [{}] 成功", phone);
            } else {
                log.debug("发送短信到手机号 [{}] 失败 , 不重新进入队列", phone);
                /* 拒绝应答 */
//                channel.basicReject(tag, true);
            }
        } catch (HTTPException | IOException e) {
            log.error("发送短信功能出现错误");
            e.printStackTrace();
        }

        /* 存入到Redis */
        /* String type, String phone, String code */
        SaveVerifyCodeCommand command = new SaveVerifyCodeCommand(msgArr[0], phone, code);
        /* 执行命令 */
        command.execute();

        try {
            /* 确认应答 */
            channel.basicAck(tag, false);
        } catch (IOException e) {
            log.error("发送短信功能出现错误");
            e.printStackTrace();
        }
    }

}
