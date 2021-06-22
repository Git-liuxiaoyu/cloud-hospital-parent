package com.example.physicalexamservice.util.converter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTreatVo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamMysqlPo;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To PhysicalExamTreatVo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class PhysicalExamTreatVoConverter {

    /**
     * List<PhysicalExamRedisPo> -> List<PhysicalExamTreatVo>
     *
     * @param physicalExamRedisPoList
     * @return
     */
    public List<PhysicalExamTreatVo> convert(Iterable<PhysicalExamRedisPo> physicalExamRedisPoList
    ) {
        /* 实例化 */
        List<PhysicalExamTreatVo> physicalExamTreatVoList = new ArrayList<>();
        /* 循环转换 */
        physicalExamRedisPoList.forEach(p -> physicalExamTreatVoList.add(convert(p)));
        /* 返回 */
        return physicalExamTreatVoList;
    }

    /**
     * PhysicalExamRedisPo -> PhysicalExamTreatVo
     *
     * @param physicalExamRedisPo
     * @return
     */
    private PhysicalExamTreatVo convert(PhysicalExamRedisPo physicalExamRedisPo) {
        /* 实例化 */
        PhysicalExamTreatVo physicalExamTreatVo = new PhysicalExamTreatVo();
        /* 复制属性 */
        BeanUtils.copyProperties(physicalExamRedisPo, physicalExamTreatVo);
        /* 返回 */
        return physicalExamTreatVo;
    }


    /**
     * List<physicalExamMysqlPoList> -> List<PhysicalExamTreatVo>
     *
     * @param physicalExamMysqlPoList
     * @return
     */
    public List<PhysicalExamTreatVo> convert(List<PhysicalExamMysqlPo> physicalExamMysqlPoList
    ) {
        /* 实例化 */
        List<PhysicalExamTreatVo> physicalExamTreatVoList = new ArrayList<>();
        /* 循环转换 */
        physicalExamMysqlPoList.forEach(p -> physicalExamTreatVoList.add(convert(p)));
        /* 返回 */
        return physicalExamTreatVoList;
    }

    /**
     * PhysicalExamMysqlPo -> PhysicalExamTreatVo
     *
     * @param physicalExamMysqlPo
     * @return
     */
    private PhysicalExamTreatVo convert(PhysicalExamMysqlPo physicalExamMysqlPo) {
        /* 实例化 */
        PhysicalExamTreatVo physicalExamTreatVo = new PhysicalExamTreatVo();
        /* 复制属性 */
        BeanUtils.copyProperties(physicalExamMysqlPo, physicalExamTreatVo);
        /* 返回 */
        return physicalExamTreatVo;
    }


}
