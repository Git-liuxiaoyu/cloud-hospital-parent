package com.example.takenumberservice.outlet.client.examine;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.outlet.client.examine.pojo.ExamineVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("verification-code-service")
public interface ExamineClient {


    /*==============================测试======================================*/
    //接收挂号信息
    @GetMapping("drugOdd/byNo/{no}")
    ResponseResult<ExamineVo> findByJCNo(@PathVariable("no") String no);

    /*==============================测试======================================*/
}
