package com.example.workerservice.util.converter;

import com.example.workerservice.inlet.web.vo.OutRoomVo;
import com.example.workerservice.outlet.dao.mysql.po.OutRoomPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

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

}
