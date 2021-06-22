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
 * 转换器类 - Convert To PhysicalExamRedisPo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class PhysicalExamRedisPoConverter {

    /**
     * List<physicalExamMysqlPoList> -> List<PhysicalExamRedisPo>
     *
     * @param physicalExamMysqlPoList
     * @return
     */
    public List<PhysicalExamRedisPo> convert(List<PhysicalExamMysqlPo> physicalExamMysqlPoList
    ) {
        /* 实例化 */
        List<PhysicalExamRedisPo> physicalExamRedisPoList = new ArrayList<>();
        /* 循环转换 */
        physicalExamMysqlPoList.forEach(p -> physicalExamRedisPoList.add(convert(p)));
        /* 返回 */
        return physicalExamRedisPoList;
    }

    /**
     * PhysicalExamMysqlPo -> PhysicalExamRedisPo
     *
     * @param physicalExamMysqlPo
     * @return
     */
    private PhysicalExamRedisPo convert(PhysicalExamMysqlPo physicalExamMysqlPo) {
        /* 实例化 */
        PhysicalExamRedisPo physicalExamRedisPo = new PhysicalExamRedisPo();
        /* 复制属性 */
        BeanUtils.copyProperties(physicalExamMysqlPo, physicalExamRedisPo);
        /* 返回 */
        return physicalExamRedisPo;
    }

}
