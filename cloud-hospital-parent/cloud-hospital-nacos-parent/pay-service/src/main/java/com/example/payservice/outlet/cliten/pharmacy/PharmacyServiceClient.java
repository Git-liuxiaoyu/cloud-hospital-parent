package com.example.payservice.outlet.cliten.pharmacy;


import com.example.payservice.outlet.cliten.pharmacy.pojo.DrugOddVo;
import com.example.payservice.outlet.cliten.pharmacy.pojo.ExampleQueryDrugOddCommand;
import com.example.payservice.outlet.cliten.pharmacy.pojo.UpdateDrugOddCommand;
import com.example.payservice.util.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 药房接口调用
 */
@FeignClient("drug-service")
public interface PharmacyServiceClient {

    /**
     * 根据id修改状态
     * @param
     */
    @PostMapping("/drugodd/update/byId")
    ResponseResult<String> updatestatus(UpdateDrugOddCommand updateDrugOddCommand);


    /**
     * 通过药房no查询信息
     * @param
     * @return
     */
    @PostMapping("/drugodd/ByNo")
    public ResponseResult<DrugOddVo> findByNo(ExampleQueryDrugOddCommand command);


}
