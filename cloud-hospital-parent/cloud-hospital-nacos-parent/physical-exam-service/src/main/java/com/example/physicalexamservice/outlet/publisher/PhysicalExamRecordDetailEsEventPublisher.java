package com.example.physicalexamservice.outlet.publisher;

import com.example.physicalexamservice.outlet.dao.es.PhysicalExamRecordDetailEsPoDao;
import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordDetailEsPo;
import com.example.physicalexamservice.outlet.dao.mysql.PhysicalExamMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamMysqlPo;
import com.example.physicalexamservice.outlet.publisher.api.IPhysicalExamRecordDetailEsEventPublisher;
import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;
import com.example.physicalexamservice.util.converter.PhysicalExamRecordDetailEsPoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口实现类 - 实现 -
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class PhysicalExamRecordDetailEsEventPublisher implements IPhysicalExamRecordDetailEsEventPublisher {

    /* 构造注入 - 开始 */
    private final PhysicalExamRecordDetailEsPoDao physicalExamRecordDetailEsPoDao;

    private final PhysicalExamMysqlPoDao physicalExamMysqlPoDao;

    private final PhysicalExamRecordDetailEsPoConverter physicalExamRecordDetailEsPoConverter;

    public PhysicalExamRecordDetailEsEventPublisher(PhysicalExamRecordDetailEsPoDao physicalExamRecordDetailEsPoDao, PhysicalExamRecordDetailEsPoConverter physicalExamRecordDetailEsPoConverter, PhysicalExamMysqlPoDao physicalExamMysqlPoDao) {
        this.physicalExamRecordDetailEsPoDao = physicalExamRecordDetailEsPoDao;
        this.physicalExamRecordDetailEsPoConverter = physicalExamRecordDetailEsPoConverter;
        this.physicalExamMysqlPoDao = physicalExamMysqlPoDao;
    }
    /* 构造注入 - 结束 */

    /**
     * 添加到 Es 方法
     *
     * @param event
     */
    @Override
    @EventListener(AddPhysicalExamRecordDetailEsEvent.class)
    public void insert(AddPhysicalExamRecordDetailEsEvent event) {
        /* 获得 source */
        AddPhysicalExamRecordCommand command = (AddPhysicalExamRecordCommand) event.getSource();
        /* 转换 EsPoList */
        List<PhysicalExamRecordDetailEsPo> physicalExamRecordDetailEsPoList = physicalExamRecordDetailEsPoConverter.convert(command.getInnerAddPhysicalExamRecordDetailPoList(), command.getId());
        /* LOG */
        log.info("体检记录详情 存入Es -> [{}]",physicalExamRecordDetailEsPoList);
        /* 调用方法存入Es */
        physicalExamRecordDetailEsPoDao.saveAll(physicalExamRecordDetailEsPoList);
    }
}
