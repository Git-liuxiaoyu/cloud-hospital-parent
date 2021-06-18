package com.example.takenumberservice.outlet.client.room;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.register.pojo.Register;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("take-number-service")
public interface RoomServiceClient {

    //根据房间id查询房间名字
    @GetMapping("/room/findbyid/{id}")
    ResponseResult<String> findbyid(@PathVariable("id") Integer id);

}
