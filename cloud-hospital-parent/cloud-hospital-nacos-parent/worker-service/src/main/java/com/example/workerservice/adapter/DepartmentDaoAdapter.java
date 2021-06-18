package com.example.workerservice.adapter;

import com.example.workerservice.inlet.web.vo.DepartmentVo;
import com.example.workerservice.outlet.dao.mysql.DepartmentPoDao;
import com.example.workerservice.outlet.dao.mysql.po.DepartmentPo;
import com.example.workerservice.outlet.dao.mysql.po.DepartmentPoExample;
import com.example.workerservice.outlet.dao.redis.DepartmentRedisPoDao;
import com.example.workerservice.outlet.dao.redis.po.DepartmentRedisPo;
import com.example.workerservice.util.converter.DepartmentRedisPoConverter;
import com.example.workerservice.util.converter.DepartmentVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器类 - 适配DepartmentDao
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Component
@Slf4j
public class DepartmentDaoAdapter {

    /* 构造注入 - BEGIN */
    private final DepartmentPoDao departmentPoDao;

    private final DepartmentRedisPoDao departmentRedisPoDao;

    private final DepartmentVoConverter departmentVoConverter;

    private final DepartmentRedisPoConverter departmentRedisPoConverter;

    public DepartmentDaoAdapter(DepartmentPoDao departmentPoDao, DepartmentRedisPoDao departmentRedisPoDao, DepartmentVoConverter departmentVoConverter, DepartmentRedisPoConverter departmentRedisPoConverter) {
        this.departmentPoDao = departmentPoDao;
        this.departmentRedisPoDao = departmentRedisPoDao;
        this.departmentVoConverter = departmentVoConverter;
        this.departmentRedisPoConverter = departmentRedisPoConverter;
    }
    /* 构造注入 - END */

    /**
     * 根据 DivisionId 和 Status 查所有
     *
     * @param divisionId Department 所属大分类ID
     * @param status     Department 状态
     * @return
     */
    public List<DepartmentVo> queryAllByDivisionIdAndStatus(Integer divisionId, String status) {
        /* 实例化一个 List<DepartmentVo> */
        List<DepartmentVo> departmentVoList = new ArrayList<>();

        try {
            /* 先判断Redis中有无 */
            List<DepartmentRedisPo> departmentRedisPoList = departmentRedisPoDao.findAllByDivisionidEqualsAndStatusEquals(divisionId, status);
            /* 无的话抛出异常 */
            if (departmentRedisPoList.isEmpty())
                throw new NullPointerException();
            /* 转换 */
            departmentVoList = departmentVoConverter.convert(departmentRedisPoList);
            /* LOG */
            log.debug("从 Redis 查询到 List<DepartmentVo> -> [{}]",departmentVoList);
        } catch (NullPointerException e) {
            /* 捕获异常到 MySQL 中查询 */
            /* 实例化一个departmentPoExample */
            DepartmentPoExample departmentPoExample = new DepartmentPoExample();
            /* 构造条件 */
            departmentPoExample.createCriteria().andStatusEqualTo(status).andDivisionidEqualTo(divisionId);
            /* 调用方法 */
            List<DepartmentPo> departmentPoList = departmentPoDao.selectByExample(departmentPoExample);
            /* 转换为List<DepartmentVo> */
            departmentVoList = departmentVoConverter.convert(departmentPoList);
            /* 转换为List<DepartmentRedisPo> */
            List<DepartmentRedisPo> departmentRedisPoList = departmentRedisPoConverter.convert(departmentPoList);
            /* 存入Redis */
            departmentRedisPoDao.saveAll(departmentRedisPoList);
            /* LOG */
            log.debug("从 MySQL 查询到 List<DepartmentVo> -> [{}]",departmentVoList);
        }
        /* 返回 */
        return departmentVoList;
    }
}
