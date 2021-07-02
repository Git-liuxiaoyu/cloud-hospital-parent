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
 * 转换器类 - Convert To PhysicalExamRecordDetailRedisPo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Component
@Slf4j
public class PhysicalExamRecordDetailRedisPoConverter {

    /**
     * List<PhysicalExamRecordDetailEsPo> -> List<PhysicalExamRecordDetailRedisPo>
     *
     * @param physicalExamRecordDetailEsPoList
     * @return
     */
    public List<PhysicalExamRecordDetailRedisPo> convert(
            List<PhysicalExamRecordDetailEsPo> physicalExamRecordDetailEsPoList) {
        /* 实例化 List<PhysicalExamRecordDetailRedisPo> */
        List<PhysicalExamRecordDetailRedisPo> physicalExamRecordDetailRedisPoList = new ArrayList<>();
        /* 循环转换 */
        physicalExamRecordDetailEsPoList.forEach(p -> physicalExamRecordDetailRedisPoList.add(convert(p)));
        /* 返回 */
        return physicalExamRecordDetailRedisPoList;
    }

    /**
     * physicalExamRecordDetailEsPo -> PhysicalExamRecordDetailRedisPo
     *
     * @param physicalExamRecordDetailEsPo
     * @return
     */
    public PhysicalExamRecordDetailRedisPo convert(PhysicalExamRecordDetailEsPo physicalExamRecordDetailEsPo) {
        /* 实例化 PhysicalExamRecordDetailRedisPo */
        PhysicalExamRecordDetailRedisPo physicalExamRecordDetailRedisPo = new PhysicalExamRecordDetailRedisPo();
        /* 判断是否为 null */
        if (physicalExamRecordDetailEsPo == null) {
            throw new NullPointerException();
        }
        /* 赋值属性 */
        BeanUtils.copyProperties(physicalExamRecordDetailEsPo, physicalExamRecordDetailRedisPo);
        /* 返回 */
        return physicalExamRecordDetailRedisPo;
    }


}
