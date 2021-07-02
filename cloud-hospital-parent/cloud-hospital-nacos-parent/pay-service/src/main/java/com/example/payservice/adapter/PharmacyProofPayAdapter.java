package com.example.payservice.adapter;

import com.example.payservice.adapter.converter.PharmacyProofPayConverter;
import com.example.payservice.outlet.cliten.pharmacy.PharmacyServiceClient;
import com.example.payservice.outlet.cliten.pharmacy.pojo.DrugOddVo;
import com.example.payservice.outlet.cliten.pharmacy.pojo.ExampleQueryDrugOddCommand;
import com.example.payservice.outlet.cliten.pharmacy.pojo.UpdateDrugOddCommand;
import com.example.payservice.outlet.dao.mysql.pharmacyproofdao.PharmacyProofDao;
import com.example.payservice.outlet.dao.mysql.pojo.PharmacyProofPayPo;
import com.example.payservice.service.command.pharmacyPay.addpharmacypay.AddPharmacyOrderCommand;
import com.example.payservice.service.command.pharmacyPay.refundpharmacypay.RefundPharmacyProofCommand;
import com.example.payservice.service.command.pharmacyPay.updatepharmacypay.UpdatePharmacyOrderCommand;
import com.example.payservice.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * 药房支付适配器
 */
@Repository
@Slf4j
@Component
public class PharmacyProofPayAdapter {

    @Autowired
    private PharmacyServiceClient pharmacyServiceClient;

    @Autowired
    private PharmacyProofDao pharmacyProofDao;

    @Autowired
    private PharmacyProofPayConverter pharmacyProofPayConverter;

    /**
     * 调用药房的药品单接口获得信息
     * @return
     */
    public DrugOddVo findByNo(String no){
//        ExampleQueryDrugOddCommand ex = new ExampleQueryDrugOddCommand();
//        ex.setNo(no);
//        ResponseResult<DrugOddVo> byNo = pharmacyServiceClient.findByNo(ex);//获得要拼单信息

        /*===============================测试=====================================*/
        DrugOddVo drugOddVo = new DrugOddVo();
        drugOddVo.setNo("YF0001");
        drugOddVo.setPatientid(1L);
        drugOddVo.setStatus("0");
        drugOddVo.setId(1L);
        drugOddVo.setTotalmoney(new BigDecimal(500));
        return drugOddVo;
        /*===============================测试=====================================*/
//        if(byNo.getCode() != 200){
//            return null;
//        }
//        return byNo.getData();
    }

    /**
     * 修改药品单表的状态为已付款
     */
    public void updateDrugStatus(UpdatePharmacyOrderCommand updatePharmacyOrderCommand){
        log.info("修改挂号表状态的id：{}",updatePharmacyOrderCommand.getStatus());
        //pharmacyServiceClient.updatestatus(updatePharmacyOrderCommand.getDrugoddId(),updatePharmacyOrderCommand.getStatus());
    }




    /**
     * 添加药房买药订单
     * @return
     */
    public int addPharmacyOrder(AddPharmacyOrderCommand addPharmacyOrderCommand){
        PharmacyProofPayPo cotopo = pharmacyProofPayConverter.cotopo(addPharmacyOrderCommand);
        System.out.println(cotopo);
        int i = pharmacyProofDao.addPharmacyProofOrder(cotopo);
        System.out.println("添加状态："+i);

        return i;
    }


    /**
     * 修改订单状态
     * @return
     */
    public ResponseResult<Void> updateCallProofStatus(UpdatePharmacyOrderCommand updatePharmacyOrderCommand){
        int i = pharmacyProofDao.updatePharmacyProofOrderStatus(pharmacyProofPayConverter.CommToUpdataPo(updatePharmacyOrderCommand));
        if(i>0){
            return new ResponseResult<>(200,"成功",null);
        }else{
            return new ResponseResult<>(500,"修改订单数据失败",null);
        }
    }

    /**
     * 查询订单是否存在
     * @return
     */
    public PharmacyProofPayPo findByDrugId(Long durgId){
        PharmacyProofPayPo bydrugId = pharmacyProofDao.findBydrugId(durgId);
        if(bydrugId == null){
            return null;//没有值
        }else{
            return bydrugId;//有值
        }
    }

    /**
     * 退款订单改为0
     * @return
     */
    public ResponseResult<Void> RefundOharmacy(RefundPharmacyProofCommand refundPharmacyProofCommand){
        int i = pharmacyProofDao.updatePharmacyProofOrderRefund(refundPharmacyProofCommand);
        if(i>0){
            return new ResponseResult<>(200,"退款成功",null);
        }else{
            return new ResponseResult<>(500,"退款失败",null);
        }
    }

    /**
     * 退款药品单
     * @return
     */
    public ResponseResult<Void>Refundoudg(RefundPharmacyProofCommand refundPharmacyProofCommand){

        UpdateDrugOddCommand updateDrugOddCommand = new UpdateDrugOddCommand();
        updateDrugOddCommand.setId(refundPharmacyProofCommand.getDrugoddId());
        updateDrugOddCommand.setStatus(refundPharmacyProofCommand.getStatus());
        ResponseResult<String> updatestatus = pharmacyServiceClient.updatestatus(updateDrugOddCommand);
        if(updatestatus.getCode() !=200){
            return new ResponseResult<>(200,"退款失败",null);
        }
        return new ResponseResult<>(200,"退款成功",null);
    }




}
