package com.example.physicalexamservice.adapter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.outlet.dao.es.PhysicalExamRecordEsPoDao;
import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordEsPo;
import com.example.physicalexamservice.outlet.dao.mysql.PhysicalExamRecordMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordMysqlPo;
import com.example.physicalexamservice.util.converter.PhysicalExamRecordVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 适配器类 - 适配 - PhysicalExamRecordDao
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class PhysicalExamRecordDaoAdapter {

    /* 构造注入 - 开始 */
    private final PhysicalExamRecordMysqlPoDao physicalExamRecordMysqlPoDao;

    private final PhysicalExamRecordEsPoDao physicalExamRecordEsPoDao;

    private final PhysicalExamRecordVoConverter physicalExamRecordVoConverter;

    public PhysicalExamRecordDaoAdapter(PhysicalExamRecordMysqlPoDao physicalExamRecordMysqlPoDao, PhysicalExamRecordEsPoDao physicalExamRecordEsPoDao, PhysicalExamRecordVoConverter physicalExamRecordVoConverter) {
        this.physicalExamRecordMysqlPoDao = physicalExamRecordMysqlPoDao;
        this.physicalExamRecordEsPoDao = physicalExamRecordEsPoDao;
        this.physicalExamRecordVoConverter = physicalExamRecordVoConverter;
    }
    /* 构造注入 - 结束 */

    /**
     * 添加检查记录
     *
     * @param treatrecordid
     * @param doctorid
     * @param patientid
     * @param status
     * @return
     */
    public Long addFromTreat(Long treatrecordid, Integer doctorid, Long patientid, String status, String no, Date createTime) {
        /* 实例化 */
        PhysicalExamRecordMysqlPo physicalExamRecordMysqlPo = new PhysicalExamRecordMysqlPo();
        /* 赋值 */
        physicalExamRecordMysqlPo.setCreatetime(createTime);
        physicalExamRecordMysqlPo.setDoctorid(doctorid);
        physicalExamRecordMysqlPo.setPatientid(patientid);
        physicalExamRecordMysqlPo.setTreatrecordid(treatrecordid);
        physicalExamRecordMysqlPo.setStatus(status);
        physicalExamRecordMysqlPo.setNo(no);
        /* 添加 */
        physicalExamRecordMysqlPoDao.insert(physicalExamRecordMysqlPo);
        /* 返回主键 */
        return physicalExamRecordMysqlPo.getId();
    }

    /**
     * 根据No查询
     *
     * @param recordNo
     * @return
     */
    public PhysicalExamRecordVo queryByNo(String recordNo) {
        /* 从Es查询 */
        PhysicalExamRecordEsPo physicalExamRecordEsPo = physicalExamRecordEsPoDao.findByNoEquals(recordNo);
        /* 转换为Vo */
        PhysicalExamRecordVo physicalExamRecordVo = physicalExamRecordVoConverter.convert(physicalExamRecordEsPo);
        /* 返回 */
        return physicalExamRecordVo;
    }
}
