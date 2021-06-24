package com.example.physicalexamservice.util.converter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordDetailVo;
import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordDetailEsPo;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamRecordDetailRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To PhysicalExamRecordDetailVo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Component
@Slf4j
public class PhysicalExamRecordDetailVoConverter {

    /**
     * List<PhysicalExamRecordDetailEsPo> -> List<PhysicalExamRecordDetailVo>
     *
     * @param physicalExamRecordDetailEsPoList
     * @return
     */
    public List<PhysicalExamRecordDetailVo> convert(List<PhysicalExamRecordDetailEsPo> physicalExamRecordDetailEsPoList) {
        /* 实例化 */
        List<PhysicalExamRecordDetailVo> physicalExamRecordDetailVoList = new ArrayList<>();
        /* 循环转换 */
        physicalExamRecordDetailEsPoList.forEach(p -> physicalExamRecordDetailVoList.add(convert(p)));
        /* 返回 */
        return physicalExamRecordDetailVoList;
    }

    /**
     * PhysicalExamRecordDetailEsPo -> PhysicalExamRecordDetailVo
     *
     * @param physicalExamRecordDetailEsPo
     * @return
     */
    public PhysicalExamRecordDetailVo convert(PhysicalExamRecordDetailEsPo physicalExamRecordDetailEsPo) {
        /* 实例化 PhysicalExamRecordDetailVo */
        PhysicalExamRecordDetailVo physicalExamRecordDetailVo = new PhysicalExamRecordDetailVo();
        /* 判断是否为 null */
        if (physicalExamRecordDetailEsPo == null) {
            throw new NullPointerException();
        }
        /* 赋值 */
        BeanUtils.copyProperties(physicalExamRecordDetailEsPo, physicalExamRecordDetailVo);
        /* 返回 */
        return physicalExamRecordDetailVo;
    }

    /**
     * List<PhysicalExamRecordDetailRedisPo> -> List<PhysicalExamRecordDetailVo>
     *
     * @param physicalExamRecordDetailRedisPoList
     * @return
     */
    public List<PhysicalExamRecordDetailVo> convert(Iterable<PhysicalExamRecordDetailRedisPo> physicalExamRecordDetailRedisPoList) {
        /* 实例化 */
        List<PhysicalExamRecordDetailVo> physicalExamRecordDetailVoList = new ArrayList<>();
        /* 循环转换 */
        physicalExamRecordDetailRedisPoList.forEach(p -> physicalExamRecordDetailVoList.add(convert(p)));
        /* 返回 */
        return physicalExamRecordDetailVoList;
    }

    /**
     * PhysicalExamRecordDetailRedisPo -> PhysicalExamRecordDetailVo
     *
     * @param physicalExamRecordDetailRedisPo
     * @return
     */
    public PhysicalExamRecordDetailVo convert(PhysicalExamRecordDetailRedisPo physicalExamRecordDetailRedisPo) {
        /* 实例化 PhysicalExamRecordDetailVo */
        PhysicalExamRecordDetailVo physicalExamRecordDetailVo = new PhysicalExamRecordDetailVo();
        /* 判断是否为 null */
        if (physicalExamRecordDetailRedisPo == null) {
            throw new NullPointerException();
        }
        /* 赋值 */
        BeanUtils.copyProperties(physicalExamRecordDetailRedisPo, physicalExamRecordDetailVo);
        /* 返回 */
        return physicalExamRecordDetailVo;
    }

}
