package com.example.physicalexamservice.adapter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.outlet.dao.es.PhysicalExamRecordEsPoDao;
import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordEsPo;
import com.example.physicalexamservice.outlet.dao.mysql.PhysicalExamRecordMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordMysqlPo;
import com.example.physicalexamservice.outlet.dao.redis.PhysicalExamRecordRedisPoDao;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamRecordRedisPo;
import com.example.physicalexamservice.util.converter.PhysicalExamRecordRedisPoConverter;
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

    private final PhysicalExamRecordRedisPoDao physicalExamRecordRedisPoDao;

    private final PhysicalExamRecordRedisPoConverter physicalExamRecordRedisPoConverter;

    public PhysicalExamRecordDaoAdapter(PhysicalExamRecordMysqlPoDao physicalExamRecordMysqlPoDao, PhysicalExamRecordEsPoDao physicalExamRecordEsPoDao, PhysicalExamRecordVoConverter physicalExamRecordVoConverter, PhysicalExamRecordRedisPoDao physicalExamRecordRedisPoDao, PhysicalExamRecordRedisPoConverter physicalExamRecordRedisPoConverter) {
        this.physicalExamRecordMysqlPoDao = physicalExamRecordMysqlPoDao;
        this.physicalExamRecordEsPoDao = physicalExamRecordEsPoDao;
        this.physicalExamRecordVoConverter = physicalExamRecordVoConverter;
        this.physicalExamRecordRedisPoDao = physicalExamRecordRedisPoDao;
        this.physicalExamRecordRedisPoConverter = physicalExamRecordRedisPoConverter;
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
        /* 声明 */
        PhysicalExamRecordVo physicalExamRecordVo = new PhysicalExamRecordVo();
        try {
            /* 先从 Redis 查 */
            PhysicalExamRecordRedisPo physicalExamRecordRedisPo = physicalExamRecordRedisPoDao.findByNoEquals(recordNo);
            /* 判断是否为空 */
            if (physicalExamRecordRedisPo == null) {
                throw new NullPointerException();
            }
            /* 不为空,转换Vo */
            physicalExamRecordVo = physicalExamRecordVoConverter.convert(physicalExamRecordRedisPo);
        } catch (NullPointerException e) {
            /* 从Es查询 */
            PhysicalExamRecordEsPo physicalExamRecordEsPo = physicalExamRecordEsPoDao.findByNoEquals(recordNo);
            /* 转换为Vo */
            physicalExamRecordVo = physicalExamRecordVoConverter.convert(physicalExamRecordEsPo);
            /* 转换为 RedisPo */
            PhysicalExamRecordRedisPo physicalExamRecordRedisPo = physicalExamRecordRedisPoConverter.convert(physicalExamRecordEsPo);
            /* 存入Redis */
            physicalExamRecordRedisPoDao.save(physicalExamRecordRedisPo);
        }
        /* 返回 */
        return physicalExamRecordVo;
    }
}
