package com.example.physicalexamservice.util.converter;

import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordDetailEsPo;
import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To PhysicalExamRecordDetailEsPo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class PhysicalExamRecordDetailEsPoConverter {

    /**
     * @return
     */
    public List<PhysicalExamRecordDetailEsPo> convert(List<AddPhysicalExamRecordCommand.InnerAddPhysicalExamRecordDetailPo> innerAddPhysicalExamRecordDetailPoList, Long recordId) {
        /* 实例化 */
        List<PhysicalExamRecordDetailEsPo> physicalExamRecordDetailEsPoList = new ArrayList<>();
        /* 循环转换 */
        innerAddPhysicalExamRecordDetailPoList.forEach(i -> physicalExamRecordDetailEsPoList.add(convert(i, recordId)));
        /* 返回 */
        return physicalExamRecordDetailEsPoList;
    }

    /**
     * @param i
     * @return
     */
    private PhysicalExamRecordDetailEsPo convert(AddPhysicalExamRecordCommand.InnerAddPhysicalExamRecordDetailPo i, Long recordId) {
        /* 实例化 PhysicalExamRecordDetailEsPo */
        PhysicalExamRecordDetailEsPo physicalExamRecordDetailEsPo = new PhysicalExamRecordDetailEsPo();
        /* 赋值 */
        physicalExamRecordDetailEsPo.setExamid(i.getExamid());
        physicalExamRecordDetailEsPo.setExamName(i.getExamName());
        physicalExamRecordDetailEsPo.setRecordid(recordId);
        physicalExamRecordDetailEsPo.setCount(i.getCount());
        physicalExamRecordDetailEsPo.setTypeid(i.getTypeid());
        physicalExamRecordDetailEsPo.setTypeName(i.getTypeName());
        physicalExamRecordDetailEsPo.setId(i.getId());
        physicalExamRecordDetailEsPo.setPrice(i.getPrice());
        physicalExamRecordDetailEsPo.setStatus(i.getStatus());
        /* 返回 */
        return physicalExamRecordDetailEsPo;
    }
}
