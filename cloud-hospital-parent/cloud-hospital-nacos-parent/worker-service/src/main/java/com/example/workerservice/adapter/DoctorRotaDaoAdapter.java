package com.example.workerservice.adapter;

import com.example.workerservice.inlet.web.vo.DoctorRotaSetVo;
import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.outlet.dao.mysql.DoctorRotaPoDao;
import com.example.workerservice.outlet.dao.mysql.po.DoctorRotaPo;
import com.example.workerservice.outlet.dao.mysql.po.DoctorRotaPoExample;
import com.example.workerservice.outlet.dao.redis.DoctorRotaRedisPoDao;
import com.example.workerservice.outlet.dao.redis.po.DoctorRotaRedisPo;
import com.example.workerservice.util.converter.DoctorRotaRedisPoConverter;
import com.example.workerservice.util.converter.DoctorRotaSetVoConverter;
import com.example.workerservice.util.converter.DoctorRotaVoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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

    private final DoctorRotaSetVoConverter doctorRotaSetVoConverter;

    public DoctorRotaDaoAdapter(DoctorRotaPoDao doctorRotaPoDao, DoctorRotaRedisPoDao doctorRotaRedisPoDao, DoctorRotaVoConverter doctorRotaVoConverter, DoctorRotaRedisPoConverter doctorRotaRedisPoConverter, DoctorRotaSetVoConverter doctorRotaSetVoConverter) {
        this.doctorRotaPoDao = doctorRotaPoDao;
        this.doctorRotaRedisPoDao = doctorRotaRedisPoDao;
        this.doctorRotaVoConverter = doctorRotaVoConverter;
        this.doctorRotaRedisPoConverter = doctorRotaRedisPoConverter;
        this.doctorRotaSetVoConverter = doctorRotaSetVoConverter;
    }
    /* 构造注入 - 结束 */


    /**
     * 根据 日期 - 科室 - 状态 查询
     *
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
            log.info("从 Redis 取出 排班 [{}]", doctorRotaVoList);
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
            log.info("从 MySQL 取出 排班 [{}]", doctorRotaVoList);
        }
        /* 返回 */
        return doctorRotaVoList;
    }


    /**
     * 添加排班方法
     *
     * @param departmentId
     * @param doctorId
     * @param date
     * @param rotaType
     * @param shiftType
     * @param maxPatient
     * @param roomId
     * @param createId
     * @param createTime
     * @param status
     * @return
     */
    public Long addDoctorRota(Integer departmentId, Integer doctorId, Date date, String rotaType, String shiftType, Integer maxPatient, Integer roomId, Integer createId, Date createTime, String status) {
        /* 实例化 */
        DoctorRotaPo doctorRotaPo = new DoctorRotaPo();
        /* 赋值 */
        copyProps(departmentId, doctorId, date, rotaType, shiftType, maxPatient, roomId, createId, createTime, status, doctorRotaPo);
        /* 调用insert */
        doctorRotaPoDao.insert(doctorRotaPo);
        /* 返回主键 */
        return doctorRotaPo.getId();
    }

    /**
     * 查询
     *
     * @param departmentId
     * @param date
     * @param shiftType
     * @param status
     * @return
     */
    public List<DoctorRotaSetVo> query(Integer departmentId, Date date, String shiftType, String status) {
        /* 实例化 */
        DoctorRotaPoExample doctorRotaPoExample = new DoctorRotaPoExample();
        /* 创造条件 */
        doctorRotaPoExample.createCriteria().andDepartmentidEqualTo(departmentId).andDateEqualTo(date).andShifttypeEqualTo(shiftType).andStatusEqualTo(status);
        /* 调用方法 */
        List<DoctorRotaPo> doctorRotaPoList = doctorRotaPoDao.selectByExample(doctorRotaPoExample);
        /* 转换 - 返回 */
        return doctorRotaSetVoConverter.convert(doctorRotaPoList);
    }

    /**
     * 更新排班
     *
     * @param id
     * @param departmentId
     * @param doctorId
     * @param date
     * @param rotaType
     * @param shiftType
     * @param maxPatient
     * @param roomId
     * @param createId
     * @param createTime
     * @param status
     */
    public void updateDoctorRota(Long id, Integer departmentId, Integer doctorId, Date date, String rotaType, String shiftType, Integer maxPatient, Integer roomId, Integer createId, Date createTime, String status) {
        /* 实例化 */
        DoctorRotaPo doctorRotaPo = new DoctorRotaPo();
        /* 赋值 */
        doctorRotaPo.setId(id);
        /* 复制属性 */
        copyProps(departmentId, doctorId, date, rotaType, shiftType, maxPatient, roomId, createId, createTime, status, doctorRotaPo);
        /* 更新 */
        doctorRotaPoDao.updateByPrimaryKeySelective(doctorRotaPo);
    }

    /**
     * 复制属性
     *
     * @param departmentId
     * @param doctorId
     * @param date
     * @param rotaType
     * @param shiftType
     * @param maxPatient
     * @param roomId
     * @param createId
     * @param createTime
     * @param status
     * @param doctorRotaPo
     */
    private void copyProps(Integer departmentId, Integer doctorId, Date date, String rotaType, String shiftType, Integer maxPatient, Integer roomId, Integer createId, Date createTime, String status, DoctorRotaPo doctorRotaPo) {
        doctorRotaPo.setDepartmentid(departmentId);
        doctorRotaPo.setDate(date);
        doctorRotaPo.setRotatype(rotaType);
        doctorRotaPo.setShifttype(shiftType);
        doctorRotaPo.setDoctorid(doctorId);
        doctorRotaPo.setLeftpatient(maxPatient);
        doctorRotaPo.setMaxpatient(maxPatient);
        doctorRotaPo.setRoomid(roomId);
        doctorRotaPo.setCreateid(createId);
        doctorRotaPo.setCreatetime(createTime);
        doctorRotaPo.setStatus(status);
    }

    /**
     * 判断想要排班的医生是否同时排班在别的诊室
     *
     * @param date
     * @param shiftType
     * @param departmentId
     */
    public void queryDoctorRotaToCheckIsDoctorInOtherRoomSameTimeAdd(Integer doctorId, Date date, String shiftType, Integer departmentId, String status) {
        /* 实例化 DoctorRotaPoExample */
        DoctorRotaPoExample doctorRotaPoExample = new DoctorRotaPoExample();
        /* 编写条件 */
        doctorRotaPoExample.createCriteria().andDateEqualTo(date).andShifttypeEqualTo(shiftType).andDepartmentidEqualTo(departmentId).andDoctoridEqualTo(doctorId).andStatusEqualTo(status);
        /* 调用方法 */
        List<DoctorRotaPo> doctorRotaPoList = doctorRotaPoDao.selectByExample(doctorRotaPoExample);
        /* 判断是否为唯一 */
        if (!doctorRotaPoList.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 判断想要排班的医生是否同时排班在别的诊室
     *
     * @param date
     * @param shiftType
     * @param departmentId
     */
    public void queryDoctorRotaToCheckIsDoctorInOtherRoomSameTimeUpdate(Integer doctorId, Date date, String shiftType, Integer departmentId, String status) {
        /* 实例化 DoctorRotaPoExample */
        DoctorRotaPoExample doctorRotaPoExample = new DoctorRotaPoExample();
        /* 编写条件 */
        doctorRotaPoExample.createCriteria().andDateEqualTo(date).andShifttypeEqualTo(shiftType).andDepartmentidEqualTo(departmentId).andDoctoridEqualTo(doctorId).andStatusEqualTo(status);
        /* 调用方法 */
        List<DoctorRotaPo> doctorRotaPoList = doctorRotaPoDao.selectByExample(doctorRotaPoExample);
        /* 判断是否为唯一 */
        if (!doctorRotaPoList.isEmpty() && doctorRotaPoList.size() != 1) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 修改状态
     *
     * @param id
     * @param status
     */
    public void updateDoctorRotaStatus(Long id, String status) {
        /* 实例化 DoctorRotaPo */
        DoctorRotaPo doctorRotaPo = new DoctorRotaPo();
        /* 赋值 */
        doctorRotaPo.setStatus(status);
        doctorRotaPo.setId(id);
        /* 调用方法 */
        doctorRotaPoDao.updateByPrimaryKeySelective(doctorRotaPo);
    }
}
