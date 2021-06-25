package com.example.takenumberservice.outlet.client.drugodd;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.drugodd.util.ResponseResultD;
import com.example.takenumberservice.outlet.client.register.pojo.Register;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("drug-service")
public interface DrugoddClient {

    //接收挂号信息
    @PostMapping ("drugOdd/byNo/{no}")
    ResponseResultD<Void> findByYFNo(@PathVariable("no") String no);


}
