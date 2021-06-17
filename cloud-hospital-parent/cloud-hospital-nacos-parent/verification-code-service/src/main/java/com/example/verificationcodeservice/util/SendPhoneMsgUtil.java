package com.example.verificationcodeservice.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

import java.io.IOException;

/**
 * 工具类 - 发送手机消息
 */
public class SendPhoneMsgUtil {

    public static Boolean sendSMS(String phoneNumber,String code) throws HTTPException, IOException {
        Boolean reStr = false; //定义返回值
        // 短信应用SDK AppID   // 1400开头
        int appid = 1400521377;
        // 短信应用SDK AppKey
        String appkey = "11f67c2354f269e467344aeb54654acc";
        // 短信模板ID，需要在短信应用中申请
        int templateId = 971075;
        // 签名，使用的是`签名内容`，而不是`签名ID`
        String smsSign = "小雨的管理系统";
        //参数，一定要对应短信模板中的参数顺序和个数，

        String[] params = {code};

        //创建ssender对象
        SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
        //发送
        SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber, templateId, params, smsSign, "", "");
        // 签名参数未提供或者为空时，会使用默认签名发送短信
        System.out.println(result.toString());
        if (result.result == 0) {
            reStr = true;
        }
        return reStr;
    }

}
