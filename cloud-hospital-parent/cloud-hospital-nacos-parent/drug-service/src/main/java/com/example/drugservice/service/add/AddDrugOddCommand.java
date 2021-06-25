package com.example.drugservice.service.add;

import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class AddDrugOddCommand {
    private Long outPatientId;
    private Integer doctorid;
    private Integer patientid;
    private Long outPatientRecordId;

    private List<AddDrugOddDetailCommand> detailCommands;

    private IAddDrugOddCommandHandle handle;

    public AddDrugOddCommand(){
        this.handle = ApplicationContextHolder
                        .getApplicationContext()
                        .getBean(IAddDrugOddCommandHandle.class);
    }
    public AddDrugOddCommand(Long outPatientId,Integer doctorid,Integer patientid,List<AddDrugOddDetailCommand> detailCommands){
        this();
        this.patientid=patientid;
        this.doctorid=doctorid;
        this.patientid=patientid;
        this.detailCommands=detailCommands;
    }

    public Long execute(){
        //添加药品单  然后回显id  再添加药品详情
        //药品表单id
       Long drugOddId=  handle.AddDrugOdd(this);
       return drugOddId;
    }


}
