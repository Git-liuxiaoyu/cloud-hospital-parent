package com.example.workerservice.util.converter;

import com.example.workerservice.inlet.web.vo.DepartmentVo;
import com.example.workerservice.outlet.dao.mysql.po.DepartmentPo;
import com.example.workerservice.outlet.dao.redis.po.DepartmentRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To DepartmentVo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Slf4j
@Component
public class DepartmentVoConverter {

    /**
     * List<DepartmentRedisPo> -> List<DepartmentVo>
     *
     * @param departmentRedisPoList
     * @return
     */
    public List<DepartmentVo> convert(Iterable<DepartmentRedisPo> departmentRedisPoList) {
        /* 实例化 List<DepartmentVo> */
        List<DepartmentVo> departmentVoList = new ArrayList<>();
        /* 循环转换 */
        departmentRedisPoList.forEach(d -> departmentVoList.add(convert(d)));
        /* 返回 */
        return departmentVoList;
    }

    /**
     * DepartmentRedisPo -> DepartmentVo
     *
     * @param departmentRedisPo
     * @return
     */
    public DepartmentVo convert(DepartmentRedisPo departmentRedisPo) {
        /* 实例化一个DepartmentVo */
        DepartmentVo departmentVo = new DepartmentVo();
        /* 赋值 */
        departmentVo.setId(departmentRedisPo.getId());
        departmentVo.setDivisionid(departmentRedisPo.getDivisionid());
        departmentVo.setStatus(departmentRedisPo.getStatus());
        departmentVo.setName(departmentRedisPo.getName());
        /* 返回 */
        return departmentVo;
    }

    /**
     * List<DepartmentPo> -> List<DepartmentVo>
     *
     * @param departmentPoList
     * @return
     */
    public List<DepartmentVo> convert(List<DepartmentPo> departmentPoList) {
        /* 实例化 List<DepartmentVo> */
        List<DepartmentVo> departmentVoList = new ArrayList<>();
        /* 循环转换 */
        departmentPoList.forEach(d -> departmentVoList.add(convert(d)));
        /* 返回 */
        return departmentVoList;
    }

    /**
     * DepartmentPo -> DepartmentVo
     *
     * @param departmentPo
     * @return
     */
    public DepartmentVo convert(DepartmentPo departmentPo) {
        /* 实例化 DepartmentVo */
        DepartmentVo departmentVo = new DepartmentVo();
        /* 赋值 */
        departmentVo.setId(departmentPo.getId());
        departmentVo.setName(departmentPo.getName());
        departmentVo.setStatus(departmentPo.getStatus());
        departmentVo.setDivisionid(departmentPo.getDivisionid());
        /* 返回 */
        return departmentVo;
    }

}
