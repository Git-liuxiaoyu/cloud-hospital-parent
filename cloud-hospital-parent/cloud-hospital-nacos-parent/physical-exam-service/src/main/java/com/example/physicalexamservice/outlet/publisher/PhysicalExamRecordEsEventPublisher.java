package com.example.physicalexamservice.outlet.publisher;

import com.example.physicalexamservice.outlet.dao.es.PhysicalExamRecordEsPoDao;
import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordEsPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordMysqlPo;
import com.example.physicalexamservice.outlet.publisher.api.IPhysicalExamRecordDetailEsEventPublisher;
import com.example.physicalexamservice.outlet.publisher.api.IPhysicalExamRecordEsEventPublisher;
import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;
import com.example.physicalexamservice.util.ApplicationContextHolder;
import com.example.physicalexamservice.util.converter.PhysicalExamRecordEsPoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 接口实现类 - 实现 - IPhysicalExamRecordEsEventPublisher
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class PhysicalExamRecordEsEventPublisher implements IPhysicalExamRecordEsEventPublisher {


    /* 构造注入 - START */
    private final PhysicalExamRecordEsPoDao physicalExamRecordEsPoDao;

    private final PhysicalExamRecordEsPoConverter physicalExamRecordEsPoConverter;

    public PhysicalExamRecordEsEventPublisher(PhysicalExamRecordEsPoDao physicalExamRecordEsPoDao, PhysicalExamRecordEsPoConverter physicalExamRecordEsPoConverter) {
        this.physicalExamRecordEsPoDao = physicalExamRecordEsPoDao;
        this.physicalExamRecordEsPoConverter = physicalExamRecordEsPoConverter;
    }
    /* 构造注入 -END */


    /**
     * 修改支付状态
     *
     * @param event
     */
    @Override
    @EventListener(UpdateStatusPhysicalExamRecordEsEvent.class)
    public void updateStatus(UpdateStatusPhysicalExamRecordEsEvent event) {
        /* 获得 Source */
        PhysicalExamRecordMysqlPo physicalExamRecordMysqlPo = (PhysicalExamRecordMysqlPo) event.getSource();
        /* 转换为 EsPo */
        PhysicalExamRecordEsPo physicalExamRecordEsPo = physicalExamRecordEsPoConverter.convert(physicalExamRecordMysqlPo);
        /* 存入 Es */
        physicalExamRecordEsPoDao.save(physicalExamRecordEsPo);
    }

    /**
     * 添加方法
     *
     * @param event
     */
    @Override
    @EventListener(AddPhysicalExamRecordEsEvent.class)
    public void insert(AddPhysicalExamRecordEsEvent event) {
        /* 获得 source */
        AddPhysicalExamRecordCommand command = (AddPhysicalExamRecordCommand) event.getSource();
        /* 转换为 EsPo */
        PhysicalExamRecordEsPo physicalExamRecordEsPo = physicalExamRecordEsPoConverter.convert(command);
        /* Log */
        log.info("存入 PhysicalExamRecordEsPo 到 Es - [{}]", physicalExamRecordEsPo);
        /* 保存 Es */
        physicalExamRecordEsPoDao.save(physicalExamRecordEsPo);
        /* Event Bus 添加 RecordDetail */
        ApplicationContextHolder.getApplicationContext().publishEvent(new IPhysicalExamRecordDetailEsEventPublisher.AddPhysicalExamRecordDetailEsEvent(command));
    }
}
