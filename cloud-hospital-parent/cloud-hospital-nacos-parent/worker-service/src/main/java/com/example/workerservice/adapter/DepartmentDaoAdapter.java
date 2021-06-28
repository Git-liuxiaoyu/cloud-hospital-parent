package com.example.workerservice.adapter;

import com.example.workerservice.outlet.dao.es.DepartmentEsPoDao;
import com.example.workerservice.outlet.dao.es.po.DepartmentEsPo;
import com.example.workerservice.outlet.dao.mysql.DepartmentPoDao;
import com.example.workerservice.outlet.dao.redis.DepartmentRedisPoDao;
import com.example.workerservice.service.command.department.queryallbydivision.QueryAllDepartmentByDivisionIdCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器类 - 适配DepartmentDao
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Slf4j
@Component
public class DepartmentDaoAdapter {

    /* 构造注入 - BEGIN */
    private final DepartmentPoDao departmentPoDao;

    private final DepartmentRedisPoDao departmentRedisPoDao;

    private final DepartmentEsPoDao departmentEsPoDao;

    public DepartmentDaoAdapter(DepartmentPoDao departmentPoDao, DepartmentRedisPoDao departmentRedisPoDao, DepartmentEsPoDao departmentEsPoDao) {
        this.departmentPoDao = departmentPoDao;
        this.departmentRedisPoDao = departmentRedisPoDao;
        this.departmentEsPoDao = departmentEsPoDao;
    }
    /* 构造注入 - END */

    /**
     * 根据 DivisionId 和 Status 查所有
     *
     * @param divisionId Department 所属大分类ID
     * @param status     Department 状态
     * @return
     */
    public List<QueryAllDepartmentByDivisionIdCommand.DepartmentVo> queryAllByDivisionIdAndStatus(Integer divisionId, String status) {
        /* 直接 Es 查询 */
        List<DepartmentEsPo> departmentEsPos = departmentEsPoDao.findAllByStatusEqualsAndDivisionidEquals(status, divisionId);
        /* 直接转换为Vo并返回 */
        return convert(departmentEsPos);
    }

    /**
     * List<QueryAllDepartmentByDivisionIdCommand.DepartmentVo> -> List<DepartmentEsPo>
     *
     * @param departmentEsPoList
     * @return
     */
    private List<QueryAllDepartmentByDivisionIdCommand.DepartmentVo> convert(List<DepartmentEsPo> departmentEsPoList) {
        /* 实例化 List<QueryAllDepartmentByDivisionIdCommand.DepartmentVo> */
        List<QueryAllDepartmentByDivisionIdCommand.DepartmentVo> departmentVoList = new ArrayList<>();
        /* 循环赋值 */
        departmentEsPoList.forEach(d -> departmentVoList.add(convert(d)));
        /* 返回 */
        return departmentVoList;
    }

    /**
     * DepartmentEsPo -> QueryAllDepartmentByDivisionIdCommand.DepartmentVo
     *
     * @param departmentEsPo
     * @return
     */
    private QueryAllDepartmentByDivisionIdCommand.DepartmentVo convert(DepartmentEsPo departmentEsPo) {
        /* 实例化 */
        QueryAllDepartmentByDivisionIdCommand.DepartmentVo departmentVo = new QueryAllDepartmentByDivisionIdCommand.DepartmentVo();
        /* 判断是否为null */
        if (departmentEsPo == null) {
            return departmentVo;
        }
        /* 赋值 */
        BeanUtils.copyProperties(departmentEsPo, departmentVo);
        /* 返回 */
        return departmentVo;
    }
}
