package com.example.payservice.service.command.addcallorder;


import com.example.payservice.inlet.web.controller.vo.CallProofPayVo;
import com.example.payservice.service.api.AddCallOrderCommandHandle;
import com.example.payservice.util.ApplicationContextHolder;
import com.example.payservice.util.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 添加挂号支付订单
 */
@Data
@Slf4j
@AllArgsConstructor
public class AddCallOrderCommand {

    private Long id;
    private String no;//挂号no
    private String orderNum;//订单编号
    private BigDecimal money;//订单支付金额
    private String type;//挂号类别（1专家 、 2普通）
    private Long patientId;//患者id
    private String status;//订单状态（1：已付款、2未付款、3：已退款、4订单超时）

    private AddCallOrderCommandHandle handle;

    public AddCallOrderCommand(){
        handle = ApplicationContextHolder.getApplicationContext().getBean(AddCallOrderCommandHandle.class);
    }

    public AddCallOrderCommand(Long id, String no, String orderNum, BigDecimal money, String type, Long patientId, String status) {
        this();
        this.id = id;
        this.no = no;
        this.orderNum = orderNum;
        this.money = money;
        this.type = type;
        this.patientId = patientId;
        this.status = status;
    }

    /**
     * 执行命令
     * @return
     */
    public ResponseResult<AddCallOrderCommand>execute(){

        return handle.execute(this);
    }
}
