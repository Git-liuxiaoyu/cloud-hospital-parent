package com.example.workerservice.util.converter;

import com.example.workerservice.inlet.web.vo.WorkerInfoLoginedVo;
import com.example.workerservice.outlet.dao.mysql.po.WorkerInfoPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 转换器类 - WorkerInfoLoginedVo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Component
@Slf4j
public class WorkerInfoLoginedVoConverter {

    /**
     * WorkerInfoPo -> WorkerInfoLoginedVo
     *
     * @param workerInfoPo
     * @return
     */
    public WorkerInfoLoginedVo convert(WorkerInfoPo workerInfoPo) {
        /* 实例化 WorkerInfoLoginedVo */
        WorkerInfoLoginedVo workerInfoLoginedVo = new WorkerInfoLoginedVo();
        /* 赋值 */
        workerInfoLoginedVo.setId(workerInfoPo.getId());
        workerInfoLoginedVo.setDepartmentId(workerInfoPo.getDepartmentPo().getId());
        workerInfoLoginedVo.setName(workerInfoPo.getName());
        workerInfoLoginedVo.setAvatar(workerInfoPo.getAvatar());
        workerInfoLoginedVo.setNo(workerInfoPo.getNo());
        workerInfoLoginedVo.setDepartmentName(workerInfoPo.getDepartmentPo().getName());
        workerInfoLoginedVo.setStatus(workerInfoPo.getStatus());
        workerInfoLoginedVo.setPositionType(workerInfoPo.getPositionPo().getType());
        workerInfoLoginedVo.setPositionLevel(workerInfoPo.getPositionPo().getLevel());
        workerInfoLoginedVo.setPositionStatus(workerInfoPo.getPositionPo().getStatus());
        workerInfoLoginedVo.setPositionIsOut(workerInfoPo.getPositionPo().getIsout());
        workerInfoLoginedVo.setPositionIsIn(workerInfoPo.getPositionPo().getIsin());
        workerInfoLoginedVo.setPositionIsMdc(workerInfoPo.getPositionPo().getIsmdc());
        /* 返回 */
        return workerInfoLoginedVo;
    }

}
