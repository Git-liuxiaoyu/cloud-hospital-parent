package com.example.payservice.inlet.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.payservice.util.PayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 挂号缴费接口
 */

@CrossOrigin
@Slf4j
@RequestMapping("/call/")
@RestController
public class CallProofPay {

    @Autowired
    private PayUtil payUtil;




    @RequestMapping("pay/{no}/{regType}")
    public void alipay(HttpServletResponse httpResponse, @PathVariable("no") String no, @PathVariable("regType") String regType) throws IOException {

        log.info("接收到的挂号no:{}", no);

        Random r = new Random();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(payUtil.getGATEWAY_URL(), payUtil.getAPP_ID(), payUtil.getAPP_PRIVATE_KEY(), payUtil.getFORMAT(), payUtil.getCHARSET(), payUtil.getALIPAY_PUBLIC_KEY(), payUtil.getSIGN_TYPE());
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(payUtil.getRETURN_URL());
        request.setNotifyUrl(payUtil.getNOTIFY_URL());


        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        log.info("随机生成的订单号：{}", out_trade_no);

        //付款金额
        String total_amount = Integer.toString(2);//普通号
        //订单名称
        String subject = "普通挂号付款";

        if (regType.equals("1")) {
            total_amount = Integer.toString(5);//专家号
            subject = "专家挂号付款";
        }


        //商品描述
        String body = "武汉第一人民医院挂号支付";

        //简化拼接字符串
        Map<String, String> param = new HashMap<String, String>();
        //商户订单号，商户网站订单系统中唯一订单号，必填
        param.put("out_trade_no", out_trade_no);
        //付款金额，必填
        param.put("total_amount", total_amount);
        //订单名称，必填
        param.put("subject", "挂号支付");

        //商品描述，可空
        param.put("body", body);
        param.put("product_code", "FAST_INSTANT_TRADE_PAY");
        //alipayRequest.setBizContent(JSONObject.toJSONString(param));





        log.info("接收到的挂号类别:{}", subject);



        request.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + payUtil.getCHARSET());
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        log.info("直接将完整的表单html输出到页面");

        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
        //

        log.info("执行存入数据库的操作");
    }



}