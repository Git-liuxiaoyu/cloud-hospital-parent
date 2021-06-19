package com.example.drugservice.service.add;

import com.example.drugservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class AddDrugOddCommand {
    private Integer doctorid;
    private Integer patientid;

    private IAddDrugOddCommandHandle handle;

    public AddDrugOddCommand(){
        this.handle = ApplicationContextHolder
                        .getApplicationContext()
                        .getBean(IAddDrugOddCommandHandle.class);
    }
    public AddDrugOddCommand(Integer doctorid,Integer patientid){
        this();
        this.doctorid=doctorid;
        this.patientid=patientid;
    }

    public void execute(){
        //药品表单id
        Long id = handle.AddDrugOdd(this);
    }


}
