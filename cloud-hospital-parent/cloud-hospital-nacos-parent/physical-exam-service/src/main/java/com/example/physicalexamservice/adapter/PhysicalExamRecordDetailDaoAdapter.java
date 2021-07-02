package com.example.physicalexamservice.adapter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordDetailVo;
import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordVo;
import com.example.physicalexamservice.inlet.web.vo.ResponseResult;
import com.example.physicalexamservice.outlet.client.WorkerServiceOpenFeignClient;
import com.example.physicalexamservice.outlet.client.vo.WorkerInfoVo;
import com.example.physicalexamservice.outlet.dao.es.PhysicalExamRecordDetailEsPoDao;
import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordDetailEsPo;
import com.example.physicalexamservice.outlet.dao.mysql.*;
import com.example.physicalexamservice.outlet.dao.mysql.po.*;
import com.example.physicalexamservice.outlet.dao.redis.PhysicalExamRecordDetailRedisPoDao;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamRecordDetailRedisPo;
import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;
import com.example.physicalexamservice.util.converter.PhysicalExamRecordDetailRedisPoConverter;
import com.example.physicalexamservice.util.converter.PhysicalExamRecordDetailVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

    private final PhysicalExamRecordDetailEsPoDao physicalExamRecordDetailEsPoDao;

    private final PhysicalExamRecordDetailRedisPoDao physicalExamRecordDetailRedisPoDao;

    private final PhysicalExamRecordDetailVoConverter physicalExamRecordDetailVoConverter;

    private final PhysicalExamRecordDetailRedisPoConverter physicalExamRecordDetailRedisPoConverter;

    private final PhysicalExamMysqlPoDao physicalExamMysqlPoDao;

    private final PhysicalExamTypeMysqlPoDao physicalExamTypeMysqlPoDao;

    private final PhysicalExamRecordMysqlPoDao physicalExamRecordMysqlPoDao;

    private final MessageMysqlPoDao messageMysqlPoDao;

    private final WorkerServiceOpenFeignClient workerServiceOpenFeignClient;

    public PhysicalExamRecordDetailDaoAdapter(PhysicalExamRecordDetailMysqlPoDao physicalExamRecordDetailMysqlPoDao, PhysicalExamRecordDetailEsPoDao physicalExamRecordDetailEsPoDao, PhysicalExamRecordDetailRedisPoDao physicalExamRecordDetailRedisPoDao, PhysicalExamRecordDetailVoConverter physicalExamRecordDetailVoConverter, PhysicalExamRecordDetailRedisPoConverter physicalExamRecordDetailRedisPoConverter, MessageMysqlPoDao messageMysqlPoDao, PhysicalExamMysqlPoDao physicalExamMysqlPoDao, PhysicalExamTypeMysqlPoDao physicalExamTypeMysqlPoDao, WorkerServiceOpenFeignClient workerServiceOpenFeignClient, PhysicalExamRecordMysqlPoDao physicalExamRecordMysqlPoDao) {
        this.physicalExamRecordDetailMysqlPoDao = physicalExamRecordDetailMysqlPoDao;
        this.physicalExamRecordDetailEsPoDao = physicalExamRecordDetailEsPoDao;
        this.physicalExamRecordDetailRedisPoDao = physicalExamRecordDetailRedisPoDao;
        this.physicalExamRecordDetailVoConverter = physicalExamRecordDetailVoConverter;
        this.physicalExamRecordDetailRedisPoConverter = physicalExamRecordDetailRedisPoConverter;
        this.messageMysqlPoDao = messageMysqlPoDao;
        this.physicalExamMysqlPoDao = physicalExamMysqlPoDao;
        this.physicalExamTypeMysqlPoDao = physicalExamTypeMysqlPoDao;
        this.workerServiceOpenFeignClient = workerServiceOpenFeignClient;
        this.physicalExamRecordMysqlPoDao = physicalExamRecordMysqlPoDao;
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
            /* insert 到 Physical_Exam_Record_Detail 表中 */
            /* 实例化 PhysicalExamRecordDetailMysqlPo */
            PhysicalExamRecordDetailMysqlPo physicalExamRecordDetailMysqlPo = new PhysicalExamRecordDetailMysqlPo();
            /* 赋值 */
            physicalExamRecordDetailMysqlPo.setExamid(i.getExamid());
            physicalExamRecordDetailMysqlPo.setCount(i.getCount());
            /* 给状态赋值 */
            physicalExamRecordDetailMysqlPo.setStatus(status);
            i.setStatus(status);
            physicalExamRecordDetailMysqlPo.setRecordid(recordId);
            physicalExamRecordDetailMysqlPo.setPrice(i.getPrice());
            physicalExamRecordDetailMysqlPo.setTypeid(i.getTypeid());
            /* 调用方法添加 */
            physicalExamRecordDetailMysqlPoDao.insert(physicalExamRecordDetailMysqlPo);
            /* LOG */
            log.debug("添加 Detail 到 Es {}",physicalExamRecordDetailMysqlPo);
            /* 储存主键 */
            i.setId(physicalExamRecordDetailMysqlPo.getId());

            /* insert 到 Message 表中 */
            MessageMysqlPo messageMysqlPo = new MessageMysqlPo();
            messageMysqlPo.setMessageContent("UPDATE-" + physicalExamRecordDetailMysqlPo.getId());
            messageMysqlPo.setExchange("physical_exam_record_detail_es_ex");
            messageMysqlPo.setRoutingKey("physical.exam.record.detail.es");
            messageMysqlPo.setStatus(MessageMysqlPo.NOT_SEND);
            messageMysqlPoDao.insertSelective(messageMysqlPo);
        });
    }

    /**
     * 根据 recordID 查询 List<Detail>
     *
     * @param recordId
     * @return
     */
    public List<PhysicalExamRecordDetailVo> queryListByRecordId(Long recordId) {
        /* 直接往 Es 查 */
        List<PhysicalExamRecordDetailEsPo> physicalExamRecordDetailEsPoList = physicalExamRecordDetailEsPoDao.findByRecordidEquals(recordId);
        /* 转换Vo */
        List<PhysicalExamRecordDetailVo> physicalExamRecordDetailVoList = physicalExamRecordDetailVoConverter.convert(physicalExamRecordDetailEsPoList);
        /* 转换 RedisPo */
        List<PhysicalExamRecordDetailRedisPo> physicalExamRecordDetailRedisPoList = physicalExamRecordDetailRedisPoConverter.convert(physicalExamRecordDetailEsPoList);
        /* 存入 Redis */
        physicalExamRecordDetailRedisPoDao.saveAll(physicalExamRecordDetailRedisPoList);
        /* 返回 */
        return physicalExamRecordDetailVoList;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    public PhysicalExamRecordDetailVo queryById(Long id) {
        try {
            /* 现在Redis查询 */
            PhysicalExamRecordDetailRedisPo physicalExamRecordDetailRedisPo = physicalExamRecordDetailRedisPoDao.findById(id).orElseThrow(NullPointerException::new);
            /* 查到了 RedisPo -> Vo */
            return physicalExamRecordDetailVoConverter.convert(physicalExamRecordDetailRedisPo);
        } catch (NullPointerException nullPointerException) {
            try {
                /* Redis 查不到前往 Es 查询 */
                PhysicalExamRecordDetailEsPo physicalExamRecordDetailEsPo = physicalExamRecordDetailEsPoDao.findById(id).orElseThrow(NullPointerException::new);
                /* insert 添加Redis缓存 到 Message */
                MessageMysqlPo messageMysqlPo = new MessageMysqlPo();
                messageMysqlPo.setMessageContent("UPDATE-" + id);
                messageMysqlPo.setExchange("physical_exam_record_redis_cache_ex");
                messageMysqlPo.setRoutingKey("physical.exam.record.redis.cache");
                messageMysqlPo.setStatus(MessageMysqlPo.NOT_SEND);
                messageMysqlPoDao.insertSelective(messageMysqlPo);
                /* EsPo -> Vo */
                return physicalExamRecordDetailVoConverter.convert(physicalExamRecordDetailEsPo);
            } catch (NullPointerException e) {
                /* Es 查不到前往 MySQL 查 */
                PhysicalExamRecordDetailMysqlPo physicalExamRecordDetailMysqlPo = physicalExamRecordDetailMysqlPoDao.selectByPrimaryKey(id);
                /* 为 Null 抛空指针 */
                if (physicalExamRecordDetailMysqlPo == null) {
                    throw new NullPointerException();
                }
                /* insert 添加Redis缓存 到 Message */
                MessageMysqlPo messageMysqlPo = new MessageMysqlPo();
                messageMysqlPo.setMessageContent("UPDATE-" + id);
                messageMysqlPo.setExchange("physical_exam_record_detail_redis_cache_ex");
                messageMysqlPo.setRoutingKey("physical.exam.record.detail.redis.cache");
                messageMysqlPo.setStatus(MessageMysqlPo.NOT_SEND);
                messageMysqlPoDao.insertSelective(messageMysqlPo);
                /* insert 添加Es 到 Message */
                MessageMysqlPo messagePo = new MessageMysqlPo();
                messagePo.setMessageContent("UPDATE-" + id);
                messagePo.setExchange("physical_exam_record_detail_es_ex");
                messagePo.setRoutingKey("physical.exam.record.detail.es");
                messagePo.setStatus(MessageMysqlPo.NOT_SEND);
                messageMysqlPoDao.insertSelective(messagePo);
                /* MySQLPo -> Vo */
                return convert(physicalExamRecordDetailMysqlPo);
            }
        }
    }

    /**
     * PhysicalExamRecordDetailMysqlPo -> PhysicalExamRecordDetailVo
     *
     * @param physicalExamRecordDetailMysqlPo
     * @return
     */
    private PhysicalExamRecordDetailVo convert(PhysicalExamRecordDetailMysqlPo physicalExamRecordDetailMysqlPo) {
        /* 实例化 PhysicalExamRecordDetailVo */
        PhysicalExamRecordDetailVo physicalExamRecordDetailVo = new PhysicalExamRecordDetailVo();
        /* 判断是否未null */
        if (physicalExamRecordDetailMysqlPo == null) {
            throw new NullPointerException();
        }
        /* 复制属性 */
        BeanUtils.copyProperties(physicalExamRecordDetailMysqlPo, physicalExamRecordDetailVo);
        /* 查询属性 */
        PhysicalExamMysqlPo physicalExamMysqlPo = physicalExamMysqlPoDao.selectByPrimaryKey(physicalExamRecordDetailMysqlPo.getExamid());
        PhysicalExamTypeMysqlPo physicalExamTypeMysqlPo = physicalExamTypeMysqlPoDao.selectByPrimaryKey(physicalExamRecordDetailMysqlPo.getTypeid());
        /* 判断是否为null */
        if (physicalExamTypeMysqlPo == null || physicalExamMysqlPo == null) {
            throw new NullPointerException();
        }
        if (physicalExamRecordDetailMysqlPo.getExamdocid() != null) {
            ResponseResult<WorkerInfoVo> workerInfoById = workerServiceOpenFeignClient.getWorkerInfoById(physicalExamRecordDetailMysqlPo.getExamdocid());
            if (workerInfoById.getCode() != 200) {
                throw new NullPointerException();
            }
            physicalExamRecordDetailVo.setExamDocName(workerInfoById.getData().getName());
        }
        /* 增加属性 */
        physicalExamRecordDetailVo.setExamName(physicalExamMysqlPo.getName());
        physicalExamRecordDetailVo.setTypeName(physicalExamTypeMysqlPo.getName());

        /* 返回 */
        return physicalExamRecordDetailVo;
    }

    /**
     * 检测
     *
     * @param id
     * @param examdocid
     * @param resulttext
     * @param status
     */
    public void update(Long id, Integer examdocid, String resulttext, String status) {
        PhysicalExamRecordDetailVo physicalExamRecordDetailVo = null;
        /* 查询 */
        try {
            physicalExamRecordDetailVo = queryById(id);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }

        /* 实例化 */
        PhysicalExamRecordDetailMysqlPo physicalExamRecordDetailMysqlPo = new PhysicalExamRecordDetailMysqlPo();
        /* 赋值 */
        physicalExamRecordDetailMysqlPo.setId(id);
        physicalExamRecordDetailMysqlPo.setExamdocid(examdocid);
        physicalExamRecordDetailMysqlPo.setResulttext(resulttext);
        physicalExamRecordDetailMysqlPo.setStatus(status);
        /* 更新方法 */
        physicalExamRecordDetailMysqlPoDao.updateByPrimaryKeySelective(physicalExamRecordDetailMysqlPo);



        /* 插入到 Message 表 */
        MessageMysqlPo messagePo = new MessageMysqlPo();
        messagePo.setMessageContent("UPDATE-" + id);
        messagePo.setExchange("physical_exam_record_detail_es_ex");
        messagePo.setRoutingKey("physical.exam.record.detail.es");
        messagePo.setStatus(MessageMysqlPo.NOT_SEND);
        messageMysqlPoDao.insertSelective(messagePo);

        MessageMysqlPo messageMysqlPo = new MessageMysqlPo();
        messageMysqlPo.setMessageContent("DELETE-" + id);
        messageMysqlPo.setExchange("physical_exam_record_detail_redis_cache_ex");
        messageMysqlPo.setRoutingKey("physical.exam.record.detail.redis.cache");
        messageMysqlPo.setStatus(MessageMysqlPo.NOT_SEND);
        messageMysqlPoDao.insertSelective(messageMysqlPo);


        PhysicalExamRecordDetailMysqlPoExample physicalExamRecorDetaildMysqlPoExample = new PhysicalExamRecordDetailMysqlPoExample();
        physicalExamRecorDetaildMysqlPoExample.createCriteria().andRecordidEqualTo(physicalExamRecordDetailVo.getRecordid()).andStatusEqualTo(PhysicalExamRecordDetailVo.STATUS_NOTEXAM);
        List<PhysicalExamRecordDetailMysqlPo> physicalExamRecordDetailMysqlPos = physicalExamRecordDetailMysqlPoDao.selectByExample(physicalExamRecorDetaildMysqlPoExample);
        if (physicalExamRecordDetailMysqlPos.size() == 1) {
            PhysicalExamRecordMysqlPo physicalExamRecordMysqlPo = physicalExamRecordMysqlPoDao.selectByPrimaryKey(physicalExamRecordDetailVo.getRecordid());
            physicalExamRecordMysqlPo.setStatus(PhysicalExamRecordVo.STATUS_FINISH);
            MessageMysqlPo msgPo = new MessageMysqlPo();
            msgPo.setMessageContent("DELETE-" + id);
            msgPo.setExchange("physical_exam_record_redis_cache_ex");
            msgPo.setRoutingKey("physical.exam.record.redis.cache");
            msgPo.setStatus(MessageMysqlPo.NOT_SEND);
            messageMysqlPoDao.insertSelective(msgPo);

            msgPo = new MessageMysqlPo();
            msgPo.setMessageContent("DELETE-" + id);
            msgPo.setExchange("physical_exam_record_es_ex");
            msgPo.setRoutingKey("physical.exam.record.es");
            msgPo.setStatus(MessageMysqlPo.NOT_SEND);
            messageMysqlPoDao.insertSelective(msgPo);
        }
    }
}
