package com.example.takenumberservice.outlet.client.doctor;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.doctor.pojo.DoctorVo;
import com.example.takenumberservice.outlet.client.register.pojo.Register;
import com.example.takenumberservice.outlet.client.room.pojo.OutRoomVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 调用员工微服务
 */

@FeignClient("worker-service-test")
public interface WorkerServiceClient {

    //根据房间id查询房间名字
    @GetMapping("/room/out/view/{id}")
    ResponseResult<DoctorVo> findByIdAndName(@PathVariable("id") Long id);


}
