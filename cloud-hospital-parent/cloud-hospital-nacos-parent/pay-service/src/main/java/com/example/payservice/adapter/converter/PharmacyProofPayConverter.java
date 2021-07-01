package com.example.payservice.adapter.converter;

import com.example.payservice.outlet.dao.mysql.pojo.PharmacyProofPayPo;
import com.example.payservice.outlet.dao.mysql.pojo.UpdatePharmacyProofPayPo;
import com.example.payservice.service.command.pharmacyPay.addpharmacypay.AddPharmacyOrderCommand;
import com.example.payservice.service.command.pharmacyPay.updatepharmacypay.UpdatePharmacyOrderCommand;
import org.springframework.stereotype.Component;

/**
 * 药房转换类
 */
@Component
public class PharmacyProofPayConverter {


    /**
     * 添加药房订单转换
     * @param addPharmacyOrderCommand
     * @return
     */
    public PharmacyProofPayPo cotopo(AddPharmacyOrderCommand addPharmacyOrderCommand){
        PharmacyProofPayPo po = new PharmacyProofPayPo();
        po.setNo(addPharmacyOrderCommand.getNo());
        po.setMoney(addPharmacyOrderCommand.getMoney());
        po.setOrderNum(addPharmacyOrderCommand.getOrderNum());
        po.setPatientId(addPharmacyOrderCommand.getPatientId());
        po.setTime(addPharmacyOrderCommand.getTime());
        po.setDrugoddId(addPharmacyOrderCommand.getDrugoddId());
        po.setStatus(addPharmacyOrderCommand.getStatus());
        return po;

    }


    public UpdatePharmacyProofPayPo CommToUpdataPo (UpdatePharmacyOrderCommand updatePharmacyOrderCommand){
        UpdatePharmacyProofPayPo po = new UpdatePharmacyProofPayPo();
        po.setOrderNum(updatePharmacyOrderCommand.getOrderNum());
        po.setStatus(updatePharmacyOrderCommand.getStatus());
        po.setDrugoddId(updatePharmacyOrderCommand.getDrugoddId());

        return po;
    }

}
