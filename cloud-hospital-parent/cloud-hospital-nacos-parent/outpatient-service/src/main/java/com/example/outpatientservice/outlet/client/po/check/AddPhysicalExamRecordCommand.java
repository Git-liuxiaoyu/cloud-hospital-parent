package com.example.outpatientservice.outlet.client.po.check;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class AddPhysicalExamRecordCommand {

    private Long treatrecordid;

    private Integer doctorid;

    private Long patientid;

    private List<InnerAddPhysicalExamRecordDetailPo> innerAddPhysicalExamRecordDetailPoList;

}
