package com.example.outpatientservice.outlet.client;

import com.example.outpatientservice.outlet.client.po.check.AddPhysicalExamRecordCommand;
import com.example.outpatientservice.util.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "check-service")
@Repository
public interface CheckServiceClient {

    @PostMapping("/physical/exam/record/add")
    public ResponseResult<Long> addPhysicalExamRecord(@RequestBody AddPhysicalExamRecordCommand command) ;

}
