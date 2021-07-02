package com.example.physicalexamservice.service.command.physicalexamrecord.payed;

import com.example.physicalexamservice.adapter.PhysicalExamRecordDaoAdapter;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordMysqlPo;
import com.example.physicalexamservice.service.api.physicalexamrecord.IUpdatePhysicalExamRecordPayedCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 接口实现类 - 实现 - IUpdatePhysicalExamRecordPayedCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/7/2
 */
@Component
@Slf4j
@Transactional
public class UpdatePhysicalExamRecordPayedCommandHandler implements IUpdatePhysicalExamRecordPayedCommandHandler {

    /* 构造注入 - 开始 */
    private final PhysicalExamRecordDaoAdapter physicalExamRecordDaoAdapter;

    public UpdatePhysicalExamRecordPayedCommandHandler(PhysicalExamRecordDaoAdapter physicalExamRecordDaoAdapter) {
        this.physicalExamRecordDaoAdapter = physicalExamRecordDaoAdapter;
    }
    /* 构造注入 - 结束 */


    @Override
    public void action(UpdatePhysicalExamRecordPayedCommand command) {
        try {
            /* 调用方法修改 */
            physicalExamRecordDaoAdapter.updateStatus(command.getId(), PhysicalExamRecordVo.STATUS_PAYED);
        } catch (NullPointerException e) {
            throw new PhysicalExamRecordNotFoundException();
        } catch (IllegalStateException e){
            throw new PhysicalExamRecordCannotPayException();
        }
    }
}

