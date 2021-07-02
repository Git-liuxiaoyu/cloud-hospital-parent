package com.example.physicalexamservice.util.converter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordEsPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordMysqlPo;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamRecordRedisPo;
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
            throw new NullPointerException();
        }
        /* 赋值 */
        BeanUtils.copyProperties(physicalExamRecordEsPo, physicalExamRecordVo);
        /* 返回 */
        return physicalExamRecordVo;
    }

    /**
     * PhysicalExamRecordRedisPo -> PhysicalExamRecordVo
     *
     * @param physicalExamRecordRedisPo
     * @return
     */
    public PhysicalExamRecordVo convert(PhysicalExamRecordRedisPo physicalExamRecordRedisPo) {
        /* 实例化 PhysicalExamRecordVo */
        PhysicalExamRecordVo physicalExamRecordVo = new PhysicalExamRecordVo();
        /* 判断是否为 null */
        if (physicalExamRecordRedisPo == null) {
            throw new NullPointerException();
        }
        /* 赋值 */
        BeanUtils.copyProperties(physicalExamRecordRedisPo, physicalExamRecordVo);
        /* 返回 */
        return physicalExamRecordVo;
    }

    /**
     * PhysicalExamRecordMysqlPo -> PhysicalExamRecordVo
     *
     * @param physicalExamRecordMysqlPo
     * @return
     */
    public PhysicalExamRecordVo convert(PhysicalExamRecordMysqlPo physicalExamRecordMysqlPo) {
        /* 实例化 PhysicalExamRecordVo */
        PhysicalExamRecordVo physicalExamRecordVo = new PhysicalExamRecordVo();
        /* 判断是否为 null */
        if (physicalExamRecordMysqlPo == null) {
            throw new NullPointerException();
        }
        /* 赋值 */
        BeanUtils.copyProperties(physicalExamRecordMysqlPo, physicalExamRecordVo);
        /* 返回 */
        return physicalExamRecordVo;
    }
}
