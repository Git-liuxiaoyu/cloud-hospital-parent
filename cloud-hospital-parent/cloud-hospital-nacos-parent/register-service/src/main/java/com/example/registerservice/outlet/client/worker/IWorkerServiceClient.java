package com.example.registerservice.outlet.client.worker;

import com.example.registerservice.outlet.client.po.DoctorRotaClientPo;
import com.example.registerservice.util.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/14:11
 * @Description: 调用门诊微服务的Client
 */
@FeignClient("worker-service")
public interface IWorkerServiceClient {
    /**
     * 根据rotaIdList查DoctorRota信息
     *
     * @param rotaIdList
     */
    @GetMapping("rota/doctor/view/list/reg/{idList}")
    public ResponseResult<List<DoctorRotaClientPo>> findDoctorRotaListByIdList(@PathVariable("idList") List<String> rotaIdList);
}
