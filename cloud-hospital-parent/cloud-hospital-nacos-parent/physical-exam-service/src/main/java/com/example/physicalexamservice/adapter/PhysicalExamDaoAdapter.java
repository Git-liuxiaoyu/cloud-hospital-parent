package com.example.physicalexamservice.adapter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTreatVo;
import com.example.physicalexamservice.outlet.dao.mysql.PhysicalExamMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamMysqlPoExample;
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

    private final PhysicalExamTreatVoConverter physicalExamTreatVoConverter;

    private final PhysicalExamRedisPoConverter physicalExamRedisPoConverter;

    public PhysicalExamDaoAdapter(PhysicalExamMysqlPoDao physicalExamMysqlPoDao, PhysicalExamRedisPoDao physicalExamRedisPoDao, PhysicalExamTreatVoConverter physicalExamTreatVoConverter, PhysicalExamRedisPoConverter physicalExamRedisPoConverter) {
        this.physicalExamMysqlPoDao = physicalExamMysqlPoDao;
        this.physicalExamRedisPoDao = physicalExamRedisPoDao;
        this.physicalExamTreatVoConverter = physicalExamTreatVoConverter;
        this.physicalExamRedisPoConverter = physicalExamRedisPoConverter;
    }
    /* 构造注入 - 结束 */

    /**
     * 查询所有
     *
     * @return
     */
    public List<PhysicalExamTreatVo> queryAllForTreat(String status) {
        /* 声明 */
        List<PhysicalExamTreatVo> physicalExamTreatVoList = new ArrayList<>();
        try {
            /* 先看Redis中有没有 */
            List<PhysicalExamRedisPo> physicalExamRedisPoList = physicalExamRedisPoDao.findAllByStatusEquals(status);
            /* 判断有无,无抛异常 NullPointerException */
            if (physicalExamRedisPoList.isEmpty())
                throw new NullPointerException();
            /* 有则转换 */
            physicalExamTreatVoList = physicalExamTreatVoConverter.convert(physicalExamRedisPoList);
        } catch (NullPointerException e) {
            /* 实例化 */
            PhysicalExamMysqlPoExample physicalExamMysqlPoExample = new PhysicalExamMysqlPoExample();
            /* 编写条件 */
            physicalExamMysqlPoExample.createCriteria().andStatusEqualTo(status);
            /* 调用方法 */
            List<PhysicalExamMysqlPo> physicalExamMysqlPoList = physicalExamMysqlPoDao.selectByExample(physicalExamMysqlPoExample);
            /* 转换Vo */
            physicalExamTreatVoList = physicalExamTreatVoConverter.convert(physicalExamMysqlPoList);
            /* 转换 RedisPo,并存入 Redis */
            physicalExamRedisPoDao.saveAll(physicalExamRedisPoConverter.convert(physicalExamMysqlPoList));
        }
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
        /* 声明 */
        List<PhysicalExamTreatVo> physicalExamTreatVoList = new ArrayList<>();
        try {
            /* 先看Redis中有没有 */
            List<PhysicalExamRedisPo> physicalExamRedisPoList = physicalExamRedisPoDao.findAllByStatusEqualsAndTypeidEquals(status, typeId);
            /* 判断有无,无抛异常 NullPointerException */
            if (physicalExamRedisPoList.isEmpty())
                throw new NullPointerException();
            /* 有则转换 */
            physicalExamTreatVoList = physicalExamTreatVoConverter.convert(physicalExamRedisPoList);
        } catch (NullPointerException e) {
            /* 实例化 */
            PhysicalExamMysqlPoExample physicalExamMysqlPoExample = new PhysicalExamMysqlPoExample();
            /* 编写条件 */
            physicalExamMysqlPoExample.createCriteria().andStatusEqualTo(status).andTypeidEqualTo(typeId);
            /* 调用方法 */
            List<PhysicalExamMysqlPo> physicalExamMysqlPoList = physicalExamMysqlPoDao.selectByExample(physicalExamMysqlPoExample);
            /* 转换Vo */
            physicalExamTreatVoList = physicalExamTreatVoConverter.convert(physicalExamMysqlPoList);
            /* 转换 RedisPo,并存入 Redis */
            physicalExamRedisPoDao.saveAll(physicalExamRedisPoConverter.convert(physicalExamMysqlPoList));
        }
        /* 返回 */
        return physicalExamTreatVoList;
    }

    /**
     * 设置价格
     *
     * @param innerAddPhysicalExamRecordDetailPoList
     */
    public void setListPrice(List<AddPhysicalExamRecordCommand.InnerAddPhysicalExamRecordDetailPo> innerAddPhysicalExamRecordDetailPoList) {

        /* 遍历赋值 */
        innerAddPhysicalExamRecordDetailPoList.forEach(i -> {
            try {
                /* 先查 Redis 中有无 */
                PhysicalExamRedisPo physicalExamRedisPo = physicalExamRedisPoDao.findById(i.getExamid()).orElseThrow(NullPointerException::new);
                i.setPrice(physicalExamRedisPo.getPrice());
            } catch (NullPointerException e) {
                /* 捕获异常到 MySQL中查 */
                PhysicalExamMysqlPo physicalExamMysqlPo = physicalExamMysqlPoDao.selectByPrimaryKey(i.getExamid());
                /* 判断为 null 时 , return */
                if (physicalExamMysqlPo == null)
                    return;
                /* 赋值 */
                i.setPrice(physicalExamMysqlPo.getPrice());
            }
        });
    }
}
