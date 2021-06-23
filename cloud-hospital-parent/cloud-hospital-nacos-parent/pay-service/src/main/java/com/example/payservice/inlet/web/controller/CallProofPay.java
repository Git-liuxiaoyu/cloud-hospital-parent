package com.example.payservice.inlet.web.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
public class CallProofPay {
    private final String APP_ID = "2088621956003774";
    private final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC6Dx+C4CH1TJNp1BeU/q25IQNGHgA96N953pB58377m6yuII8gh9JLtZeLFF0TuDqNS0UMpZMG9YvIU6FiuroHhbmY7ZiT/hhvi6p6NTUrpQ2Yb6kP8gbBOI9VVpwSspqX+I0u4RBv8XP5DuCOHIwxRbzro2vAu3ufwigvHz6SOZp4cbUw3GmQyF8qH89CZtRJCp+pISh1H/qWPzt+deTtU5mIvh+hhEjLZcAM+0l8aFKyWNWwBpXY9HXWp+r7BdLoAV6uwLiwZzt2mwpOIxmXnheCKVm1M5JQAEBjlEozP7CXBPy25i4tYeTeTmX57ioqey3C0kOQWfPsiUt1xYwJAgMBAAECggEBAIUmFXLfWu3kown1Efs6VrBJg8JF7f5gDK12LQZYzuLYgTcLbeHl0QUFKzIInKNkD+LVntByHUm5pxLxZmj1H/QKKsvaHHqsOGh7FsDmGurk71nLbr1Ogq77/vcfSAnJbwCais6lmdHChTATCXgpzdnlAlHPXWlLwiiOFZvDTE/vWM/MlPjf5CFCWUpNpNkTgvLwezw3ek0rOm0FjhNfa0udE67DPIBXdclkcgRrWN1+uASC9pLohA/jyZgt9PehGGYRiPUIEVSHl/rG5Vu3cqHZdAlM/9issGqRuVKVgzZUXsbFBDhacTtsS9mF5WuevB4MId0Ir0db4xJTRfv4kkECgYEA27ZOQgNyu3Qtbaunzg8ZvDk/RFihfXghXgEsPKBA5SyyprDkqkssMzOOYwRp1Y6SZZt+H7kwBKBzOkUXTao+lmufLG1h7oN++gLSOVNpCebXRtFG8JICIy+JrQnAhV/cN8wp5iesmIEVT1BEQVOv3uzb0VpIMMRr8lFKgP828BUCgYEA2Mns7U6d/Pf/msRdPcCQKrzqsrBmN8pJ1LcihjXAgHIMFyGyZuK8IvNgs1ZaqkS8aocsIjSWuy7PvRB8kJ8bNV9mVASflElfkvHK9I3Weda+tGEkYsZU3Tz3X4QahaPQsyL/4iaxSkVpFMUSpGlvh8Jp5Ahp3fV2Qc6mm74+tSUCgYAjsadfFB5Uk9g5g/ScBloA+S/tE5UQxC5vjjM4mjRQxwUzDXPospO4sbyFG5dyCVqBRVSlJLnHVqXBpq3VgT3vxAY0+oQ5coVzanfqtkFPSYBZ0e/7b00HmFZ+lSIAyQUGz5VS/ckNcZMbsoeUMVtWFRbVGRy3R4Hd+RTohg3PzQKBgAccqL8oQxqXcDU9l+l8tb4RMInoK5JM+psV3vYUMVqFY0wm+NlTOuTSoyt++752PtAn2xTMMN23LW2AavW7ooLfvFWpSSruNUp20Dexp4Wbu+ni/fSXmRUg+OSTSuNzeldGIKrkphBPsqDRzkjChLwpbpvigsabVOPXybN2TExZAoGAJWQMaXaJ4S9EIVuPVUFGkNTSH3wdh3BApAnFuVpANf+5+1wR7zpfLAxQEOSkI9FZFXMFn5fckmSYmxXyFZO6mmiD3GcpAP27Lu1M1D/yJY61bXz7SalnwsBkM9gkCTsljOMudwDLyGZyRCl95qUxpkkWbmdsovc1uV4u8mOi1HQ=";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtU0G/j+TYfEQXS3Nqs5wy07xzjrb1v2a6BSoqVdbgUsCC2u7Q1pU+ig69n7XrUJ/qbsEovMMrwz+wNsQXnx6GPHXoqoD8aJyj+MNRt25tLLbvvppA5qkqCYTnohQuSAY2GpR9vy/vzQqUW3LVCF6lP7I6iIq4TACUG5Oo5YfOLqZosEmSZFRFlRgZ2xYitwMnbfLW2CqbFFE8Q4MuHKGnjPT3WqJ0YeR03ZonPMc+UBGAYyfB4Fb2TNAyfvF5dHN6S0vJA/8F8EiCZXsgigG9DkoF5CEgbUpx0vbGqdCNuXR3dqo9K3TBgCtYgea/EkHOx/A7eD3pYl7s//bm35aRQIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL ="https://openapi.alipay.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
//    private final String NOTIFY_URL = "http://127.0.0.1/notifyUrl";
//    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
//    private final String RETURN_URL = "http://127.0.0.1/returnUrl";
    private final String NOTIFY_URL = "http://baidu.com";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://jd.com";



    @GetMapping("alipay")
    public void alipay(HttpServletResponse httpResponse) throws IOException {

        Random r=new Random();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        //付款金额，必填
        String total_amount =Integer.toString(r.nextInt(9999999)+1000000);
        //订单名称，必填
        String subject ="挂号支付";
        //商品描述，可空
        String body = "尊敬的会员欢迎挂号";
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }


    @ResponseBody
    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);

            //支付成功，修复支付状态
            //payService.updateById(Integer.valueOf(out_trade_no));
            return "ok";//跳转付款成功页面
        }else{
            return "no";//跳转付款失败页面
        }

    }

}
