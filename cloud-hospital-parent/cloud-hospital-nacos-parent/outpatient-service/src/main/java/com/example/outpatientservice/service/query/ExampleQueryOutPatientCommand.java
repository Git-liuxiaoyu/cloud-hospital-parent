package com.example.outpatientservice.service.query;

import com.example.outpatientservice.inlet.web.vo.OutPatientVo;
import com.example.outpatientservice.outlet.client.DrugServiceClient;
import com.example.outpatientservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@Slf4j
@ToString
public class ExampleQueryOutPatientCommand {
    private String patientName;
    //根据患者id拿到患者信息
    private Long patientId;



    //分页参数
    private Integer pageIndex;
    private Integer pageSize;

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
    //查集合
    public List<OutPatientVo> execute(){
        List<OutPatientVo> voList = handle.findByExample(this);
        return voList;
    }

    //查对象
    public OutPatientVo getById(){
        return handle.getById(this.patientId);
    }

}
