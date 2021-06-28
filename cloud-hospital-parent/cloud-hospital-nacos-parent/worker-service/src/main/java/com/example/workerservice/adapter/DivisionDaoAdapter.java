package com.example.workerservice.adapter;

import com.example.workerservice.outlet.dao.es.DivisionEsPoDao;
import com.example.workerservice.outlet.dao.es.po.DivisionEsPo;
import com.example.workerservice.outlet.dao.mysql.DivisionPoDao;
import com.example.workerservice.outlet.dao.redis.DivisionRedisPoDao;
import com.example.workerservice.service.command.division.queryall.QueryAllDivisionCommand;
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

    public DivisionDaoAdapter(DivisionPoDao divisionPoDao, DivisionRedisPoDao divisionRedisPoDao, DivisionEsPoDao divisionEsPoDao) {
        this.divisionPoDao = divisionPoDao;
        this.divisionRedisPoDao = divisionRedisPoDao;
        this.divisionEsPoDao = divisionEsPoDao;
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
}
