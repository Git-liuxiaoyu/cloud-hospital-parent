package com.example.workerservice.util.converter;

import com.example.workerservice.outlet.dao.mysql.po.OutRoomPo;
import com.example.workerservice.outlet.dao.redis.po.OutRoomRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To OutRoomRedisPo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Component
@Slf4j
public class OutRoomRedisPoConverter {

    /**
     * List<OutRoomPo> -> List<OutRoomRedisPo>
     *
     * @param outRoomPoList
     * @return
     */
    public List<OutRoomRedisPo> convert(List<OutRoomPo> outRoomPoList) {
        /* 实例化 List<OutRoomRedisPo> */
        List<OutRoomRedisPo> outRoomRedisPoList = new ArrayList<>();
        /* 循环转换 */
        outRoomPoList.forEach(o -> outRoomRedisPoList.add(convert(o)));
        /* 返回 */
        return outRoomRedisPoList;
    }


    /**
     * OutRoomPo -> OutRoomRedisPo
     *
     * @param outRoomPo
     * @return
     */
    private OutRoomRedisPo convert(OutRoomPo outRoomPo) {
        /* 实例化 OutRoomRedisPo */
        OutRoomRedisPo outRoomRedisPo = new OutRoomRedisPo();
        /* 复制属性 */
        BeanUtils.copyProperties(outRoomPo, outRoomRedisPo);
        /* 返回 */
        return outRoomRedisPo;
    }


}
