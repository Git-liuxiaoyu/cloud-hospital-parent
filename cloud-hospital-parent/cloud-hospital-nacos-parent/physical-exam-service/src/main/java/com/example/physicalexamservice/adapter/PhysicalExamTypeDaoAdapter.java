package com.example.physicalexamservice.adapter;

import com.example.physicalexamservice.inlet.web.vo.PhysicalExamTypeTreatVo;
import com.example.physicalexamservice.outlet.dao.mysql.PhysicalExamTypeMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamTypeMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamTypeMysqlPoExample;
import com.example.physicalexamservice.outlet.dao.redis.PhysicalExamTypeRedisPoDao;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamTypeRedisPo;
import com.example.physicalexamservice.outlet.publisher.PhysicalExamTypeRedisCachePublisher;
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

    private final PhysicalExamTypeRedisCachePublisher physicalExamTypeRedisCachePublisher;

    public PhysicalExamTypeDaoAdapter(PhysicalExamTypeMysqlPoDao physicalExamTypeMysqlPoDao, PhysicalExamTypeRedisPoDao physicalExamTypeRedisPoDao, PhysicalExamTypeTreatVoConverter physicalExamTypeTreatVoConverter, PhysicalExamTypeRedisPoConverter physicalExamTypeRedisPoConverter, PhysicalExamTypeRedisCachePublisher physicalExamTypeRedisCachePublisher) {
        this.physicalExamTypeMysqlPoDao = physicalExamTypeMysqlPoDao;
        this.physicalExamTypeRedisPoDao = physicalExamTypeRedisPoDao;
        this.physicalExamTypeTreatVoConverter = physicalExamTypeTreatVoConverter;
        this.physicalExamTypeRedisPoConverter = physicalExamTypeRedisPoConverter;
        this.physicalExamTypeRedisCachePublisher = physicalExamTypeRedisCachePublisher;
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
            /* 实例化 */
            List<Integer> idList = new ArrayList<>();
            /* 存入id */
            physicalExamTypeMysqlPos.forEach(p -> idList.add(p.getId()));
            /* 推送到缓存队列来存入Redis */
            physicalExamTypeRedisCachePublisher.publishPhysicalExamTypeAllUpdateDelete(status);
        }
        /* 返回 */
        return physicalExamTreatVoList;
    }

    /**
     * 添加检查类型方法
     *
     * @param name
     * @param description
     */
    public Integer add(String name, String description, String status) {
        /* 实例化 PhysicalExamTypeMysqlPoExample */
        PhysicalExamTypeMysqlPoExample physicalExamTypeMysqlPoExample = new PhysicalExamTypeMysqlPoExample();
        /* 编写条件 */
        physicalExamTypeMysqlPoExample.createCriteria().andNameEqualTo(name);
        /* 查找 */
        List<PhysicalExamTypeMysqlPo> physicalExamTypeMysqlPoList = physicalExamTypeMysqlPoDao.selectByExample(physicalExamTypeMysqlPoExample);
        /* 判断是否为空集合 */
        if (!physicalExamTypeMysqlPoList.isEmpty()) {
            throw new NullPointerException();
        }
        /* 空集合则进行添加步骤 */
        /* 实例化 */
        PhysicalExamTypeMysqlPo physicalExamTypeMysqlPo = new PhysicalExamTypeMysqlPo();
        /* 赋值 */
        physicalExamTypeMysqlPo.setDescription(description);
        physicalExamTypeMysqlPo.setName(name);
        physicalExamTypeMysqlPo.setStatus(status);
        /* 执行方法 */
        physicalExamTypeMysqlPoDao.insertSelective(physicalExamTypeMysqlPo);
        /* 返回主键ID */
        return physicalExamTypeMysqlPo.getId();
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

    /**
     * 更新检查类型
     *
     * @param id
     * @param name
     * @param description
     */
    public void update(Integer id, String name, String description) {
        /* 先去查是否名字重复 */
        /* 实例化 PhysicalExamTypeMysqlPoExample */
        PhysicalExamTypeMysqlPoExample physicalExamTypeMysqlPoExample = new PhysicalExamTypeMysqlPoExample();
        /* 编写条件 */
        physicalExamTypeMysqlPoExample.createCriteria().andNameEqualTo(name);
        /* 查找 */
        List<PhysicalExamTypeMysqlPo> physicalExamTypeMysqlPoList = physicalExamTypeMysqlPoDao.selectByExample(physicalExamTypeMysqlPoExample);
        /* 判断是否为null */
        if (!physicalExamTypeMysqlPoList.isEmpty()) {
            /* 抛异常 */
            throw new NullPointerException();
        }
        /* 执行修改 */
        /* 实例化 */
        PhysicalExamTypeMysqlPo physicalExamTypeMysqlPo = new PhysicalExamTypeMysqlPo();
        /* 赋值 */
        physicalExamTypeMysqlPo.setName(name);
        physicalExamTypeMysqlPo.setDescription(description);
        physicalExamTypeMysqlPo.setId(id);
        /* 修改 */
        physicalExamTypeMysqlPoDao.updateByPrimaryKeySelective(physicalExamTypeMysqlPo);
    }
}
