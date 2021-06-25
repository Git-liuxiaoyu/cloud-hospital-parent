package com.example.physicalexamservice.service.command.physicalexamtype.update;

import com.example.physicalexamservice.adapter.PhysicalExamTypeDaoAdapter;
import com.example.physicalexamservice.outlet.publisher.PhysicalExamTypeRedisCachePublisher;
import com.example.physicalexamservice.service.api.physicalexamtype.IUpdatePhysicalExamTypeCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 接口实现类 - 实现 - IUpdatePhysicalExamTypeCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Component
@Slf4j
@Transactional
public class UpdatePhysicalExamTypeCommandHandler implements IUpdatePhysicalExamTypeCommandHandler {

    /* 构造注入 - 开始 */
    private final PhysicalExamTypeDaoAdapter physicalExamTypeDaoAdapter;

    private final PhysicalExamTypeRedisCachePublisher physicalExamTypeRedisCachePublisher;

    public UpdatePhysicalExamTypeCommandHandler(PhysicalExamTypeDaoAdapter physicalExamTypeDaoAdapter, PhysicalExamTypeRedisCachePublisher physicalExamTypeRedisCachePublisher) {
        this.physicalExamTypeDaoAdapter = physicalExamTypeDaoAdapter;
        this.physicalExamTypeRedisCachePublisher = physicalExamTypeRedisCachePublisher;
    }
    /* 构造注入 - 结束 */

    @Override
    public void action(UpdatePhysicalExamTypeCommand command) {
        /* 调用方法 */
        physicalExamTypeDaoAdapter.update(command.getId(), command.getName(), command.getDescription());
        /* 发送删除缓存请求 到缓存队列 */
        physicalExamTypeRedisCachePublisher.publishPhysicalExamTypeAllDelete();
    }
}
