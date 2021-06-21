package com.example.outpatientservice.service.query;

import com.example.outpatientservice.adapt.OutPatientAdapt;
import com.example.outpatientservice.inlet.web.vo.OutPatientVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ExampleQueryOutPatientCommandHandle implements IExampleQueryOutPatientCommandHandle{

    @Autowired
    private OutPatientAdapt adapt;

    @Override
    public List<OutPatientVo> findByExample(ExampleQueryOutPatientCommand command) {
        return adapt.findByExample(command);
    }
}
