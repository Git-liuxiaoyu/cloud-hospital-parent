package com.example.physicalexamservice.util.converter;

import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordEsPo;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamRecordRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 转换器类 - Convert To PhysicalExamRecordRedisPo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Component
@Slf4j
public class PhysicalExamRecordRedisPoConverter {

    public PhysicalExamRecordRedisPo convert(PhysicalExamRecordEsPo physicalExamRecordEsPo) {
        /* 实例化 PhysicalExamRecordRedisPo */
        PhysicalExamRecordRedisPo physicalExamRecordRedisPo = new PhysicalExamRecordRedisPo();
        /* 判断传值有无 */
        if (physicalExamRecordEsPo == null) {
            throw new NullPointerException();
        }
        /* 赋值 */
        BeanUtils.copyProperties(physicalExamRecordEsPo, physicalExamRecordRedisPo);
        /* 返回 */
        return physicalExamRecordRedisPo;
    }

}
