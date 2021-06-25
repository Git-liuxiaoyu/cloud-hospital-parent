package com.example.takenumberservice.outlet.client.doctor;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.doctor.pojo.DoctorRotaVo;
import com.example.takenumberservice.outlet.client.doctor.pojo.OutRoomVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 调用员工微服务
 */

@FeignClient("worker-service")
public interface WorkerServiceClient {

    //根据房间id查询房间名字
    @GetMapping("room/out/view/{id}")
    ResponseResult<OutRoomVo> findbyid(@PathVariable("id") Long id);




    /**
     * 根据rotaId查DoctorRota信息
     *
     * @param
     * @return
     */
    @GetMapping("rota/doctor/view/reg/{id}")
    public ResponseResult<DoctorRotaVo> getDoctorRotaById(@PathVariable("id") Long id);
}
