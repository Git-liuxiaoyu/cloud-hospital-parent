package com.example.workerservice.adapter;

import com.example.workerservice.inlet.web.vo.DivisionVo;
import com.example.workerservice.outlet.dao.mysql.DivisionPoDao;
import com.example.workerservice.outlet.dao.mysql.po.DivisionPo;
import com.example.workerservice.outlet.dao.mysql.po.DivisionPoExample;
import com.example.workerservice.outlet.dao.redis.DivisionRedisPoDao;
import com.example.workerservice.outlet.dao.redis.po.DivisionRedisPo;
import com.example.workerservice.util.converter.DivisionRedisPoConverter;
import com.example.workerservice.util.converter.DivisionVoConverter;
import lombok.extern.slf4j.Slf4j;
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

    private final DivisionRedisPoConverter divisionRedisPoConverter;

    private final DivisionVoConverter divisionVoConverter;

    public DivisionDaoAdapter(DivisionPoDao divisionPoDao, DivisionRedisPoDao divisionRedisPoDao, DivisionVoConverter divisionVoConverter, DivisionRedisPoConverter divisionRedisPoConverter) {
        this.divisionPoDao = divisionPoDao;
        this.divisionRedisPoDao = divisionRedisPoDao;
        this.divisionVoConverter = divisionVoConverter;
        this.divisionRedisPoConverter = divisionRedisPoConverter;
    }
    /* 构造注入 - 结束 */

    /**
     * 根据状态查所有
     *
     * @param status
     * @return
     */
    public List<DivisionVo> queryAllByStatus(String status) {
        /* 实例化一个List<DivisionVo>  */
        List<DivisionVo> divisionVoList = new ArrayList<>();

        try {
            /* 先查 Redis 中有没有 */
            List<DivisionRedisPo> divisionRedisPoList = divisionRedisPoDao.findAllByStatusEquals(status);
            /* 没有会抛出异常 NullPointerException */
            if (divisionRedisPoList.isEmpty())
                throw new NullPointerException();
            /* 转换 */
            divisionVoList = divisionVoConverter.convert(divisionRedisPoList);
            /* LOG */
            log.debug("从 Redis 查询到 List<DivisionVo> -> [{}]",divisionVoList);
        } catch (NullPointerException e) {
            /* 捕获异常 NullPointerException , 前往 MySQL 查询 */
            /* 实例化DivisionPoExample */
            DivisionPoExample divisionPoExample = new DivisionPoExample();
            divisionPoExample.createCriteria().andStatusEqualTo(status);
            /* 查询获得对象 */
            List<DivisionPo> divisionPoList = divisionPoDao.selectByExample(divisionPoExample);
            /* 转换 */
            divisionVoList = divisionVoConverter.convert(divisionPoList);
            /* 转换 */
            List<DivisionRedisPo> divisionRedisPoList = divisionRedisPoConverter.convert(divisionPoList);
            /* 存入 Redis */
            divisionRedisPoDao.saveAll(divisionRedisPoList);
            /* LOG */
            log.debug("从 MySQL 查询到 List<DivisionVo> -> [{}]",divisionVoList);
        }
        /* 返回值 */
        return divisionVoList;
    }
}
