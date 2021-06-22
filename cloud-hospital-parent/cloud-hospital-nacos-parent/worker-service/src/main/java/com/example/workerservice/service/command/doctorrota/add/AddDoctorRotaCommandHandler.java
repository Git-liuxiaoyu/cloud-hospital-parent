package com.example.workerservice.service.command.doctorrota.add;

import com.example.workerservice.adapter.DoctorRotaDaoAdapter;
import com.example.workerservice.adapter.WorkerInfoDaoAdapter;
import com.example.workerservice.inlet.web.vo.DoctorRotaSetVo;
import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.inlet.web.vo.WorkerInfoVo;
import com.example.workerservice.service.api.doctorrota.IAddDoctorRotaCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 接口实现类 - 实现
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Component
@Slf4j
public class AddDoctorRotaCommandHandler implements IAddDoctorRotaCommandHandler {

    /* 构造注入 - 开始 */
    private final DoctorRotaDaoAdapter doctorRotaDaoAdapter;

    private final WorkerInfoDaoAdapter workerInfoDaoAdapter;

    public AddDoctorRotaCommandHandler(DoctorRotaDaoAdapter doctorRotaDaoAdapter, WorkerInfoDaoAdapter workerInfoDaoAdapter) {
        this.doctorRotaDaoAdapter = doctorRotaDaoAdapter;
        this.workerInfoDaoAdapter = workerInfoDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public Long action(AddDoctorRotaCommand command) {

        try {
            /* 判断想要排班的医生是否同时排班在别的诊室 */
            doctorRotaDaoAdapter.queryDoctorRotaToCheckIsDoctorInOtherRoomSameTimeAdd(command.getDoctorId(),command.getDate(), command.getShiftType(), command.getDepartmentId(), DoctorRotaSetVo.STATUS_NORMAL);
        } catch (IllegalArgumentException e) {
            /* 捕获异常 IllegalArgumentException , 转抛自定义异常 */
            throw new DoctorIsRotedInOtherRoomException();
        }

        /* 根据 createWorkerNo 查询所属 createDoctor */
        WorkerInfoVo workerInfoVo = workerInfoDaoAdapter.queryByWorkerNo(command.getCreateWorkerNo());

        /* 完善数据 */
        command.setCreateTime(new Date());
        command.setCreateId(workerInfoVo.getId());
        command.setStatus(DoctorRotaVo.STATUS_NORMAL);

        /* 执行添加方法 */
        Long id = doctorRotaDaoAdapter.addDoctorRota(command.getDepartmentId(), command.getDoctorId(), command.getDate(), command.getRotaType(), command.getShiftType(), command.getMaxPatient(), command.getRoomId(), command.getCreateId(), command.getCreateTime(), command.getStatus());

        /* 返回生成的主键(预留) */
        return id;
    }
}
