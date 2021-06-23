package com.example.physicalexamservice.adapter;

import com.example.physicalexamservice.outlet.dao.mysql.PhysicalExamMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.PhysicalExamRecordDetailMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordDetailMysqlPo;
import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 适配器类 - 适配 - PhysicalExamRecordDetailDao
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class PhysicalExamRecordDetailDaoAdapter {

    /* 构造注入 - 开始 */
    private final PhysicalExamRecordDetailMysqlPoDao physicalExamRecordDetailMysqlPoDao;

    private final PhysicalExamMysqlPoDao physicalExamMysqlPoDao;

    public PhysicalExamRecordDetailDaoAdapter(PhysicalExamRecordDetailMysqlPoDao physicalExamRecordDetailMysqlPoDao, PhysicalExamMysqlPoDao physicalExamMysqlPoDao) {
        this.physicalExamRecordDetailMysqlPoDao = physicalExamRecordDetailMysqlPoDao;
        this.physicalExamMysqlPoDao = physicalExamMysqlPoDao;
    }
    /* 构造注入 - 结束 */

    /**
     * 添加方法
     *
     * @param innerAddPhysicalExamRecordDetailPoList
     * @param recordId
     */
    public void addFromTreat(List<AddPhysicalExamRecordCommand.InnerAddPhysicalExamRecordDetailPo> innerAddPhysicalExamRecordDetailPoList, Long recordId, String status) {
        /* 循环添加 */
        innerAddPhysicalExamRecordDetailPoList.forEach(i -> {
            /* 实例化 PhysicalExamRecordDetailMysqlPo */
            PhysicalExamRecordDetailMysqlPo physicalExamRecordDetailMysqlPo = new PhysicalExamRecordDetailMysqlPo();
            /* 赋值 */
            physicalExamRecordDetailMysqlPo.setExamid(i.getExamid());
            physicalExamRecordDetailMysqlPo.setCount(i.getCount());
            physicalExamRecordDetailMysqlPo.setStatus(status);
            physicalExamRecordDetailMysqlPo.setRecordid(recordId);
            physicalExamRecordDetailMysqlPo.setPrice(i.getPrice());
            /* 调用方法添加 */
            physicalExamRecordDetailMysqlPoDao.insert(physicalExamRecordDetailMysqlPo);
            /* 储存主键 */
            i.setId(physicalExamRecordDetailMysqlPo.getId());
        });
    }


}
