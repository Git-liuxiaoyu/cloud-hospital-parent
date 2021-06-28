package com.example.payservice.outlet.dao.mysql.callproofdao;


import com.example.payservice.outlet.dao.mysql.callproofdao.pojo.CallProofPayPo;
import com.example.payservice.outlet.dao.mysql.callproofdao.pojo.UpdateCallProofPayPo;
import org.springframework.stereotype.Repository;

/**
 * 挂号订单
 */
@Repository
public interface CallProofPayDao {

    /**
     * 添加
     */
    public int addCallProofOrder(CallProofPayPo po);


    /**
     * 根据订单id修改订单状态为已付款
     * @param
     * @return
     */
    public int updateCallProofOrderStatus(UpdateCallProofPayPo updateCallProofPayPo);


    /**
     * 查询订单是否存在
     * @param regId
     * @return
     */
    public CallProofPayPo findByRegId(Long regId);



}
