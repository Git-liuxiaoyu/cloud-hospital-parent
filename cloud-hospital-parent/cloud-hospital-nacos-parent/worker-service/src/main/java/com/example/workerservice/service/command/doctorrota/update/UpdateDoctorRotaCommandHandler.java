package com.example.workerservice.service.command.doctorrota.update;

import com.example.workerservice.adapter.DoctorRotaDaoAdapter;
import com.example.workerservice.adapter.WorkerInfoDaoAdapter;
import com.example.workerservice.inlet.web.vo.DoctorRotaSetVo;
import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.api.doctorrota.IUpdateDoctorRotaCommandHandler;
import com.example.workerservice.util.DistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * 接口实现类 - 实现 - IUpdateDoctorRotaCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Component
@Slf4j
public class UpdateDoctorRotaCommandHandler implements IUpdateDoctorRotaCommandHandler {

    /* 构造注入 - 开始 */
    private final DoctorRotaDaoAdapter doctorRotaDaoAdapter;

    private final WorkerInfoDaoAdapter workerInfoDaoAdapter;

    public UpdateDoctorRotaCommandHandler(DoctorRotaDaoAdapter doctorRotaDaoAdapter, WorkerInfoDaoAdapter workerInfoDaoAdapter) {
        this.doctorRotaDaoAdapter = doctorRotaDaoAdapter;
        this.workerInfoDaoAdapter = workerInfoDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public void action(UpdateDoctorRotaCommand command) {
        try {
            /* 判断想要排班的医生是否同时排班在别的诊室 */
            doctorRotaDaoAdapter.queryDoctorRotaToCheckIsDoctorInOtherRoomSameTimeUpdate(command.getDoctorId(), command.getDate(), command.getShiftType(), command.getDepartmentId(), DoctorRotaSetVo.STATUS_NORMAL);
        } catch (IllegalArgumentException e) {
            /* 捕获异常 IllegalArgumentException , 转抛自定义异常 */
            throw new DoctorIsRotedInOtherRoomException();
        }

        /* 根据 createWorkerNo 查询所属 createDoctor */
        WorkerInfoVo workerInfoVo = workerInfoDaoAdapter.queryByWorkerNo(command.getCreateWorkerNo());

        /* 获得分布式锁 */
        DistributedLock distributedLock = new DistributedLock("UPDATEROTA-" + command.getId(), UUID.randomUUID().toString());

        /* 锁上 */
        distributedLock.lock();

        /* 更新方法 */
        doctorRotaDaoAdapter.updateDoctorRota(command.getId(), command.getDepartmentId(), command.getDoctorId(), command.getDate(), command.getRotaType(), command.getShiftType(), command.getMaxPatient(), command.getRoomId(), workerInfoVo.getId(), new Date(), command.getStatus());

        /* 解锁 */
        distributedLock.unlock();
    }
}
