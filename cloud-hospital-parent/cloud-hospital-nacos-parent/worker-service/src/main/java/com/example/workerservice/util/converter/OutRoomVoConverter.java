package com.example.workerservice.util.converter;

import com.example.workerservice.inlet.web.vo.OutRoomVo;
import com.example.workerservice.outlet.dao.mysql.po.OutRoomPo;
import com.example.workerservice.outlet.dao.redis.po.OutRoomRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To OutRoomVo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Component
@Slf4j
public class OutRoomVoConverter {

    /**
     * OutRoomPo -> OutRoomVo
     *
     * @param outRoomPo
     * @return
     */
    public OutRoomVo convert(OutRoomPo outRoomPo) {
        /* 实例化 */
        OutRoomVo outRoomVo = new OutRoomVo();
        /* 复制属性 */
        BeanUtils.copyProperties(outRoomPo, outRoomVo);
        /* 返回 */
        return outRoomVo;
    }

    /**
     * List<OutRoomPo> -> List<OutRoomVo>
     *
     * @param outRoomPoList
     * @return
     */
    public List<OutRoomVo> convert(List<OutRoomPo> outRoomPoList) {
        /* 实例化 */
        List<OutRoomVo> outRoomVoList = new ArrayList<>();
        /* 循环转换 */
        outRoomPoList.forEach(o -> outRoomVoList.add(convert(o)));
        /* 返回 */
        return outRoomVoList;
    }

    /**
     * Iterable<OutRoomRedisPo> -> List<OutRoomVo>
     *
     * @param outRoomRedisPoList
     * @return
     */
    public List<OutRoomVo> convert(Iterable<OutRoomRedisPo> outRoomRedisPoList) {
        /* 实例化 */
        List<OutRoomVo> outRoomVoList = new ArrayList<>();
        /* 循环转换 */
        outRoomRedisPoList.forEach(o -> outRoomVoList.add(convert(o)));
        /* 返回 */
        return outRoomVoList;
    }

    /**
     * OutRoomRedisPo -> OutRoomVo
     *
     * @param outRoomRedisPo
     * @return
     */
    public OutRoomVo convert(OutRoomRedisPo outRoomRedisPo){
        /* 实例化 */
        OutRoomVo outRoomVo = new OutRoomVo();
        /* 复制属性 */
        BeanUtils.copyProperties(outRoomRedisPo, outRoomVo);
        /* 返回 */
        return outRoomVo;
    }

}
