package com.example.physicalexamservice.adapter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamRecordDetailVo;
import com.example.physicalexamservice.outlet.dao.es.PhysicalExamRecordDetailEsPoDao;
import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamRecordDetailEsPo;
import com.example.physicalexamservice.outlet.dao.mysql.PhysicalExamRecordDetailMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamRecordDetailMysqlPo;
import com.example.physicalexamservice.outlet.dao.redis.PhysicalExamRecordDetailRedisPoDao;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamRecordDetailRedisPo;
import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;
import com.example.physicalexamservice.util.converter.PhysicalExamRecordDetailRedisPoConverter;
import com.example.physicalexamservice.util.converter.PhysicalExamRecordDetailVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    public PhysicalExamRecordDetailDaoAdapter(PhysicalExamRecordDetailMysqlPoDao physicalExamRecordDetailMysqlPoDao, PhysicalExamRecordDetailEsPoDao physicalExamRecordDetailEsPoDao, PhysicalExamRecordDetailRedisPoDao physicalExamRecordDetailRedisPoDao, PhysicalExamRecordDetailVoConverter physicalExamRecordDetailVoConverter, PhysicalExamRecordDetailRedisPoConverter physicalExamRecordDetailRedisPoConverter) {
        this.physicalExamRecordDetailMysqlPoDao = physicalExamRecordDetailMysqlPoDao;
        this.physicalExamRecordDetailEsPoDao = physicalExamRecordDetailEsPoDao;
        this.physicalExamRecordDetailRedisPoDao = physicalExamRecordDetailRedisPoDao;
        this.physicalExamRecordDetailVoConverter = physicalExamRecordDetailVoConverter;
        this.physicalExamRecordDetailRedisPoConverter = physicalExamRecordDetailRedisPoConverter;
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
            /* 给状态赋值 */
            physicalExamRecordDetailMysqlPo.setStatus(status);
            i.setStatus(status);
            physicalExamRecordDetailMysqlPo.setRecordid(recordId);
            physicalExamRecordDetailMysqlPo.setPrice(i.getPrice());
            physicalExamRecordDetailMysqlPo.setTypeid(i.getTypeid());
            /* 调用方法添加 */
            physicalExamRecordDetailMysqlPoDao.insert(physicalExamRecordDetailMysqlPo);
            /* 储存主键 */
            i.setId(physicalExamRecordDetailMysqlPo.getId());
        });
    }


    /**
     * 根据 no 查询
     *
     * @param recordId
     * @return
     */
    public List<PhysicalExamRecordDetailVo> queryListByRecordId(Long recordId) {
        /* 声明 */
        List<PhysicalExamRecordDetailVo> physicalExamRecordDetailVoList = new ArrayList<>();
        try {
            /* 先查 Redis 有无 */
            List<PhysicalExamRecordDetailRedisPo> physicalExamRecordDetailRedisPoList = physicalExamRecordDetailRedisPoDao.findAllByRecordidEquals(recordId);
            /* 判断是否为空,空则抛异常 */
            if (physicalExamRecordDetailRedisPoList.isEmpty()) {
                throw new NullPointerException();
            }
            /* 转换Vo */
            physicalExamRecordDetailVoList = physicalExamRecordDetailVoConverter.convert(physicalExamRecordDetailRedisPoList);
        } catch (NullPointerException e) {
            /* 直接往 Es 查 */
            List<PhysicalExamRecordDetailEsPo> physicalExamRecordDetailEsPoList = physicalExamRecordDetailEsPoDao.findByRecordidEquals(recordId);
            /* 转换Vo */
            physicalExamRecordDetailVoList = physicalExamRecordDetailVoConverter.convert(physicalExamRecordDetailEsPoList);
            /* 转换 RedisPo */
            List<PhysicalExamRecordDetailRedisPo> physicalExamRecordDetailRedisPoList = physicalExamRecordDetailRedisPoConverter.convert(physicalExamRecordDetailEsPoList);
            /* 存入 Redis */
            physicalExamRecordDetailRedisPoDao.saveAll(physicalExamRecordDetailRedisPoList);
        }

        /* 返回 */
        return physicalExamRecordDetailVoList;
    }
}
