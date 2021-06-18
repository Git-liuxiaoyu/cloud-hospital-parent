package com.example.workerservice.util.converter;

import com.example.workerservice.outlet.dao.mysql.po.DivisionPo;
import com.example.workerservice.outlet.dao.redis.po.DivisionRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To DivisionRedisPo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/17
 */
@Component
@Slf4j
public class DivisionRedisPoConverter {

    /**
     * List<DivisionPo> -> List<DivisionRedisPo>
     *
     * @param divisionPoList
     * @return
     */
    public List<DivisionRedisPo> convert(List<DivisionPo> divisionPoList) {
        /* 实例化一个List<DivisionRedisPo> */
        List<DivisionRedisPo> divisionRedisPoList = new ArrayList<>();
        /* 转换 */
        divisionPoList.forEach(d -> divisionRedisPoList.add(convert(d)));
        /* 返回 */
        return divisionRedisPoList;
    }

    /**
     * DivisionPo -> DivisionRedisPo
     * @param divisionPo
     * @return
     */
    public DivisionRedisPo convert(DivisionPo divisionPo){
        /* 实例化一个 DivisionRedisPo */
        DivisionRedisPo divisionRedisPo = new DivisionRedisPo();
        /* 赋值 */
        divisionRedisPo.setId(divisionPo.getId());
        divisionRedisPo.setName(divisionPo.getName());
        divisionRedisPo.setStatus(divisionPo.getStatus());
        /* 返回 */
        return divisionRedisPo;
    }



}
