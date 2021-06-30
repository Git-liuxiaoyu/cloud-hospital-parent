package com.example.workerservice.util.converter;

import com.example.workerservice.inlet.web.vo.DivisionVo;
import com.example.workerservice.outlet.dao.es.po.DivisionEsPo;
import com.example.workerservice.outlet.dao.mysql.po.DivisionPo;
import com.example.workerservice.outlet.dao.redis.po.DivisionRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To DivisionVo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/17
 */
@Component
@Slf4j
public class DivisionVoConverter {


    /**
     * DivisionPo -> DivisionVo
     *
     * @param divisionPo
     * @return
     */
    public DivisionVo convert(DivisionPo divisionPo) {
        /* 实例化一个DivisionVo */
        DivisionVo divisionVo = new DivisionVo();
        /* 赋值 */
        divisionVo.setId(divisionPo.getId());
        divisionVo.setName(divisionPo.getName());
        /* 返回 */
        return divisionVo;
    }

    /**
     * List<DivisionVo> -> List<DivisionRedisPo>
     *
     * @param divisionRedisPoList
     * @return
     */
    public List<DivisionVo> convert(Iterable<DivisionRedisPo> divisionRedisPoList) {
        /* 实例化一个DivisionVo */
        List<DivisionVo> divisionVoList = new ArrayList<>();
        /* 转换 */
        divisionRedisPoList.forEach(d -> divisionVoList.add(convert(d)));
        /* 返回值 */
        return divisionVoList;
    }

    /**
     * List<DivisionVo> -> List<DivisionPo>
     *
     * @param divisionPoList
     * @return
     */
    public List<DivisionVo> convert(List<DivisionPo> divisionPoList) {
        /* 实例化一个 List<DivisionVo> */
        List<DivisionVo> divisionVoList = new ArrayList<>();
        /* 转换 */
        divisionPoList.forEach(d -> divisionVoList.add(convert(d)));
        /* 返回 */
        return divisionVoList;
    }

    /**
     * DivisionRedisPo -> DivisionVo
     *
     * @param divisionRedisPo
     * @return
     */
    public DivisionVo convert(DivisionRedisPo divisionRedisPo) {
        /* 实例化DivisionVo */
        DivisionVo divisionVo = new DivisionVo();
        /* 赋值 */
        divisionVo.setId(divisionRedisPo.getId());
        divisionVo.setName(divisionRedisPo.getName());
        /* 返回 */
        return divisionVo;
    }

    /**
     * DivisionEsPo -> DivisionVo
     *
     * @param divisionEsPo
     * @return
     */
    public DivisionVo convert(DivisionEsPo divisionEsPo) {
        /* 实例化 DivisionVo */
        DivisionVo divisionVo = new DivisionVo();
        /* 赋值 */
        BeanUtils.copyProperties(divisionEsPo, divisionVo);
        /* 返回 */
        return divisionVo;
    }
}
