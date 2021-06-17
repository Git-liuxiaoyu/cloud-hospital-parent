package com.example.workerservice.util.converter;

import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.outlet.dao.mysql.po.WorkerInfoPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 转换器类 - Convert To WorkerInfoVo
 */
@Component
@Slf4j
public class WorkerInfoVoConverter {

    /**
     * WorkerInfoPo -> WorkerInfoVo
     * @param workerInfoPo
     * @return
     */
    public WorkerInfoVo convert(WorkerInfoPo workerInfoPo){
        /* 实例化目标对象 */
        WorkerInfoVo workerInfoVo = new WorkerInfoVo();
        /* 赋值 */
        workerInfoVo.setPhone(workerInfoPo.getPhone());
        /* 返回 */
        return workerInfoVo;
    }

}
