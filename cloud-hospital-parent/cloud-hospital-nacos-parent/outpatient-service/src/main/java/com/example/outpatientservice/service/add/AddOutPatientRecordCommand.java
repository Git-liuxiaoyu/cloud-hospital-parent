package com.example.outpatientservice.service.add;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class AddOutPatientRecordCommand {
    private Long outPatientId;

    private Integer checkNum;
    private Integer checkPro;
    private Integer departmentId ;

    private List<AddOutPatientRecordCommand> purPeoList;

    //患者状态改为就诊结束

    //使用openfen把检查单添加到检查表单

    //拿到检查表单回显id 添加到患者记录表里

}
