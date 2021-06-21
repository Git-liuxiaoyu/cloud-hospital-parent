package com.example.outpatientservice.service.query;

import com.example.outpatientservice.inlet.web.vo.OutPatientVo;

import java.util.List;

public interface IExampleQueryOutPatientCommandHandle {
    List<OutPatientVo> findByExample(ExampleQueryOutPatientCommand command);
}
