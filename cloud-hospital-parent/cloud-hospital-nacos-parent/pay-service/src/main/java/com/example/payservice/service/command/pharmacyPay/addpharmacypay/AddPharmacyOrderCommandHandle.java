package com.example.payservice.service.command.pharmacyPay.addpharmacypay;

import com.example.payservice.adapter.PharmacyProofPayAdapter;
import com.example.payservice.outlet.cliten.pharmacy.pojo.DrugOddVo;
import com.example.payservice.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddPharmacyOrderCommandHandle implements com.example.payservice.service.api.AddPharmacyOrderCommandHandle {

    @Autowired
    private PharmacyProofPayAdapter pharmacyProofPayAdapter;

    /**
     * 添加进数据库
     * @param
     * @return
     */
    @Override
    public ResponseResult<AddPharmacyOrderCommand> execute(AddPharmacyOrderCommand addPharmacyOrderCommand) {
        //根据no查询药品单信息
        DrugOddVo byNo = pharmacyProofPayAdapter.findByNo(addPharmacyOrderCommand.getNo());

        if(byNo == null){
            return new ResponseResult<AddPharmacyOrderCommand>(400,"未成功",null);
        }
        if(byNo.getStatus() == "1"){
            return new ResponseResult<AddPharmacyOrderCommand>(400,"已付款，请勿重复操作",null);
        }

        //添加订单为未支付
        int i = pharmacyProofPayAdapter.addPharmacyOrder(addPharmacyOrderCommand);

        if(i>0){
            return new ResponseResult<AddPharmacyOrderCommand>(200,"添加成功",null);
        }else{
            return new ResponseResult<AddPharmacyOrderCommand>(400,"添加失败",null);
        }

    }


    /**
     * 通过no查询药品单信息
     * @param no
     * @return
     */
    @Override
    public AddPharmacyOrderCommand findByNo(String no) {
        //根据no查询药品单信息
        DrugOddVo byNo = pharmacyProofPayAdapter.findByNo(no);
        if(byNo == null){
            return null;
        }
        AddPharmacyOrderCommand addPharmacyOrderCommand = new AddPharmacyOrderCommand();
        //患者id
        addPharmacyOrderCommand.setPatientId(byNo.getPatientid());//患者id
        addPharmacyOrderCommand.setNo(byNo.getNo());//no
        addPharmacyOrderCommand.setMoney(byNo.getTotalmoney());//总金额
        addPharmacyOrderCommand.setDrugoddId(byNo.getId());
        return addPharmacyOrderCommand;
    }
}
