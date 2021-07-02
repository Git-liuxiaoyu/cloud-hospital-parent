package com.example.physicalexamservice.adapter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.outlet.dao.es.PhysicalExamRecordEsPoDao;
import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordEsPo;
import com.example.physicalexamservice.outlet.dao.mysql.MessageMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.PhysicalExamRecordMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.MessageMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordMysqlPoExample;
import com.example.physicalexamservice.outlet.dao.redis.PhysicalExamRecordRedisPoDao;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamRecordRedisPo;
import com.example.physicalexamservice.util.converter.PhysicalExamRecordRedisPoConverter;
import com.example.physicalexamservice.util.converter.PhysicalExamRecordVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

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

    private final MessageMysqlPoDao messageMysqlPoDao;

    public PhysicalExamRecordDaoAdapter(PhysicalExamRecordMysqlPoDao physicalExamRecordMysqlPoDao, PhysicalExamRecordEsPoDao physicalExamRecordEsPoDao, PhysicalExamRecordVoConverter physicalExamRecordVoConverter, PhysicalExamRecordRedisPoDao physicalExamRecordRedisPoDao, PhysicalExamRecordRedisPoConverter physicalExamRecordRedisPoConverter, MessageMysqlPoDao messageMysqlPoDao) {
        this.physicalExamRecordMysqlPoDao = physicalExamRecordMysqlPoDao;
        this.physicalExamRecordEsPoDao = physicalExamRecordEsPoDao;
        this.physicalExamRecordVoConverter = physicalExamRecordVoConverter;
        this.physicalExamRecordRedisPoDao = physicalExamRecordRedisPoDao;
        this.physicalExamRecordRedisPoConverter = physicalExamRecordRedisPoConverter;
        this.messageMysqlPoDao = messageMysqlPoDao;
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
        /* 实例化 PhysicalExamRecordMysqlPo */
        PhysicalExamRecordMysqlPo physicalExamRecordMysqlPo = new PhysicalExamRecordMysqlPo();
        /* 赋值 */
        physicalExamRecordMysqlPo.setCreatetime(createTime);
        physicalExamRecordMysqlPo.setDoctorid(doctorid);
        physicalExamRecordMysqlPo.setPatientid(patientid);
        physicalExamRecordMysqlPo.setTreatrecordid(treatrecordid);
        physicalExamRecordMysqlPo.setStatus(status);
        physicalExamRecordMysqlPo.setNo(no);
        physicalExamRecordMysqlPoDao.insert(physicalExamRecordMysqlPo);
        /* 获得主键 */
        Long recordId = physicalExamRecordMysqlPo.getId();
        /* insert 到 Message 表中 */
        /* 实例化 MessageMysqlPo */
        MessageMysqlPo messageMysqlPo = new MessageMysqlPo();
        messageMysqlPo.setMessageContent("UPDATE-" + recordId);
        messageMysqlPo.setExchange("physical_exam_record_es_ex");
        messageMysqlPo.setRoutingKey("physical.exam.record.es");
        messageMysqlPo.setStatus(MessageMysqlPo.NOT_SEND);
        messageMysqlPoDao.insertSelective(messageMysqlPo);

        /* 再添加一条信息(发送到延迟队列检测是否支付) */
        MessageMysqlPo messagePo = new MessageMysqlPo();
        messagePo.setMessageContent("ISPAY-" + recordId);
        messagePo.setExchange("physical_exam_record_is_pay_dead_ex");
        messagePo.setRoutingKey("physical.exam.record.is.pay.dead");
        messagePo.setStatus(MessageMysqlPo.NOT_SEND);
        messageMysqlPoDao.insertSelective(messagePo);
        /* 返回主键 */
        return recordId;
    }

    /**
     * 根据No查询
     *
     * @param recordNo
     * @return
     */
    public PhysicalExamRecordVo queryByNo(String recordNo) {
        try {
            /* 现在Redis查询 */
            PhysicalExamRecordRedisPo physicalExamRecordRedisPo = physicalExamRecordRedisPoDao.findByNoEquals(recordNo);
            if (physicalExamRecordRedisPo == null) {
                throw new NullPointerException();
            }
            /* 查到了 RedisPo -> Vo */
            return physicalExamRecordVoConverter.convert(physicalExamRecordRedisPo);
        } catch (NullPointerException nullPointerException) {
            try {
                /* Redis 查不到前往 Es 查询 */
                PhysicalExamRecordEsPo physicalExamRecordEsPo = physicalExamRecordEsPoDao.findByNoEquals(recordNo);
                if (physicalExamRecordEsPo == null) {
                    throw new NullPointerException();
                }
                /* insert 添加Redis缓存 到 Message */
                MessageMysqlPo messageMysqlPo = new MessageMysqlPo();
                messageMysqlPo.setMessageContent("UPDATE-" + physicalExamRecordEsPo.getId());
                messageMysqlPo.setExchange("physical_exam_record_redis_cache_ex");
                messageMysqlPo.setRoutingKey("physical.exam.record.redis.cache");
                messageMysqlPo.setStatus(MessageMysqlPo.NOT_SEND);
                messageMysqlPoDao.insertSelective(messageMysqlPo);
                /* EsPo -> Vo */
                return physicalExamRecordVoConverter.convert(physicalExamRecordEsPo);
            } catch (NullPointerException e) {
                /* Es 查不到前往 MySQL 查 */
                /* 实例化 */
                PhysicalExamRecordMysqlPoExample physicalExamRecordMysqlPoExample = new PhysicalExamRecordMysqlPoExample();
                physicalExamRecordMysqlPoExample.createCriteria().andNoEqualTo(recordNo);
                List<PhysicalExamRecordMysqlPo> physicalExamRecordMysqlPoList = physicalExamRecordMysqlPoDao.selectByExample(physicalExamRecordMysqlPoExample);
                /* 为 Null 抛空指针 */
                if (physicalExamRecordMysqlPoList.size() != 1) {
                    throw new NullPointerException();
                }
                /* 提取对象和值 */
                PhysicalExamRecordMysqlPo physicalExamRecordMysqlPo = physicalExamRecordMysqlPoList.get(0);
                Long id = physicalExamRecordMysqlPo.getId();
                /* insert 添加Redis缓存 到 Message */
                MessageMysqlPo messageMysqlPo = new MessageMysqlPo();
                messageMysqlPo.setMessageContent("UPDATE-" + id);
                messageMysqlPo.setExchange("physical_exam_record_redis_cache_ex");
                messageMysqlPo.setRoutingKey("physical.exam.record.redis.cache");
                messageMysqlPo.setStatus(MessageMysqlPo.NOT_SEND);
                messageMysqlPoDao.insertSelective(messageMysqlPo);
                /* insert 添加Es 到 Message */
                MessageMysqlPo messagePo = new MessageMysqlPo();
                messagePo.setMessageContent("UPDATE-" + id);
                messagePo.setExchange("physical_exam_record_es_ex");
                messagePo.setRoutingKey("physical.exam.record.es");
                messagePo.setStatus(MessageMysqlPo.NOT_SEND);
                messageMysqlPoDao.insertSelective(messagePo);
                /* MySQLPo -> Vo */
                return physicalExamRecordVoConverter.convert(physicalExamRecordMysqlPo);
            }
        }
    }

    /**
     * 更新状态方法
     *
     * @param id
     * @param status
     */
    public void updateStatus(Long id, String status) {
        /* 先判断id是否存在 */
        PhysicalExamRecordMysqlPo physicalExamRecordMysqlPo = physicalExamRecordMysqlPoDao.selectByPrimaryKey(id);
        /* 为 Null 抛空指针异常 */
        if (physicalExamRecordMysqlPo == null) {
            throw new NullPointerException();
        } else if (physicalExamRecordMysqlPo.getStatus() != PhysicalExamRecordVo.STATUS_NOTPAY) {
            /* 若状态不是未支付状态 */
            throw new IllegalStateException();
        }
        /* 修改状态 */
        physicalExamRecordMysqlPo.setStatus(status);
        physicalExamRecordMysqlPoDao.updateByPrimaryKeySelective(physicalExamRecordMysqlPo);
        /* Message 删除 Redis */
        MessageMysqlPo messageMysqlPo = new MessageMysqlPo();
        messageMysqlPo.setMessageContent("DELETE-" + id);
        messageMysqlPo.setExchange("physical_exam_record_redis_cache_ex");
        messageMysqlPo.setRoutingKey("physical.exam.record.redis.cache");
        messageMysqlPo.setStatus(MessageMysqlPo.NOT_SEND);
        messageMysqlPoDao.insertSelective(messageMysqlPo);
        /* Message 更新 Es */
        MessageMysqlPo messagePo = new MessageMysqlPo();
        messagePo.setMessageContent("UPDATE-" + id);
        messagePo.setExchange("physical_exam_record_es_ex");
        messagePo.setRoutingKey("physical.exam.record.es");
        messagePo.setStatus(MessageMysqlPo.NOT_SEND);
        messageMysqlPoDao.insertSelective(messagePo);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    public PhysicalExamRecordVo queryById(Long id) {
        try {
            /* 现在Redis查询 */
            PhysicalExamRecordRedisPo physicalExamRecordRedisPo = physicalExamRecordRedisPoDao.findById(id).orElseThrow(NullPointerException::new);
            /* 查到了 RedisPo -> Vo */
            return physicalExamRecordVoConverter.convert(physicalExamRecordRedisPo);
        } catch (NullPointerException nullPointerException) {
            try {
                /* Redis 查不到前往 Es 查询 */
                PhysicalExamRecordEsPo physicalExamRecordEsPo = physicalExamRecordEsPoDao.findById(id).orElseThrow(NullPointerException::new);
                /* insert 添加Redis缓存 到 Message */
                MessageMysqlPo messageMysqlPo = new MessageMysqlPo();
                messageMysqlPo.setMessageContent("UPDATE-" + id);
                messageMysqlPo.setExchange("physical_exam_record_redis_cache_ex");
                messageMysqlPo.setRoutingKey("physical.exam.record.redis.cache");
                messageMysqlPo.setStatus(MessageMysqlPo.NOT_SEND);
                messageMysqlPoDao.insertSelective(messageMysqlPo);
                /* EsPo -> Vo */
                return physicalExamRecordVoConverter.convert(physicalExamRecordEsPo);
            } catch (NullPointerException e) {
                /* Es 查不到前往 MySQL 查 */
                PhysicalExamRecordMysqlPo physicalExamRecordMysqlPo = physicalExamRecordMysqlPoDao.selectByPrimaryKey(id);
                /* 为 Null 抛空指针 */
                if (physicalExamRecordMysqlPo == null) {
                    throw new NullPointerException();
                }
                /* insert 添加Redis缓存 到 Message */
                MessageMysqlPo messageMysqlPo = new MessageMysqlPo();
                messageMysqlPo.setMessageContent("UPDATE-" + id);
                messageMysqlPo.setExchange("physical_exam_record_redis_cache_ex");
                messageMysqlPo.setRoutingKey("physical.exam.record.redis.cache");
                messageMysqlPo.setStatus(MessageMysqlPo.NOT_SEND);
                messageMysqlPoDao.insertSelective(messageMysqlPo);
                /* insert 添加Es 到 Message */
                MessageMysqlPo messagePo = new MessageMysqlPo();
                messagePo.setMessageContent("UPDATE-" + id);
                messagePo.setExchange("physical_exam_record_es_ex");
                messagePo.setRoutingKey("physical.exam.record.es");
                messagePo.setStatus(MessageMysqlPo.NOT_SEND);
                messageMysqlPoDao.insertSelective(messagePo);
                /* MySQLPo -> Vo */
                return physicalExamRecordVoConverter.convert(physicalExamRecordMysqlPo);
            }
        }
    }
}
