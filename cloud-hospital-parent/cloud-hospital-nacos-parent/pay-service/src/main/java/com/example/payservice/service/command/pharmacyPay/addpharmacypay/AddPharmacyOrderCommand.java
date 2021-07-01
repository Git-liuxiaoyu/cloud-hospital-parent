package com.example.payservice.service.command.pharmacyPay.addpharmacypay;

import com.example.payservice.service.api.AddPharmacyOrderCommandHandle;
import com.example.payservice.service.command.CallProofPay.addcallorder.AddCallOrderCommand;
import com.example.payservice.util.ApplicationContextHolder;
import com.example.payservice.util.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Slf4j
public class AddPharmacyOrderCommand {

    private Long id;
    private Long drugoddId;//药品单Id
    private String orderNum;//订单编号
    private BigDecimal money;//金额
    private String no;//取药no
    private Long patientId;//患者id
    private String time;//交易时间
    private String status;//订单状态(0：未付款、1已付款)

    private AddPharmacyOrderCommandHandle handle;

    public AddPharmacyOrderCommand(){
        handle = ApplicationContextHolder
                .getApplicationContext()
                .getBean(AddPharmacyOrderCommandHandle.class);
    }


    public AddPharmacyOrderCommand(Long id, Long drugoddId, String orderNum, BigDecimal money, String no, Long patientId, String time, String status) {
        this();
        this.id = id;
        this.drugoddId = drugoddId;
        this.orderNum = orderNum;
        this.money = money;
        this.no = no;
        this.patientId = patientId;
        this.time = time;
        this.status = status;
    }

    /**
     * 执行命令添加
     * @return
     */
    public ResponseResult<AddPharmacyOrderCommand> execute(){

        return handle.execute(this);
    }

    /**
     * 执行命令查询
     * @return
     */
    public AddPharmacyOrderCommand findByNo(){
        return handle.findByNo(this.no);
    }
}
