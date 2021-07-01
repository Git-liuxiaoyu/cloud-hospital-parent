package com.example.payservice.outlet.dao.mysql.pharmacyproofdao;

import com.example.payservice.outlet.dao.mysql.pojo.PharmacyProofPayPo;
import com.example.payservice.outlet.dao.mysql.pojo.UpdatePharmacyProofPayPo;
import com.example.payservice.service.command.pharmacyPay.refundpharmacypay.RefundPharmacyProofCommand;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyProofDao {


    /**
     * 添加
     */
    int addPharmacyProofOrder(PharmacyProofPayPo po);



    /**
     * 根据订单id修改订单状态为已付款
     * @param
     * @return
     */
    int updatePharmacyProofOrderStatus(UpdatePharmacyProofPayPo po);

    /**
     * 根据订单id退款为未付款
     * @param
     * @return
     */
    int updatePharmacyProofOrderRefund(RefundPharmacyProofCommand refundPharmacyProofCommand);

    /**
     * 查询订单是否存在
     * @param drugId 药品单id
     * @return
     */
    PharmacyProofPayPo findBydrugId(Long drugId);

}
