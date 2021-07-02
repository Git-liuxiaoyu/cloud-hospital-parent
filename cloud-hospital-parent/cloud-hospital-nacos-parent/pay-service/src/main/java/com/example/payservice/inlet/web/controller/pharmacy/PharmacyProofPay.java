package com.example.payservice.inlet.web.controller.pharmacy;


import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.payservice.service.command.CallProofPay.addcallorder.AddCallOrderCommand;
import com.example.payservice.service.command.CallProofPay.refundcallproof.RefundCallProofCommand;
import com.example.payservice.service.command.CallProofPay.updatecallorder.UpdateCallOrderCommand;
import com.example.payservice.service.command.pharmacyPay.addpharmacypay.AddPharmacyOrderCommand;
import com.example.payservice.service.command.pharmacyPay.refundpharmacypay.RefundPharmacyProofCommand;
import com.example.payservice.service.command.pharmacyPay.updatepharmacypay.UpdatePharmacyOrderCommand;
import com.example.payservice.util.PayUtil;
import com.example.payservice.util.ResponseResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@Slf4j
@RequestMapping("/pharmacy/")
@Controller
public class PharmacyProofPay {

    @Autowired
    private PayUtil payUtil;


    @ApiOperation(value = "药房买药的沙箱支付接口", notes = "根据no付款", produces = "application/json", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "no", value = "根据药房no查询支付金额，调用沙箱支付进行支付，并且存入订单表，状态修改为未支付，当回调函数触发代表支付成功，将状态修改为已支付", required = true, dataType = "String", paramType = "path")
    })
    @ApiOperationSupport(ignoreParameters = "handle")
    @ResponseBody
    @RequestMapping("pay/{no}")
    public void alipay(HttpServletResponse httpResponse, @PathVariable("no") String no) throws IOException {

        log.info("接收到的药房no:{}",no);
        //调用药房微服务获得信息
        AddPharmacyOrderCommand addPharmacyOrderCommand = new AddPharmacyOrderCommand();
        addPharmacyOrderCommand.setNo(no);
        AddPharmacyOrderCommand byNo = addPharmacyOrderCommand.findByNo();

        Random r = new Random();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(payUtil.getGATEWAY_URL(), payUtil.getAPP_ID(), payUtil.getAPP_PRIVATE_KEY(), payUtil.getFORMAT(), payUtil.getCHARSET(), payUtil.getALIPAY_PUBLIC_KEY(), payUtil.getSIGN_TYPE());
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        log.info("随机生成的订单号：{}", out_trade_no);
        Long drugoddId = byNo.getDrugoddId();//药品单id
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl("http://localhost:6003/pharmacy/returnUrl/"+drugoddId);
        request.setNotifyUrl("http://localhost:6003/pharmacy/returnUrl/"+drugoddId);


        //付款金额
        String total_amount = byNo.getMoney().toString();//普通号
        //订单名称
        String subject = "医院用药付款";
        //商品描述
        String body = "武汉第一人民医院用药";

        //简化拼接字符串
        Map<String, String> param = new HashMap<String, String>();
        //商户订单号，商户网站订单系统中唯一订单号，必填
        param.put("out_trade_no", out_trade_no);
        //付款金额，必填
        param.put("total_amount", total_amount);
        //订单名称，必填
        param.put("subject", subject);
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

        AddPharmacyOrderCommand apo = new AddPharmacyOrderCommand();
        apo.setMoney(byNo.getMoney());
        apo.setDrugoddId(byNo.getDrugoddId());
        apo.setNo(byNo.getNo());
        apo.setPatientId(byNo.getPatientId());
        apo.setTime(thistime);
        apo.setOrderNum(out_trade_no);
        apo.setStatus("0");
        ResponseResult<AddPharmacyOrderCommand> execute = apo.execute();
        if(execute.getCode() !=200){
            log.info("存入数据库失败");
            lose();
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



    @ApiOperation(value = "沙箱支付回调函数", notes = "回调支付的数据", produces = "application/json", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "no", value = "这个接口不能单独访问，是通过沙箱支付的回调自动访问的", required = true, dataType = "String", paramType = "path")
    })
    @ApiOperationSupport(ignoreParameters = "handle")
    @RequestMapping(value = "returnUrl/{drugoddId}")
    public String returnUrl(@PathVariable("drugoddId") Long drugoddId, HttpServletRequest request, HttpServletResponse response)
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
            UpdatePharmacyOrderCommand update = new UpdatePharmacyOrderCommand();
            update.setDrugoddId(drugoddId);
            update.setOrderNum(out_trade_no);
            update.setStatus("1");
            ResponseResult<Void> execute = update.execute();
            if(execute.getCode() != 200){
                log.info("{}",execute.getMsg());
            }else{
                //成功调用药房微服务接口修改药品单状态
                UpdatePharmacyOrderCommand updatedrug = new UpdatePharmacyOrderCommand();
                updatedrug.setStatus("1");
                updatedrug.setDrugoddId(drugoddId);
                ResponseResult<Void> voidResponseResult = update.updateDrug();
                log.info("状态：{}",voidResponseResult.getMsg());
            }
            log.info("状态：{}",execute.getMsg());
            return "PharmacyProofOk";//跳转付款成功页面
        }else{
            return "PharmacyProofNo";//跳转付款失败页面

        }

    }

    /**
     * 挂号退款接口
     * @return
     */

    @ApiOperation(value = "买药退款接口", notes = "根据药品单id退款", produces = "application/json", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "no", value = "根据药品单id判断订单是否存在并且状态为已付款，然后进行退款操作", required = true, dataType = "String", paramType = "path")
    })
    @ApiOperationSupport(ignoreParameters = "handle")
    @RequestMapping("refund/{drugoddId}")
    @ResponseBody
    public ResponseResult<Void> refund( @PathVariable("drugoddId") Long drugoddId){
        RefundPharmacyProofCommand ref = new RefundPharmacyProofCommand();
        ref.setStatus("0");
        ref.setDrugoddId(drugoddId);
        ResponseResult<Void> execute = ref.execute();

        RefundPharmacyProofCommand refdrug = new RefundPharmacyProofCommand();
        refdrug.setDrugoddId(drugoddId);
        refdrug.setStatus("0");
        ResponseResult<Void> voidResponseResult = refdrug.updateDrug();
        if(execute.getCode() !=200 ||voidResponseResult.getCode() != 200){
            return new ResponseResult<>(400,"退款失败",null);
        }else{
            return new ResponseResult<>(200,"退款成功",null);
        }

    }


}
