package com.example.payservice.outlet.dao.mysql.callproofdao;

import com.example.payservice.outlet.dao.mysql.pojo.CallProofPayPo;
import com.example.payservice.outlet.dao.mysql.pojo.UpdateCallProofPayPo;
import org.springframework.stereotype.Repository;

@Repository
public interface CallProofPayDao {

    /**
     * 添加
     */
    int addCallProofOrder(CallProofPayPo po);


    /**
     * 根据订单id修改订单状态为已付款
     * @param
     * @return
     */
    int updateCallProofOrderStatus(UpdateCallProofPayPo updateCallProofPayPo);



    /**
     * 查询订单是否存在
     * @param regId
     * @return
     */
    CallProofPayPo findByRegId(Long regId);

}
