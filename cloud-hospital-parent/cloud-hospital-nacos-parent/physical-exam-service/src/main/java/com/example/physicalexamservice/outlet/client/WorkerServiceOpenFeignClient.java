package com.example.physicalexamservice.outlet.client;

import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.example.physicalexamservice.outlet.client.vo.WorkerInfoVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
@FeignClient("worker-service")
public interface WorkerServiceOpenFeignClient {

    /**
     * 根据ID获取员工信息
     *
     * @param id
     * @return
     */
    @GetMapping("view/{id}")
    ResponseResult<WorkerInfoVo> getWorkerInfoById(@PathVariable("id") Integer id);

    /**
     * 根据工号no获取员工信息
     *
     * @param no
     * @return
     */
    @GetMapping("view/no/{no}")
     ResponseResult<WorkerInfoVo> getWorkerInfoByNo(@PathVariable("no") String no);

}
