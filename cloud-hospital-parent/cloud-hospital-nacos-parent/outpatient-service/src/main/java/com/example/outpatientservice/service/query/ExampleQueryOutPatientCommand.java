package com.example.outpatientservice.service.query;

import com.example.outpatientservice.inlet.web.vo.OutPatientVo;
import com.example.outpatientservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@AllArgsConstructor
@Slf4j
@ToString
public class ExampleQueryOutPatientCommand {
    private String patientName;

    private IExampleQueryOutPatientCommandHandle handle;

    public ExampleQueryOutPatientCommand(){
        this.handle= ApplicationContextHolder
                    .getApplicationContext()
                    .getBean(IExampleQueryOutPatientCommandHandle.class);
    }

    public ExampleQueryOutPatientCommand(String patientName){
        this();
        this.patientName=patientName;
    }

    public List<OutPatientVo> execute(){
        List<OutPatientVo> voList = handle.findByExample(this);
        return voList;
    }

}
