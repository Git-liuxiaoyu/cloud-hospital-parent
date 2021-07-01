package com.example.payservice.service.command.pharmacyPay.updatepharmacypay;

import com.example.payservice.adapter.PharmacyProofPayAdapter;
import com.example.payservice.outlet.dao.mysql.pojo.PharmacyProofPayPo;
import com.example.payservice.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UpdatePharmacyOrderCommandHandle implements com.example.payservice.service.api.UpdatePharmacyOrderCommandHandle {

    @Autowired
    private PharmacyProofPayAdapter pharmacyProofPayAdapter;

    /**
     * 修改订单状态
     * @param updatePharmacyOrderCommand
     * @return
     */
    @Override
    public ResponseResult<Void> updatePharmacyProof(UpdatePharmacyOrderCommand updatePharmacyOrderCommand) {
        //查询数据库是否有该订单
        PharmacyProofPayPo byDrugId = pharmacyProofPayAdapter.findByDrugId(updatePharmacyOrderCommand.getDrugoddId());
        if(byDrugId == null){
            return new ResponseResult<>(400,"未查询到该订单",null);
        }
        return pharmacyProofPayAdapter.updateCallProofStatus(updatePharmacyOrderCommand);
    }


    /**
     * 修改药品单状态为已付款
     * @param updatePharmacyOrderCommand
     * @return
     */
    @Override
    public ResponseResult<Void> updateDrugStatus(UpdatePharmacyOrderCommand updatePharmacyOrderCommand) {
        //pharmacyProofPayAdapter.updateDrugStatus(updatePharmacyOrderCommand);
        return new ResponseResult<Void>(200,"成功",null);
    }
}
