package com.example.outpatientservice.outlet.client;

import com.example.outpatientservice.util.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value = "employee-service")
//@Repository
//public interface PatientServiceClient {
//    @GetMapping("/employees/departments/{id}/fired")
//    public ResponseResult<Void> fireEmployeeInDepartment(@PathVariable("id") Integer departmentId);
//}
