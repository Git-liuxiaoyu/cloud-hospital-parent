package com.example.outpatientservice.outlet.client;

import com.example.outpatientservice.outlet.client.po.drug.AddDrugOddCommand;
import com.example.outpatientservice.util.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "drug-service")
@Repository
public interface DrugServiceClient {

    @RequestMapping(value = "/drugodd/add",method = RequestMethod.POST)
    public ResponseResult<Long> addDrugOdd(@RequestBody AddDrugOddCommand command);

}
