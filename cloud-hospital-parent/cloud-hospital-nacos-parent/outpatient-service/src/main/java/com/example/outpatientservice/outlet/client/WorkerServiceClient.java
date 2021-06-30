package com.example.outpatientservice.outlet.client;

import com.example.outpatientservice.outlet.client.po.worker.WorkerInfoVo;
import com.example.outpatientservice.util.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "worker-service")
@Repository
public interface WorkerServiceClient {

    @GetMapping("/worker/view/{id}")
    public ResponseResult<WorkerInfoVo> getWorkerInfoById(@PathVariable("id") Integer id);
}
