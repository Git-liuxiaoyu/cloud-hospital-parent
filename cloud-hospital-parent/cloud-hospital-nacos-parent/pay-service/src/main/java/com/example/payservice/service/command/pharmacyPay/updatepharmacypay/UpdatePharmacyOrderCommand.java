package com.example.payservice.service.command.pharmacyPay.updatepharmacypay;

import com.example.payservice.service.api.UpdateCallOrderCommandHandle;
import com.example.payservice.service.api.UpdatePharmacyOrderCommandHandle;
import com.example.payservice.util.ApplicationContextHolder;
import com.example.payservice.util.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
public class UpdatePharmacyOrderCommand {

    private String orderNum;//订单编号

    private String status;//订单状态（1：已付款、0未付款、2：已退款）

    private Long drugoddId;//药品单Id


    private UpdatePharmacyOrderCommandHandle handle;

    public UpdatePharmacyOrderCommand(){
        handle = ApplicationContextHolder
                .getApplicationContext()
                .getBean(UpdatePharmacyOrderCommandHandle.class);
    }

    public UpdatePharmacyOrderCommand(String orderNum, String status, Long drugoddId) {
        this();
        this.orderNum = orderNum;
        this.status = status;
        this.drugoddId = drugoddId;
    }


    /**
     * 修改订单状态命令
     * @return
     */
    public ResponseResult<Void> execute(){

        return handle.updatePharmacyProof(this);
    }

    /**
     * 调用药房接口修改状态
     * @return
     */
    public ResponseResult<Void>updateDrug(){

        return handle.updateDrugStatus(this);
    }

}
