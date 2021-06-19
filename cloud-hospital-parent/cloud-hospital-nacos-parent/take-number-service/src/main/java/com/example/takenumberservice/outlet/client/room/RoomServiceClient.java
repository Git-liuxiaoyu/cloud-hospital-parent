package com.example.takenumberservice.outlet.client.room;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.register.pojo.Register;
import com.example.takenumberservice.outlet.client.room.pojo.OutRoomVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("worker-service")
public interface RoomServiceClient {

    //根据房间id查询房间名字
    @GetMapping("/room/out/view/{id}")
    ResponseResult<OutRoomVo> findbyid(@PathVariable("id") Integer id);

}
