package com.example.payservice.outlet.dao.mysql;

import com.example.payservice.outlet.dao.mysql.pojo.CallProofPayPo;
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

}
