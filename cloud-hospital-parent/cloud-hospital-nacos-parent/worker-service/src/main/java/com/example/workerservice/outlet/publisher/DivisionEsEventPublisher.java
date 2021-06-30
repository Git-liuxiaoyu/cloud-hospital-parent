package com.example.workerservice.outlet.publisher;

import com.example.workerservice.outlet.dao.es.DivisionEsPoDao;
import com.example.workerservice.outlet.dao.es.po.DivisionEsPo;
import com.example.workerservice.outlet.publisher.api.IDivisionEsEventPublisher;
import com.example.workerservice.service.command.division.add.AddDivisionCommand;
import com.example.workerservice.service.command.division.update.UpdateDivisionCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/28
 */
@Component
@Slf4j
public class DivisionEsEventPublisher implements IDivisionEsEventPublisher {

    /* 构造注入 - 开始 */
    private final DivisionEsPoDao divisionEsPoDao;

    public DivisionEsEventPublisher(DivisionEsPoDao divisionEsPoDao) {
        this.divisionEsPoDao = divisionEsPoDao;
    }
    /* 构造注入 - 结束 */

    @Override
    @EventListener(value = AddDivisionEsEvent.class)
    public void insert(AddDivisionEsEvent event) {
        /* 获得 source 原对象 */
        AddDivisionCommand command = (AddDivisionCommand) event.getSource();
        /* 实例化 */
        DivisionEsPo divisionEsPo = DivisionEsPo.builder()
                .id(command.getId())
                .name(command.getName())
                .description(command.getDescription())
                .status(command.getStatus())
                .build();
        /* 存入 Es */
        divisionEsPoDao.save(divisionEsPo);
    }

    @Override
    public void update(UpdateDivisionEsEvent event) {
        /* 获得 source 原对象 */
        UpdateDivisionCommand command = (UpdateDivisionCommand) event.getSource();
        /* 实例化 */
        DivisionEsPo divisionEsPo = DivisionEsPo.builder()
                .id(command.getId())
                .name(command.getName())
                .description(command.getDescription())
                .status(command.getStatus())
                .build();
        /* 存入 Es */
        divisionEsPoDao.save(divisionEsPo);
    }
}
