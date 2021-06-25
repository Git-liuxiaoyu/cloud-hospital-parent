package com.example.physicalexamservice.inlet.subscriber;

import com.example.physicalexamservice.outlet.dao.mysql.PhysicalExamTypeMysqlPoDao;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamTypeMysqlPo;
import com.example.physicalexamservice.outlet.dao.mysql.po.PhysicalExamTypeMysqlPoExample;
import com.example.physicalexamservice.outlet.dao.redis.PhysicalExamTypeRedisPoDao;
import com.example.physicalexamservice.outlet.dao.redis.po.PhysicalExamTypeRedisPo;
import com.example.physicalexamservice.util.converter.PhysicalExamTypeRedisPoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 订阅者类 - PhysicalExamTypeCache
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/24
 */
@Component
@Slf4j
public class PhysicalExamTypeRedisCacheSubscriber {

    /* 构造注入 - 开始 */
    private final PhysicalExamTypeMysqlPoDao physicalExamTypeMysqlPoDao;

    private final PhysicalExamTypeRedisPoDao physicalExamTypeRedisPoDao;

    private final PhysicalExamTypeRedisPoConverter physicalExamTypeRedisPoConverter;

    public PhysicalExamTypeRedisCacheSubscriber(PhysicalExamTypeMysqlPoDao physicalExamTypeMysqlPoDao, PhysicalExamTypeRedisPoDao physicalExamTypeRedisPoDao, PhysicalExamTypeRedisPoConverter physicalExamTypeRedisPoConverter) {
        this.physicalExamTypeMysqlPoDao = physicalExamTypeMysqlPoDao;
        this.physicalExamTypeRedisPoDao = physicalExamTypeRedisPoDao;
        this.physicalExamTypeRedisPoConverter = physicalExamTypeRedisPoConverter;
    }
    /* 构造注入 - 结束 */

    /**
     * 订阅 physical_exam_type_cache_q
     *
     * @param message
     */
    @RabbitHandler
    public void subscribePhysicalExamTypeCacheQueue(Message message) {
        /* 获得消息主体并分割为数组 */
        String[] judgeArr = new String(message.getBody()).split("-");
        /* 判断是何命令 */
        if (judgeArr[0].equals("delete")) {
            handlePhysicalExamTypeRedisDelete(Integer.parseInt(judgeArr[1]));
        } else if (judgeArr[0].equals("update")) {
            handlePhysicalExamTypeRedisUpdateDelete(Integer.parseInt(judgeArr[1]));
        } else if (judgeArr[0].equals("updateAll")) {
            handlePhysicalExamTypeAllRedisUpdateDelete(judgeArr[1]);
        } else if (judgeArr[0].equals("deleteAll")) {
            handlePhysicalExamTypeAllRedisDelete();
        } else {
            log.info("无匹配处理方法 {} -> {}", judgeArr[0], judgeArr[1]);
        }
    }

    private void handlePhysicalExamTypeAllRedisDelete() {
        /* 清空所有 */
        physicalExamTypeRedisPoDao.deleteAll();
    }

    /**
     * 处理 PhysicalExamTypeAll UpdateDelete
     *
     * @param status
     */
    private void handlePhysicalExamTypeAllRedisUpdateDelete(String status) {
        /* 从数据库读取 */
        /* 实例化 PhysicalExamTypeMysqlPoExample */
        PhysicalExamTypeMysqlPoExample physicalExamTypeMysqlPoExample = new PhysicalExamTypeMysqlPoExample();
        /* 编写条件 */
        physicalExamTypeMysqlPoExample.createCriteria().andStatusEqualTo(status);
        /* 执行方法 */
        List<PhysicalExamTypeMysqlPo> physicalExamTypeMysqlPoList = physicalExamTypeMysqlPoDao.selectByExample(physicalExamTypeMysqlPoExample);
        /* 转换为 RedisPo */
        List<PhysicalExamTypeRedisPo> physicalExamTypeRedisPoList = physicalExamTypeRedisPoConverter.convert(physicalExamTypeMysqlPoList);
        /* 存入 Redis */
        physicalExamTypeRedisPoDao.saveAll(physicalExamTypeRedisPoList);
        /* LOG */
        log.info("存入 Redis 的检查类型有 [{}]", physicalExamTypeRedisPoList);
    }

    /**
     * 处理 PhysicalExamType UpdateDelete
     *
     * @param id
     */
    private void handlePhysicalExamTypeRedisUpdateDelete(Integer id) {
        try {
            /* 1.先查 */
            PhysicalExamTypeMysqlPo physicalExamTypeMysqlPo = physicalExamTypeMysqlPoDao.selectByPrimaryKey(id);
            /* 判断是否为 null */
            if (physicalExamTypeMysqlPo == null) {
                throw new NullPointerException();
            }
            /* LOG */
            log.info("找到检查类型 [{}]", physicalExamTypeMysqlPo);
            /* 2.转为 RedisPo 并存入 */
            physicalExamTypeRedisPoDao.save(physicalExamTypeRedisPoConverter.convert(physicalExamTypeMysqlPo));
        } catch (NullPointerException e) {
            log.info("没有在 MySQL 查询到 [{}] 检查类型", id);
        }
    }

    /**
     * 处理 PhysicalExamType Delete
     *
     * @param id
     */
    private void handlePhysicalExamTypeRedisDelete(Integer id) {
        /* 根据 ID 在 Redis 删除 */
        physicalExamTypeRedisPoDao.deleteById(id);
    }

}
