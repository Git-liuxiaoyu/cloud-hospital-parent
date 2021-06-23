package com.example.takenumberservice.outlet.client.register;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.register.pojo.QueryGetByIdVo;
import com.example.takenumberservice.outlet.client.register.pojo.Register;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * 向挂号微服务发送请求，获得挂号no对应的数据
 */
@FeignClient("regtest")
public interface RegisterServiceClient {



    //接收挂号信息
    @GetMapping("Register/queryRegister/getByNo/{no}")
    ResponseResult<Register>findbyno(@PathVariable("no") String no);


    /**
     * 根据id修改状态
     * @param id
     * @param status
     */
    @PostMapping("/Register/update/status/{id}/{status}")
    void updatestatus(@PathVariable("id") Long id ,@PathVariable("status")String status);


    /**
     * 通过挂号Id查询挂号信息
     *
     * @return
     */
    @GetMapping("/Register/query/byId/{id}")
    ResponseResult<QueryGetByIdVo>findByRegId(@PathVariable("id") Long id);



}
