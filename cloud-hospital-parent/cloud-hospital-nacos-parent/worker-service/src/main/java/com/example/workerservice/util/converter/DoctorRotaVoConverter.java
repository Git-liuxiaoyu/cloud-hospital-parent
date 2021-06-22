package com.example.workerservice.util.converter;

import com.example.workerservice.inlet.web.vo.DoctorRotaVo;
import com.example.workerservice.outlet.dao.mysql.po.DoctorRotaPo;
import com.example.workerservice.outlet.dao.redis.po.DoctorRotaRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To DoctorRotaVo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Component
@Slf4j
public class DoctorRotaVoConverter {

    /**
     * List<DoctorRotaPo> -> List<DoctorRotaVo>
     *
     * @param doctorRotaPoList
     * @return
     */
    public List<DoctorRotaVo> convert(Iterable<DoctorRotaPo> doctorRotaPoList) {
        /* 实例化 */
        List<DoctorRotaVo> doctorRotaVoList = new ArrayList<>();
        /* 循环转换 */
        doctorRotaPoList.forEach(d -> doctorRotaVoList.add(convert(d)));
        /* 返回 */
        return doctorRotaVoList;
    }

    /**
     * DoctorRotaPo -> DoctorRotaVo
     *
     * @param doctorRotaPo
     * @return
     */
    public DoctorRotaVo convert(DoctorRotaPo doctorRotaPo) {
        /* 实例化 */
        DoctorRotaVo doctorRotaVo = new DoctorRotaVo();
        /* 赋值 */
        doctorRotaVo.setMaxpatient(doctorRotaPo.getMaxpatient());
        doctorRotaVo.setId(doctorRotaPo.getId());
        doctorRotaVo.setDepartmentid(doctorRotaPo.getDepartmentid());
        doctorRotaVo.setShifttype(doctorRotaPo.getShifttype());
        doctorRotaVo.setLeftpatient(doctorRotaPo.getLeftpatient());
        doctorRotaVo.setDoctorid(doctorRotaPo.getDoctorid());
        doctorRotaVo.setDoctorName(doctorRotaPo.getWorkerInfoPo().getName());
        doctorRotaVo.setDoctorAvatar(doctorRotaPo.getWorkerInfoPo().getAvatar());
        doctorRotaVo.setDoctorLevel(doctorRotaPo.getWorkerInfoPo().getPositionPo().getLevel());
        doctorRotaVo.setDate(doctorRotaPo.getDate());
        doctorRotaVo.setStatus(doctorRotaPo.getStatus());
        /* 返回 */
        return doctorRotaVo;
    }

    /**
     * List<DoctorRotaRedisPo> -> List<DoctorRotaVo>
     *
     * @param doctorRotaRedisPoList
     * @return
     */
    public List<DoctorRotaVo> convert(List<DoctorRotaRedisPo> doctorRotaRedisPoList) {
        /* 实例化 */
        List<DoctorRotaVo> doctorRotaVoList = new ArrayList<>();
        /* 循环转换 */
        doctorRotaRedisPoList.forEach(d -> doctorRotaVoList.add(convert(d)));
        /* 返回 */
        return doctorRotaVoList;

    }

    /**
     * DoctorRotaRedisPo -> DoctorRotaVo
     *
     * @param doctorRotaRedisPo
     * @return
     */
    public DoctorRotaVo convert(DoctorRotaRedisPo doctorRotaRedisPo) {
        /* 实例化 */
        DoctorRotaVo doctorRotaVo = new DoctorRotaVo();
        /* 赋值 */
        BeanUtils.copyProperties(doctorRotaRedisPo, doctorRotaVo);
        /* 返回 */
        return doctorRotaVo;
    }

}
