package com.example.payservice.outlet.cliten.register;

import com.example.payservice.outlet.cliten.register.pojo.QueryGetByIdVo;
import com.example.payservice.outlet.cliten.register.pojo.Register;
import com.example.payservice.util.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient("regtest")
public interface RegServiceClient {




    //接收挂号信息
    @GetMapping("Register/queryRegister/getByNo/{no}")
    ResponseResult<Register> findbyno(@PathVariable("no") String no);


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
