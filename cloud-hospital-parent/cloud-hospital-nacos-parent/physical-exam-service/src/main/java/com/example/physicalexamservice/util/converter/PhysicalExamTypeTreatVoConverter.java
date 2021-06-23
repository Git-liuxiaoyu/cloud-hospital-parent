package com.example.physicalexamservice.util.converter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTypeTreatVo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamTypeMysqlPo;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamTypeRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To PhysicalExamTypeTreatVo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class PhysicalExamTypeTreatVoConverter {

    /**
     * List<PhysicalExamTypeRedisPo> -> List<PhysicalExamTypeTreatVo>
     *
     * @param physicalExamTypeRedisPoList
     * @return
     */
    public List<PhysicalExamTypeTreatVo> convert(List<PhysicalExamTypeRedisPo> physicalExamTypeRedisPoList) {
        /* 实例化 List<PhysicalExamTypeTreatVo> */
        List<PhysicalExamTypeTreatVo> physicalExamTypeTreatVoList = new ArrayList<>();
        /* 循环转换 */
        physicalExamTypeRedisPoList.forEach(p -> physicalExamTypeTreatVoList.add(convert(p)));
        /* 返回 */
        return physicalExamTypeTreatVoList;
    }

    /**
     * PhysicalExamTypeRedisPo -> PhysicalExamTypeTreatVo
     *
     * @param physicalExamTypeRedisPo
     * @return
     */
    private PhysicalExamTypeTreatVo convert(PhysicalExamTypeRedisPo physicalExamTypeRedisPo) {
        /* 实例化 PhysicalExamTypeTreatVo */
        PhysicalExamTypeTreatVo physicalExamTypeTreatVo = new PhysicalExamTypeTreatVo();
        /* 复制属性 */
        BeanUtils.copyProperties(physicalExamTypeRedisPo, physicalExamTypeTreatVo);
        /* 返回 */
        return physicalExamTypeTreatVo;
    }


    /**
     * Iterable<PhysicalExamTypeMysqlPo> -> List<PhysicalExamTypeTreatVo>
     *
     * @param physicalExamTypeMysqlPos
     * @return
     */
    public List<PhysicalExamTypeTreatVo> convert(Iterable<PhysicalExamTypeMysqlPo> physicalExamTypeMysqlPos) {
        /* 实例化 List<PhysicalExamTypeTreatVo> */
        List<PhysicalExamTypeTreatVo> physicalExamTypeTreatVoList = new ArrayList<>();
        /* 循环转换 */
        physicalExamTypeMysqlPos.forEach(p -> physicalExamTypeTreatVoList.add(convert(p)));
        /* 返回 */
        return physicalExamTypeTreatVoList;
    }

    /**
     * PhysicalExamTypeMysqlPo -> PhysicalExamTypeTreatVo
     *
     * @param p
     * @return
     */
    private PhysicalExamTypeTreatVo convert(PhysicalExamTypeMysqlPo p) {
        /* 实例化 PhysicalExamTypeTreatVo */
        PhysicalExamTypeTreatVo physicalExamTypeTreatVo = new PhysicalExamTypeTreatVo();
        /* 复制属性 */
        BeanUtils.copyProperties(p, physicalExamTypeTreatVo);
        /* 返回 */
        return physicalExamTypeTreatVo;
    }
}
