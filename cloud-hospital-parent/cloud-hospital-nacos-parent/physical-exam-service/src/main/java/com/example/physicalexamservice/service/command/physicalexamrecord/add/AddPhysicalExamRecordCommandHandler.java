package com.example.physicalexamservice.service.command.physicalexamrecord.add;

import com.example.physicalexamservice.adapter.PhysicalExamDaoAdapter;
import com.example.physicalexamservice.adapter.PhysicalExamRecordDaoAdapter;
import com.example.physicalexamservice.adapter.PhysicalExamRecordDetailDaoAdapter;
import com.example.physicalexamservice.adapter.PhysicalExamTypeDaoAdapter;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordDetailVo;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.service.api.physicalexamrecord.IAddPhysicalExamRecordCommandHandler;
import com.example.physicalexamservice.util.CreateRandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 接口实现类 - 实现 - IAddPhysicalExamRecordCommandHandler
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
@Transactional
public class AddPhysicalExamRecordCommandHandler implements IAddPhysicalExamRecordCommandHandler {

    /* 构造注入 - 开始 */
    private final PhysicalExamRecordDaoAdapter physicalExamRecordDaoAdapter;

    private final PhysicalExamRecordDetailDaoAdapter physicalExamRecordDetailDaoAdapter;

    private final PhysicalExamDaoAdapter physicalExamDaoAdapter;

    private final PhysicalExamTypeDaoAdapter physicalExamTypeDaoAdapter;

    public AddPhysicalExamRecordCommandHandler(PhysicalExamRecordDaoAdapter physicalExamRecordDaoAdapter, PhysicalExamRecordDetailDaoAdapter physicalExamRecordDetailDaoAdapter, PhysicalExamDaoAdapter physicalExamDaoAdapter, PhysicalExamTypeDaoAdapter physicalExamTypeDaoAdapter) {
        this.physicalExamRecordDaoAdapter = physicalExamRecordDaoAdapter;
        this.physicalExamRecordDetailDaoAdapter = physicalExamRecordDetailDaoAdapter;
        this.physicalExamDaoAdapter = physicalExamDaoAdapter;
        this.physicalExamTypeDaoAdapter = physicalExamTypeDaoAdapter;
    }
    /* 构造注入 - 结束 */


    @Override
    public String action(AddPhysicalExamRecordCommand command) {
        /* 完善数据 */
        command.setCreateTime(new Date());
        command.setNo("EXAMNO" + CreateRandomUtil.createRandomVerifyCode(true, 19));
        /* 调用 Record 添加方法,返回返回值 */
        Long recordId = physicalExamRecordDaoAdapter.addFromTreat(command.getTreatrecordid(), command.getDoctorid(), command.getPatientid(), PhysicalExamRecordVo.STATUS_NOTPAY, command.getNo(), command.getCreateTime());
        /* 赋值主键 */
        command.setId(recordId);
        /* 取出集合 */
        List<AddPhysicalExamRecordCommand.InnerAddPhysicalExamRecordDetailPo> innerAddPhysicalExamRecordDetailPoList = command.getInnerAddPhysicalExamRecordDetailPoList();
        /* 补充价格,减少库存,添加项目名 */
        physicalExamDaoAdapter.setListPriceAndUpdateStockAndExamInfo(innerAddPhysicalExamRecordDetailPoList);
        /* 补充类型信息 */
        physicalExamTypeDaoAdapter.setListTypeInfo(innerAddPhysicalExamRecordDetailPoList);
        /* 调用 RecordDetail 添加方法 */
        physicalExamRecordDetailDaoAdapter.addFromTreat(innerAddPhysicalExamRecordDetailPoList, recordId, PhysicalExamRecordDetailVo.STATUS_NOTEXAM);
        log.debug("添加到MySQL,{}",innerAddPhysicalExamRecordDetailPoList);
        /* 返回主键 */
        return recordId + "-" + command.getNo();
    }
}
