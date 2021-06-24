package com.example.physicalexamservice.util.converter;

import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamTypeMysqlPo;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamTypeRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To PhysicalExamTypeRedisPoConverter
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class PhysicalExamTypeRedisPoConverter {

    /**
     * List<PhysicalExamTypeMysqlPo> -> List<PhysicalExamTypeRedisPo>
     *
     * @param physicalExamTypeMysqlPoList
     * @return
     */
    public List<PhysicalExamTypeRedisPo> convert(List<PhysicalExamTypeMysqlPo> physicalExamTypeMysqlPoList) {
        /* 实例化 List<PhysicalExamTypeTreatVo> */
        List<PhysicalExamTypeRedisPo> physicalExamTypeRedisPoList = new ArrayList<>();
        /* 循环转换 */
        physicalExamTypeMysqlPoList.forEach(p -> physicalExamTypeRedisPoList.add(convert(p)));
        /* 返回 */
        return physicalExamTypeRedisPoList;
    }

    /**
     * PhysicalExamTypeMysqlPo -> PhysicalExamTypeRedisPo
     *
     * @param physicalExamTypeMysqlPo
     * @return
     */
    public PhysicalExamTypeRedisPo convert(PhysicalExamTypeMysqlPo physicalExamTypeMysqlPo) {
        /* 实例化 PhysicalExamTypeTreatVo */
        PhysicalExamTypeRedisPo physicalExamTypeRedisPo = new PhysicalExamTypeRedisPo();
        /* 复制属性 */
        BeanUtils.copyProperties(physicalExamTypeMysqlPo, physicalExamTypeRedisPo);
        /* 返回 */
        return physicalExamTypeRedisPo;
    }


}
