package com.example.workerservice.service.command.division.add;

import com.example.workerservice.adapter.DivisionDaoAdapter;
import com.example.workerservice.inlet.web.vo.DivisionVo;
import com.example.workerservice.outlet.publisher.api.IDivisionEsEventPublisher;
import com.example.workerservice.service.api.division.IAddDivisionCommandHandler;
import com.example.workerservice.util.ApplicationContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 接口实现类 - 实现 - IAddDivisionCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/28
 */
@Slf4j
@Transactional
@Component
public class AddDivisionCommandHandler implements IAddDivisionCommandHandler {

    /* 构造注入 - 开始 */
    private final DivisionDaoAdapter divisionDaoAdapter;

    public AddDivisionCommandHandler(DivisionDaoAdapter divisionDaoAdapter) {
        this.divisionDaoAdapter = divisionDaoAdapter;
    }
    /* 构造注入 - 结束 */

    @Override
    public void action(AddDivisionCommand command) {
        /* 调用方法添加进 MySQL */
        Integer id = divisionDaoAdapter.add(command.getName(), command.getDescription(), DivisionVo.STATUS_NORMAL);
        /* 赋值主键ID */
        command.setId(id);
        command.setStatus(DivisionVo.STATUS_NORMAL);
        /* 调用方法添加进 Es */
        ApplicationContextHolder.getApplicationContext().publishEvent(new IDivisionEsEventPublisher.AddDivisionEsEvent(command));
    }
}
