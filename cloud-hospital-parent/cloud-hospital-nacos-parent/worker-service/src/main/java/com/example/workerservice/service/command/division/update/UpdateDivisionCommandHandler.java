package com.example.workerservice.service.command.division.update;

import com.example.workerservice.adapter.DivisionDaoAdapter;
import com.example.workerservice.outlet.publisher.api.IDivisionEsEventPublisher;
import com.example.workerservice.service.api.division.IUpdateDivisionCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import com.example.workerservice.util.DistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 接口实现类 - 实现 - IUpdateDivisionCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/28
 */
@Slf4j
@Transactional
@Component
public class UpdateDivisionCommandHandler implements IUpdateDivisionCommandHandler {

    /* 构造注入 - 开始 */
    private final DivisionDaoAdapter divisionDaoAdapter;

    public UpdateDivisionCommandHandler(DivisionDaoAdapter divisionDaoAdapter) {
        this.divisionDaoAdapter = divisionDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public void action(UpdateDivisionCommand command) {
        /* 声明分布式锁 */
        DistributedLock distributedLock = new DistributedLock("UPDATEDIVISION-" + command.getId());

        /* 开始分布式锁 */
        distributedLock.lock();

        /* 调用方法修改 MySQL */
        divisionDaoAdapter.update(command.getId(), command.getName(), command.getDescription(), command.getStatus());
        /* 调用方法修改 Es */
        ApplicationContextHolder.getApplicationContext().publishEvent(new IDivisionEsEventPublisher.UpdateDivisionEsEvent(command));

        /* 接触分布式锁 */
        distributedLock.unlock();
    }
}
