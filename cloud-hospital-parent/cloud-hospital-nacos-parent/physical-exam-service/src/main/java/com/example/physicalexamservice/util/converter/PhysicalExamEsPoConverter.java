package com.example.physicalexamservice.util.converter;

import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamEsPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamMysqlPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 转换器类 - Convert To PhysicalExamEsPo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/1
 */
@Component
@Slf4j
public class PhysicalExamEsPoConverter {

    /**
     * PhysicalExamMysqlPo -> PhysicalExamEsPo
     *
     * @param physicalExamMysqlPo
     * @return
     */
    public PhysicalExamEsPo convert(PhysicalExamMysqlPo physicalExamMysqlPo) {
        /* 实例化 PhysicalExamEsPo */
        PhysicalExamEsPo physicalExamEsPo = new PhysicalExamEsPo();
        /* 复制属性 */
        BeanUtils.copyProperties(physicalExamMysqlPo, physicalExamEsPo);
        /* 返回 */
        return physicalExamEsPo;
    }

}
