package com.example.workerservice.adapter;

import com.example.workerservice.inlet.web.vo.OutRoomVo;
import com.example.workerservice.outlet.dao.mysql.OutRoomPoDao;
import com.example.workerservice.outlet.dao.mysql.po.OutRoomPo;
import com.example.workerservice.util.converter.OutRoomVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 适配器类 - 适配 - OutRoom
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Component
@Slf4j
public class OutRoomDaoAdapter {

    /* 构造注入 - BEGIN */
    private final OutRoomPoDao outRoomPoDao;

    private final OutRoomVoConverter outRoomVoConverter;

    public OutRoomDaoAdapter(OutRoomPoDao outRoomPoDao, OutRoomVoConverter outRoomVoConverter) {
        this.outRoomPoDao = outRoomPoDao;
        this.outRoomVoConverter = outRoomVoConverter;
    }
    /* 构造注入 - END */

    /**
     * 根据ID获取OutRoom
     * @param id
     * @return
     */
    public OutRoomVo queryOutRoomById(Long id) {
        /* 调用方法查询 */
        OutRoomPo outRoomPo = outRoomPoDao.selectByPrimaryKey(id).orElseThrow(NullPointerException::new);
        /* 转换返回 */
        return outRoomVoConverter.convert(outRoomPo);
    }
}
