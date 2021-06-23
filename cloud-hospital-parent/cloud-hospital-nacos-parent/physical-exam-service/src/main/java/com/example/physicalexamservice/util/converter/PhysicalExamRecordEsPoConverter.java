package com.example.physicalexamservice.util.converter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordEsPo;
import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 转换器类 - Convert To PhysicalExamRecordEsPo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class PhysicalExamRecordEsPoConverter {

    /**
     * AddPhysicalExamRecordCommand -> PhysicalExamRecordEsPo
     *
     * @param command
     * @return
     */
    public PhysicalExamRecordEsPo convert(AddPhysicalExamRecordCommand command) {
        /* 实例化 PhysicalExamRecordEsPo */
        PhysicalExamRecordEsPo physicalExamRecordEsPo = new PhysicalExamRecordEsPo();
        /* 赋值 */
        physicalExamRecordEsPo.setCreatetime(command.getCreateTime());
        physicalExamRecordEsPo.setDoctorid(command.getDoctorid());
        physicalExamRecordEsPo.setNo(command.getNo());
        physicalExamRecordEsPo.setPatientid(command.getPatientid());
        physicalExamRecordEsPo.setStatus(PhysicalExamRecordVo.STATUS_NOTPAY);
        physicalExamRecordEsPo.setId(command.getId());
        physicalExamRecordEsPo.setTreatrecordid(command.getTreatrecordid());
        /* 返回 */
        return physicalExamRecordEsPo;
    }

}
