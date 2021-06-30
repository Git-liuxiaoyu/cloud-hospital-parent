package com.example.physicalexamservice.adapter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTreatVo;
import com.example.physicalexamservice.outlet.dao.es.PhysicalExamEsPoDao;
import com.example.physicalexamservice.outlet.dao.es.po.PhysicalExamEsPo;
import com.example.physicalexamservice.outlet.dao.mysql.PhysicalExamMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamMysqlPo;
import com.example.physicalexamservice.outlet.dao.redis.PhysicalExamRedisPoDao;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamRedisPo;
import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;
import com.example.physicalexamservice.util.converter.PhysicalExamRedisPoConverter;
import com.example.physicalexamservice.util.converter.PhysicalExamTreatVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器类 - 适配 - PhysicalExamDao
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class PhysicalExamDaoAdapter {

    /* 构造注入 - 开始 */
    private final PhysicalExamMysqlPoDao physicalExamMysqlPoDao;

    private final PhysicalExamRedisPoDao physicalExamRedisPoDao;

    private final PhysicalExamEsPoDao physicalExamEsPoDao;

    private final PhysicalExamTreatVoConverter physicalExamTreatVoConverter;

    private final PhysicalExamRedisPoConverter physicalExamRedisPoConverter;

    public PhysicalExamDaoAdapter(PhysicalExamMysqlPoDao physicalExamMysqlPoDao, PhysicalExamRedisPoDao physicalExamRedisPoDao, PhysicalExamTreatVoConverter physicalExamTreatVoConverter, PhysicalExamRedisPoConverter physicalExamRedisPoConverter, PhysicalExamEsPoDao physicalExamEsPoDao) {
        this.physicalExamMysqlPoDao = physicalExamMysqlPoDao;
        this.physicalExamRedisPoDao = physicalExamRedisPoDao;
        this.physicalExamTreatVoConverter = physicalExamTreatVoConverter;
        this.physicalExamRedisPoConverter = physicalExamRedisPoConverter;
        this.physicalExamEsPoDao = physicalExamEsPoDao;
    }
    /* 构造注入 - 结束 */

    /**
     * 查询所有
     *
     * @return
     */
    public List<PhysicalExamTreatVo> queryAllForTreat(String status) {
        /* 直接到 Es 里面查 */
        List<PhysicalExamEsPo> physicalExamEsPoList = physicalExamEsPoDao.findAllByStatusEquals(status);

        /* 实例化 List<PhysicalExamTreatVo> */
        List<PhysicalExamTreatVo> physicalExamTreatVoList = new ArrayList<>();
        /* 循环添加 */
        physicalExamEsPoList.forEach(physicalExamEsPo -> {
            physicalExamTreatVoList.add(physicalExamTreatVoConverter.convert(physicalExamEsPo));
        });
        /* 返回 */
        return physicalExamTreatVoList;
    }

    /**
     * 根据状态和类型查
     *
     * @param typeId
     * @param status
     * @return
     */
    public List<PhysicalExamTreatVo> queryListByTypeId(Integer typeId, String status) {
        /* 直接 Es 查 */
        List<PhysicalExamEsPo> physicalExamEsPoList = physicalExamEsPoDao.findAllByStatusEqualsAndTypeidEquals(status, typeId);
        /* 实例化 */
        List<PhysicalExamTreatVo> physicalExamTreatVoList = new ArrayList<>();
        /* 循环转换 */
        physicalExamEsPoList.forEach(physicalExamEsPo -> {
            physicalExamTreatVoList.add(physicalExamTreatVoConverter.convert(physicalExamEsPo));
        });
        /* 返回 */
        return physicalExamTreatVoList;
    }

    /**
     * 设置价格
     *
     * @param innerAddPhysicalExamRecordDetailPoList
     */
    public void setListPriceAndUpdateStockAndExamInfo(List<AddPhysicalExamRecordCommand.InnerAddPhysicalExamRecordDetailPo> innerAddPhysicalExamRecordDetailPoList) {

        /* 遍历赋值 */
        innerAddPhysicalExamRecordDetailPoList.forEach(i -> {
            /*  MySQL中查 */
            PhysicalExamMysqlPo physicalExamMysqlPo = physicalExamMysqlPoDao.selectByPrimaryKey(i.getExamid());
            /* 判断为 null 时 , return */
            if (physicalExamMysqlPo == null)
                return;
            /* 赋值 */
            log.debug("库存 {}", physicalExamMysqlPo.getLeftstock());
            i.setExamName(physicalExamMysqlPo.getName());
            i.setPrice(physicalExamMysqlPo.getPrice());
            physicalExamMysqlPo.setLeftstock(physicalExamMysqlPo.getLeftstock() - 1);
            log.debug("库存 {}", physicalExamMysqlPo.getLeftstock());
            /* 存入 MySQL */
            physicalExamMysqlPoDao.updateByPrimaryKeySelective(physicalExamMysqlPo);
            /* 转RedisPo 存入Redis */
            PhysicalExamRedisPo physicalExamRedisPo = physicalExamRedisPoConverter.convert(physicalExamMysqlPo);
            physicalExamRedisPoDao.save(physicalExamRedisPo);
        });
    }
}
