package com.example.physicalexamservice.service.command.physicalexamreocrddetail.update;

import com.example.physicalexamservice.adapter.PhysicalExamRecordDaoAdapter;
import com.example.physicalexamservice.adapter.PhysicalExamRecordDetailDaoAdapter;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordDetailVo;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.example.physicalexamservice.outlet.client.WorkerServiceOpenFeignClient;
import com.example.physicalexamservice.outlet.client.vo.WorkerInfoVo;
import com.example.physicalexamservice.service.api.physicalexamrecorddetail.IUpdatePhysicalExamRecordDetailCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 接口实现类 - 实现 - IUpdatePhysicalExamRecordDetailCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
@Component
@Slf4j
@Transactional
public class UpdatePhysicalExamRecordDetailCommandHandler implements IUpdatePhysicalExamRecordDetailCommandHandler {

    /* 构造注入 - 开始 */
    private final PhysicalExamRecordDetailDaoAdapter physicalExamRecordDetailDaoAdapter;

    private final PhysicalExamRecordDaoAdapter physicalExamRecordDaoAdapter;

    private final WorkerServiceOpenFeignClient workerServiceOpenFeignClient;

    public UpdatePhysicalExamRecordDetailCommandHandler(PhysicalExamRecordDetailDaoAdapter physicalExamRecordDetailDaoAdapter, PhysicalExamRecordDaoAdapter physicalExamRecordDaoAdapter, WorkerServiceOpenFeignClient workerServiceOpenFeignClient) {
        this.physicalExamRecordDetailDaoAdapter = physicalExamRecordDetailDaoAdapter;
        this.physicalExamRecordDaoAdapter = physicalExamRecordDaoAdapter;
        this.workerServiceOpenFeignClient = workerServiceOpenFeignClient;
    }
    /* 构造注入 - 结束 */

    @Override
    public void action(UpdatePhysicalExamRecordDetailCommand command) {
        /* 先去看这个是否付款 */
        PhysicalExamRecordVo physicalExamRecordVo;
        try {
            physicalExamRecordVo = physicalExamRecordDaoAdapter.queryById(command.getRecordId());
        } catch (NullPointerException e) {
            /* LOG */
            log.debug("没有找到体检详情对应的体检单 -> id-{}", command.getRecordId());
            throw new NotFoundPhysicalExamRecordException();
        }

        if (physicalExamRecordVo.getStatus().equals(PhysicalExamRecordVo.STATUS_NOTPAY)) {
            throw new PhysicalExamRecordStateInvalidException("未支付无法体检");
        }

        if (physicalExamRecordVo.getStatus().equals(PhysicalExamRecordVo.STATUS_CLOSE)) {
            throw new PhysicalExamRecordStateInvalidException("体检单已关闭无法体检");
        }

        if (physicalExamRecordVo.getStatus().equals(PhysicalExamRecordVo.STATUS_FINISH)) {
            throw new PhysicalExamRecordStateInvalidException("体检单已完成无法体检");
        }

        /* 去查找是哪个医生 */
        ResponseResult<WorkerInfoVo> workerInfoByNo = workerServiceOpenFeignClient.getWorkerInfoByNo(command.getWorkerNo());

        if (workerInfoByNo.getCode() != 200) {
            throw new NotFoundWorkerInfoException();
        }
        /* 设置值 */
        command.setExamdocid(workerInfoByNo.getData().getId());

        /* 检测均通过则更新 */
        physicalExamRecordDetailDaoAdapter.update(command.getId(), command.getExamdocid(), command.getResulttext(), PhysicalExamRecordDetailVo.STATUS_EXAMED);


    }
}
