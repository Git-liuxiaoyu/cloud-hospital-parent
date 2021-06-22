package com.example.takenumberservice.outlet.client.register;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.register.pojo.Register;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * 向挂号微服务发送请求，获得挂号no对应的数据
 */
@FeignClient("register-service")
public interface RegisterServiceClient {



    //接收挂号信息
    @GetMapping("Register/queryRegister/getByNo/{no}")
    ResponseResult<Register>findbyno(@PathVariable("no") String no);


    @GetMapping("/Register/update/status/{id}/{status}")
    void updatestatus(@PathVariable("id") Long id ,Integer status);



}
