package com.example.outpatientservice.outlet.client.po.drug;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddDrugOddCommand {
    private Long outPatientId;
    private Integer doctorid;
    private Integer patientid;
    private Long outPatientRecordId;

    private List<AddDrugOddDetailCommand> detailCommands;

}
