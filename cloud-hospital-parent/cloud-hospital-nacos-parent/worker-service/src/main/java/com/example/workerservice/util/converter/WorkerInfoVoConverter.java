package com.example.workerservice.util.converter;

import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.outlet.dao.mysql.po.WorkerInfoPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To WorkerInfoVo
 */
@Component
@Slf4j
public class WorkerInfoVoConverter {

    /**
     * WorkerInfoPo -> WorkerInfoVo
     *
     * @param workerInfoPo
     * @return
     */
    public WorkerInfoVo convert(WorkerInfoPo workerInfoPo) {
        /* 实例化目标对象 */
        WorkerInfoVo workerInfoVo = new WorkerInfoVo();
        /* 赋值 */
        workerInfoVo.setId(workerInfoPo.getId());
        workerInfoVo.setPhone(workerInfoPo.getPhone());
        workerInfoVo.setName(workerInfoPo.getName());
        /* 返回 */
        return workerInfoVo;
    }

    /**
     * List<WorkerInfoPo> -> List<WorkerInfoVo>
     *
     * @param workerInfoPoList
     * @return
     */
    public List<WorkerInfoVo> convert(List<WorkerInfoPo> workerInfoPoList) {
        /* 实例化 List<WorkerInfoVo>  */
        List<WorkerInfoVo> workerInfoVoList = new ArrayList<>();
        /* 循环转换 */
        workerInfoPoList.forEach(o -> workerInfoVoList.add(convert(o)));
        /* 返回 */
        return workerInfoVoList;
    }
}
