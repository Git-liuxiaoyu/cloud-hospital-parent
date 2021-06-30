package com.example.workerservice.adapter;

import com.example.workerservice.inlet.web.vo.DivisionVo;
import com.example.workerservice.outlet.dao.es.DivisionEsPoDao;
import com.example.workerservice.outlet.dao.es.po.DivisionEsPo;
import com.example.workerservice.outlet.dao.mysql.DivisionPoDao;
import com.example.workerservice.outlet.dao.mysql.MessagePoDao;
import com.example.workerservice.outlet.dao.mysql.po.DivisionPo;
import com.example.workerservice.outlet.dao.mysql.po.MessagePo;
import com.example.workerservice.outlet.dao.redis.DivisionRedisPoDao;
import com.example.workerservice.outlet.dao.redis.po.DivisionRedisPo;
import com.example.workerservice.service.command.division.queryall.QueryAllDivisionCommand;
import com.example.workerservice.util.converter.DivisionVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器类 - 适配 - Division
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/17
 */
@Component
@Slf4j
public class DivisionDaoAdapter {

    /* 构造注入 - 开始 */
    private final DivisionPoDao divisionPoDao;

    private final DivisionRedisPoDao divisionRedisPoDao;

    private final DivisionEsPoDao divisionEsPoDao;

    private final MessagePoDao messagePoDao;

    private final DivisionVoConverter divisionVoConverter;

    public DivisionDaoAdapter(DivisionPoDao divisionPoDao, DivisionRedisPoDao divisionRedisPoDao, DivisionEsPoDao divisionEsPoDao, MessagePoDao messagePoDao, DivisionVoConverter divisionVoConverter) {
        this.divisionPoDao = divisionPoDao;
        this.divisionRedisPoDao = divisionRedisPoDao;
        this.divisionEsPoDao = divisionEsPoDao;
        this.messagePoDao = messagePoDao;
        this.divisionVoConverter = divisionVoConverter;
    }
    /* 构造注入 - 结束 */

    /**
     * 根据状态查所有
     *
     * @param status
     * @return
     */
    public List<QueryAllDivisionCommand.DivisionVo> queryAllByStatus(String status) {
        /* 直接 Es 查 */
        List<DivisionEsPo> divisionEsPoList = divisionEsPoDao.findByStatusEquals(status);
        /* 转为Vo返回 */
        return convert(divisionEsPoList);
    }

    /**
     * List<DivisionEsPo> -> List<QueryAllDivisionCommand.DivisionVo>
     *
     * @param divisionEsPoList
     * @return
     */
    private List<QueryAllDivisionCommand.DivisionVo> convert(List<DivisionEsPo> divisionEsPoList) {
        /* 实例化 List<QueryAllDivisionCommand.DivisionVo> */
        List<QueryAllDivisionCommand.DivisionVo> divisionVoList = new ArrayList<>();
        /* 循环赋值 */
        divisionEsPoList.forEach(divisionEsPo -> divisionVoList.add(convert(divisionEsPo)));
        /* 返回 */
        return divisionVoList;
    }

    /**
     * DivisionEsPo -> QueryAllDivisionCommand.DivisionVo
     *
     * @param divisionEsPo
     * @return
     */
    private QueryAllDivisionCommand.DivisionVo convert(DivisionEsPo divisionEsPo) {
        /* 实例化 QueryAllDivisionCommand.DivisionVo */
        QueryAllDivisionCommand.DivisionVo divisionVo = new QueryAllDivisionCommand.DivisionVo();
        /* 赋值 */
        BeanUtils.copyProperties(divisionEsPo, divisionVo);
        /* 返回 */
        return divisionVo;
    }


    /**
     * 添加进 MySQL
     *
     * @param name
     * @param status
     */
    public Integer add(String name, String description, String status) {
        /* 实例化 */
        DivisionPo divisionPo = new DivisionPo();
        /* 赋值 */
        divisionPo.setDescription(description);
        divisionPo.setName(name);
        divisionPo.setStatus(status);

        /* 调用方法 */
        divisionPoDao.insert(divisionPo);

        /* 返回主键 */
        return divisionPo.getId();
    }

    /**
     * 修改方法
     *
     * @param id
     * @param name
     * @param description
     * @param status
     */
    public void update(Integer id, String name, String description, String status) {
        /* 实力化 */
        DivisionPo divisionPo = new DivisionPo();
        /* 赋值 */
        divisionPo.setId(id);
        divisionPo.setStatus(status);
        divisionPo.setName(name);
        divisionPo.setDescription(description);
        /* 修改 */
        divisionPoDao.updateByPrimaryKeySelective(divisionPo);
    }

    /**
     * 根据ID查询
     *
     * @param divisionId
     * @return
     */
    public DivisionVo queryById(Integer divisionId) {
        try {
            /* 先从 Redis 查 */
            DivisionRedisPo divisionRedisPo = divisionRedisPoDao.findById(divisionId).orElseThrow(NullPointerException::new);
            /* Redis -> Vo 并返回 */
            return divisionVoConverter.convert(divisionRedisPo);
            /* Redis 查不到抛异常 NullPointerException */
        } catch (NullPointerException e) {
            try {
                /* Redis 查不到去 Es 查 */
                DivisionEsPo divisionEsPo = divisionEsPoDao.findById(divisionId).orElseThrow(NullPointerException::new);
                /* Es 查到 -> 消息 RedisPo 存入 Redis (存入消息表) */
                /* 实例化 MessagePo */
                MessagePo messagePo = new MessagePo();
                messagePo.setStatus(MessagePo.NOT_SEND);
                messagePo.setRoutingKey("division.redis.cache");
                messagePo.setExchange("division_redis_cache_ex");
                messagePo.setMessageContent("UPDATE-" + divisionId);
                /* 存入 MySQL */
                messagePoDao.insertSelective(messagePo);
                /* Es 查到 -> 转 Vo */
                return divisionVoConverter.convert(divisionEsPo);
            } catch (NullPointerException ne) {
                /* Es 查不到去 MySQL 查 */
                DivisionPo divisionPo = divisionPoDao.selectByPrimaryKey(divisionId);
                /* 判断是否未null(是否查到) */
                if (divisionId == null) {
                    throw new NullPointerException();
                }
                /* MySQL 查到 -> 消息 RedisPo 存入 Redis  */
                /* 实例化 MessagePo */
                MessagePo messagePo = new MessagePo();
                messagePo.setStatus(MessagePo.NOT_SEND);
                messagePo.setRoutingKey("division.redis.cache");
                messagePo.setExchange("division_redis_cache_ex");
                messagePo.setMessageContent("UPDATE-" + divisionId);
                /* 存入 MySQL */
                messagePoDao.insertSelective(messagePo);
                /* MySQL 查到 -> 消息 EsPo 存入 Es  */
                messagePo.setStatus(MessagePo.NOT_SEND);
                messagePo.setRoutingKey("division.es");
                messagePo.setExchange("division_es_ex");
                messagePo.setMessageContent("UPDATE-" + divisionId);
                /* 存入 MySQL */
                messagePoDao.insertSelective(messagePo);
                /* MySQL 查到 -> 转 Vo */
                return divisionVoConverter.convert(divisionPo);
            }


        }


    }
}
