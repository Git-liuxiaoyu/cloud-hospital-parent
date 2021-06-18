package com.example.workerservice.util.converter;

import com.example.workerservice.outlet.dao.mysql.po.DepartmentPo;
import com.example.workerservice.outlet.dao.redis.po.DepartmentRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 Convert To DepartmentRedisPo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/18
 */
@Component
@Slf4j
public class DepartmentRedisPoConverter {

    /**
     * List<DepartmentPo> -> List<DepartmentRedisPo>
     *
     * @param departmentPoList
     * @return
     */
    public List<DepartmentRedisPo> convert(List<DepartmentPo> departmentPoList) {
        /* 实例化 List<DepartmentRedisPo> */
        List<DepartmentRedisPo> departmentRedisPoList = new ArrayList<>();
        /* 循环转换 */
        departmentPoList.forEach(d -> {

        });
        /* 转换 */
        return departmentRedisPoList;
    }

    /**
     * DepartmentPo -> DepartmentRedisPo
     *
     * @param departmentPo
     * @return
     */
    public DepartmentRedisPo convert(DepartmentPo departmentPo) {
        /* 实例化 DepartmentRedisPo */
        DepartmentRedisPo departmentRedisPo = new DepartmentRedisPo();
        /* 赋值 */
        BeanUtils.copyProperties(departmentPo, departmentRedisPo);
        /* 返回 */
        return departmentRedisPo;
    }

}
