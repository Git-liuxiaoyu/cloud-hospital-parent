package com.example.payservice.inlet.web.controller.callproofpqy;


import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.payservice.service.command.CallProofPay.addcallorder.AddCallOrderCommand;
import com.example.payservice.service.command.CallProofPay.refundcallproof.RefundCallProofCommand;
import com.example.payservice.service.command.CallProofPay.updatecallorder.UpdateCallOrderCommand;
import com.example.payservice.util.PayUtil;
import com.example.payservice.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 挂号缴费接口
 */

@CrossOrigin
@Slf4j
@RequestMapping("/call/")
@Controller
//@RestController
public class CallProofPay {

    @Autowired
    private PayUtil payUtil;




    @ResponseBody
    @RequestMapping("pay/{regId}/{regType}")
    public void alipay(HttpServletResponse httpResponse, @PathVariable("regId") Long regId, @PathVariable("regType") String regType) throws IOException {

        log.info("接收到的挂号id:{}", regId);

        Random r = new Random();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(payUtil.getGATEWAY_URL(), payUtil.getAPP_ID(), payUtil.getAPP_PRIVATE_KEY(), payUtil.getFORMAT(), payUtil.getCHARSET(), payUtil.getALIPAY_PUBLIC_KEY(), payUtil.getSIGN_TYPE());
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        log.info("随机生成的订单号：{}", out_trade_no);
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl("http://localhost:6003/call/returnUrl/"+regId);
        request.setNotifyUrl("http://localhost:6003/call/returnUrl/"+regId);




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

        log.info("接收到的挂号类别:{}", subject);

        request.setBizContent(JSONObject.toJSONString(param));
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

        //定义时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();//当前系统时间
        String thistime = df.format(date);// thistime为当前时间
        //命令模式调用
        AddCallOrderCommand aco = new AddCallOrderCommand();
        aco.setRegId(regId);//挂号id
        aco.setType(regType);//挂号类型
        aco.setOrderNum(out_trade_no);//订单编号
        aco.setMoney(new BigDecimal(total_amount));//金额
        aco.setTime(thistime);
        aco.setStatus("2");
        log.info("controller:{}",aco.toString());
        ResponseResult<AddCallOrderCommand> execute = aco.execute();
        if(execute.getCode() !=200){
            log.info("存入数据库失败");
        }else{
            log.info("成功");
        }
    }

    /**
     * 支付失败调用函数
     * @return
     */
    @RequestMapping("lose")
    public String lose(){
        return "callProofNO";
    }



    @RequestMapping(value = "returnUrl/{regId}")
    public String returnUrl(@PathVariable("regId") Long regId,HttpServletRequest request, HttpServletResponse response)
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
        boolean signVerified = AlipaySignature.rsaCheckV1(params, payUtil.getALIPAY_PUBLIC_KEY(), payUtil.getCHARSET(), payUtil.getSIGN_TYPE()); // 调用SDK验证签名
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
            //支付成功，修改对应的订单状态
            //调用挂号微服务的openfeign修改挂号信息为
            UpdateCallOrderCommand update = new UpdateCallOrderCommand();
            update.setStatus("1");//已付款
            update.setOrderNum(out_trade_no);
            update.setRegId(regId);
            ResponseResult<Void> execute = update.execute();

            log.info("状态：{}",execute.getMsg());

            return "callProofOk";//跳转付款成功页面

        }else{
            return "callProofNo";//跳转付款失败页面

        }

    }

    /**
     * 挂号退款接口
     * @return
     */

    @RequestMapping("refund/{regId}")
    @ResponseBody
    public ResponseResult<Void> refund( @PathVariable("regId") Long regId){
        RefundCallProofCommand ref = new RefundCallProofCommand();

        ref.setRegId(regId);
        ref.setStatus("3");
        return ref.execute();
    }

}