package com.example.registerservice.outlet.client.worker;

import com.example.registerservice.outlet.client.po.DepartmentClientPo;
import com.example.registerservice.outlet.client.po.DivisionClientPo;
import com.example.registerservice.util.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/division/all")
    ResponseResult<List<DivisionClientPo>> findAll();

    @GetMapping("/depart/all/{divisionId}")
    ResponseResult<List<DepartmentClientPo>> getDepartmentListByDivisionId(@PathVariable("divisionId") Long id);
}
