package com.example.workerservice.adapter;

import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.outlet.dao.mysql.DoctorRotaPoDao;
import com.example.workerservice.outlet.dao.mysql.po.DoctorRotaPo;
import com.example.workerservice.outlet.dao.mysql.po.DoctorRotaPoExample;
import com.example.workerservice.outlet.dao.redis.DoctorRotaRedisPoDao;
import com.example.workerservice.outlet.dao.redis.po.DoctorRotaRedisPo;
import com.example.workerservice.util.converter.DoctorRotaRedisPoConverter;
import com.example.workerservice.util.converter.DoctorRotaVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 适配器类 - 适配 - DoctorRotaDao
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Component
@Slf4j
public class DoctorRotaDaoAdapter {

    /* 构造注入 - 开始 */
    private final DoctorRotaPoDao doctorRotaPoDao;

    private final DoctorRotaRedisPoDao doctorRotaRedisPoDao;

    private final DoctorRotaVoConverter doctorRotaVoConverter;

    private final DoctorRotaRedisPoConverter doctorRotaRedisPoConverter;

    public DoctorRotaDaoAdapter(DoctorRotaPoDao doctorRotaPoDao, DoctorRotaRedisPoDao doctorRotaRedisPoDao, DoctorRotaVoConverter doctorRotaVoConverter, DoctorRotaRedisPoConverter doctorRotaRedisPoConverter) {
        this.doctorRotaPoDao = doctorRotaPoDao;
        this.doctorRotaRedisPoDao = doctorRotaRedisPoDao;
        this.doctorRotaVoConverter = doctorRotaVoConverter;
        this.doctorRotaRedisPoConverter = doctorRotaRedisPoConverter;
    }
    /* 构造注入 - 结束 */


    /**
     * 根据 日期 - 科室 - 状态 查询
     * @param date
     * @param departmentId
     * @param status
     */
    public List<DoctorRotaVo> query(Date date, Integer departmentId, String status) {
        /* 声明 */
        List<DoctorRotaVo> doctorRotaVoList;
        try {
            /* 先看 Redis 中有没有 */
            List<DoctorRotaRedisPo> doctorRotaRedisPoList = doctorRotaRedisPoDao.findAllByStatusEqualsAndDepartmentidEqualsAndDateEquals(status, departmentId, date);
            /* 没有则抛异常 NullPointerException */
            if (doctorRotaRedisPoList.isEmpty()) {
                throw new NullPointerException();
            }
            /* 有的话转换 */
            doctorRotaVoList = doctorRotaVoConverter.convert(doctorRotaRedisPoList);
            /* LOG */
            log.info("从 Redis 取出 排班 [{}]",doctorRotaVoList);
        } catch (NullPointerException e) {
            /* 捕获到异常则去 MySQL 查 */
            /* 调用方法 */
            List<DoctorRotaPo> doctorRotaPoList = doctorRotaPoDao.findAllByStatusEqualsAndDepartmentidEqualsAndDateEquals(status, departmentId, date);
            /* 转换成Vo */
            doctorRotaVoList = doctorRotaVoConverter.convert(doctorRotaPoList);
            /* 转换成 RedisPo */
            /* 存入Redis */
            doctorRotaRedisPoDao.saveAll(doctorRotaRedisPoConverter.convert(doctorRotaPoList));
            /* LOG */
            log.info("从 MySQL 取出 排班 [{}]",doctorRotaVoList);
        }
        /* 返回 */
        return doctorRotaVoList;
    }


}
