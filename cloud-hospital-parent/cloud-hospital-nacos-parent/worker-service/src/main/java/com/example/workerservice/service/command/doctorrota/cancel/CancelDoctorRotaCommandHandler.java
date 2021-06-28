package com.example.workerservice.service.command.doctorrota.cancel;

import com.example.workerservice.adapter.DoctorRotaDaoAdapter;
import com.example.workerservice.inlet.web.vo.DoctorRotaSetVo;
import com.example.workerservice.service.api.doctorrota.ICancelDoctorRotaCommandHandler;
import com.example.workerservice.util.DistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 接口实现类 - 实现 - ICancelDoctorRotaCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class CancelDoctorRotaCommandHandler implements ICancelDoctorRotaCommandHandler {

    /* 构造注入 - 开始 */
    private final DoctorRotaDaoAdapter doctorRotaDaoAdapter;

    public CancelDoctorRotaCommandHandler(DoctorRotaDaoAdapter doctorRotaDaoAdapter) {
        this.doctorRotaDaoAdapter = doctorRotaDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public void action(CancelDoctorRotaCommand command) {
        /* 获得分布式锁 */
        DistributedLock distributedLock = new DistributedLock("UPDATEROTA-" + command.getId(), UUID.randomUUID().toString());
        /* 锁上 */
        distributedLock.lock();
        try {
            /* 执行修改状态方法 */
            doctorRotaDaoAdapter.updateDoctorRotaStatus(command.getId(), DoctorRotaSetVo.STATUS_CANCEL);
        } catch (NullPointerException e) {
            /* 捕获异常 NullPointerException , 抛 DoctorRotaNotFoundException */
            throw new DoctorRotaNotFoundException();
        } finally {
            /* 解锁 */
            distributedLock.unlock();
        }
    }
}
