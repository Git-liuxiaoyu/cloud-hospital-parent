package com.example.physicalexamservice.util.converter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordEsPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 转换器类 - Convert To PhysicalExamRecordVo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/23
 */
@Component
@Slf4j
public class PhysicalExamRecordVoConverter {

    /**
     * PhysicalExamRecordEsPo -> PhysicalExamRecordVo
     *
     * @param physicalExamRecordEsPo
     * @return
     */
    public PhysicalExamRecordVo convert(PhysicalExamRecordEsPo physicalExamRecordEsPo) {
        /* 实例化 PhysicalExamRecordVo */
        PhysicalExamRecordVo physicalExamRecordVo = new PhysicalExamRecordVo();
        /* 判断是否为 null */
        if (physicalExamRecordEsPo == null) {
            return physicalExamRecordVo;
        }
        /* 赋值 */
        BeanUtils.copyProperties(physicalExamRecordEsPo, physicalExamRecordVo);
        /* 返回 */
        return physicalExamRecordVo;
    }

}
