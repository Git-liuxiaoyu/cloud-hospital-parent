package com.example.outpatientservice.outlet.client;

import com.example.outpatientservice.outlet.client.po.patient.Patient;
import com.example.outpatientservice.outlet.client.po.worker.WorkerInfoVo;
import com.example.outpatientservice.util.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "register-service")
@Repository
public interface PatientInfoServiceClient {

    @GetMapping("Patient/query/byId/{id}")
    public ResponseResult<Patient> getByIdVoResponseResult(@PathVariable("id") Long id);
}
