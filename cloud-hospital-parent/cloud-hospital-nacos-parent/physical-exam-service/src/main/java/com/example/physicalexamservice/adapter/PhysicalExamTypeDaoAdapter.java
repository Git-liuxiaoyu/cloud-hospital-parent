package com.example.physicalexamservice.adapter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTypeTreatVo;
import com.example.physicalexamservice.outlet.dao.mysql.PhysicalExamTypeMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamTypeMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamTypeMysqlPoExample;
import com.example.physicalexamservice.outlet.dao.redis.PhysicalExamTypeRedisPoDao;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamTypeRedisPo;
import com.example.physicalexamservice.service.command.physicalexamrecord.add.AddPhysicalExamRecordCommand;
import com.example.physicalexamservice.util.converter.PhysicalExamTypeRedisPoConverter;
import com.example.physicalexamservice.util.converter.PhysicalExamTypeTreatVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器类 - 适配 - PhysicalExamTypeDao
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Component
@Slf4j
public class PhysicalExamTypeDaoAdapter {

    /* 构造注入 - 开始 */
    private final PhysicalExamTypeMysqlPoDao physicalExamTypeMysqlPoDao;

    private final PhysicalExamTypeRedisPoDao physicalExamTypeRedisPoDao;

    private final PhysicalExamTypeTreatVoConverter physicalExamTypeTreatVoConverter;

    private final PhysicalExamTypeRedisPoConverter physicalExamTypeRedisPoConverter;

    public PhysicalExamTypeDaoAdapter(PhysicalExamTypeMysqlPoDao physicalExamTypeMysqlPoDao, PhysicalExamTypeRedisPoDao physicalExamTypeRedisPoDao, PhysicalExamTypeTreatVoConverter physicalExamTypeTreatVoConverter, PhysicalExamTypeRedisPoConverter physicalExamTypeRedisPoConverter) {
        this.physicalExamTypeMysqlPoDao = physicalExamTypeMysqlPoDao;
        this.physicalExamTypeRedisPoDao = physicalExamTypeRedisPoDao;
        this.physicalExamTypeTreatVoConverter = physicalExamTypeTreatVoConverter;
        this.physicalExamTypeRedisPoConverter = physicalExamTypeRedisPoConverter;
    }
    /* 构造注入 - 结束 */

    /**
     * 根据状态查询所有
     *
     * @param status
     * @return
     */
    public List<PhysicalExamTypeTreatVo> queryAll(String status) {
        /* 声明 List<PhysicalExamTreatVo> */
        List<PhysicalExamTypeTreatVo> physicalExamTreatVoList = new ArrayList<>();
        try {
            /* 先判断 Redis 是否存在 */
            List<PhysicalExamTypeRedisPo> physicalExamTypeRedisPoList = physicalExamTypeRedisPoDao.findAllByStatusEquals(status);
            /* 判断是否为空 */
            if (physicalExamTypeRedisPoList.isEmpty())
                /* 为空抛异常 NullPointerException */
                throw new NullPointerException();
            /* 不为空转化 */
            physicalExamTreatVoList = physicalExamTypeTreatVoConverter.convert(physicalExamTypeRedisPoList);
        } catch (NullPointerException e) {
            /* 捕获 NullPointerException , 前往 MYSQL 查询*/
            /* 实例化 PhysicalExamTypeMysqlPoExample */
            PhysicalExamTypeMysqlPoExample physicalExamTypeMysqlPoExample = new PhysicalExamTypeMysqlPoExample();
            /* 编写条件 */
            physicalExamTypeMysqlPoExample.createCriteria().andStatusEqualTo(status);
            /* 调用方法 */
            List<PhysicalExamTypeMysqlPo> physicalExamTypeMysqlPos = physicalExamTypeMysqlPoDao.selectByExample(physicalExamTypeMysqlPoExample);
            /* 转换Vo */
            physicalExamTreatVoList = physicalExamTypeTreatVoConverter.convert(physicalExamTypeMysqlPos);
            /* 转换 RedisPo 并存入 Redis */
            physicalExamTypeRedisPoDao.saveAll(physicalExamTypeRedisPoConverter.convert(physicalExamTypeMysqlPos));
        }
        /* 返回 */
        return physicalExamTreatVoList;
    }

    /**
     * 给集合补充类型信息
     *
     * @param innerAddPhysicalExamRecordDetailPoList
     */
    public void setListTypeInfo(List<AddPhysicalExamRecordCommand.InnerAddPhysicalExamRecordDetailPo> innerAddPhysicalExamRecordDetailPoList) {
        /* 循环集合 */
        innerAddPhysicalExamRecordDetailPoList.forEach(i -> {
            try {
                /* 先判断 Redis 中是否存在 */
                PhysicalExamTypeRedisPo physicalExamTypeRedisPo = physicalExamTypeRedisPoDao.findById(i.getTypeid()).orElseThrow(NullPointerException::new);
                /* 存在则赋值 */
                i.setTypeName(physicalExamTypeRedisPo.getName());
            } catch (NullPointerException e) {
                /* 捕获异常 NullPointerException */
                /* 去 MySQL 查 */
                PhysicalExamTypeMysqlPo physicalExamTypeMysqlPo = physicalExamTypeMysqlPoDao.selectByPrimaryKey(i.getTypeid());
                /* 判断是否为 null */
                if (physicalExamTypeMysqlPo == null) {
                    return;
                }
                /* 赋值 */
                i.setTypeName(physicalExamTypeMysqlPo.getName());
                /* 转换为 RedisPo 并存入 Redis */
                physicalExamTypeRedisPoDao.save(physicalExamTypeRedisPoConverter.convert(physicalExamTypeMysqlPo));
            }
        });


    }
}
