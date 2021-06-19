package com.example.workerservice.util.converter;

import com.example.workerservice.outlet.dao.mysql.po.DoctorRotaPo;
import com.example.workerservice.outlet.dao.redis.po.DoctorRotaRedisPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To DoctorRotaRedisPo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/19
 */
@Component
@Slf4j
public class DoctorRotaRedisPoConverter {


    /**
     * List<DoctorRotaPo> -> List<DoctorRotaRedisPo>
     *
     * @param doctorRotaPoList
     * @return
     */
    public List<DoctorRotaRedisPo> convert(List<DoctorRotaPo> doctorRotaPoList) {
        /* 实例化 */
        List<DoctorRotaRedisPo> doctorRotaRedisPoList = new ArrayList<>();
        /* 循环转化 */
        doctorRotaPoList.forEach(d -> doctorRotaRedisPoList.add(convert(d)));
        /* 返回 */
        return doctorRotaRedisPoList;
    }

    /**
     * DoctorRotaPo -> DoctorRotaRedisPo
     *
     * @param doctorRotaPo
     * @return
     */
    public DoctorRotaRedisPo convert(DoctorRotaPo doctorRotaPo) {
        /* 实例化 */
        DoctorRotaRedisPo doctorRotaRedisPo = new DoctorRotaRedisPo();
        /* 赋值 */
        doctorRotaRedisPo.setDoctorid(doctorRotaPo.getDoctorid());
        doctorRotaRedisPo.setRotatype(doctorRotaPo.getRotatype());
        doctorRotaRedisPo.setDoctorAvatar(doctorRotaPo.getWorkerInfoPo().getAvatar());
        doctorRotaRedisPo.setDoctorName(doctorRotaPo.getWorkerInfoPo().getName());
        doctorRotaRedisPo.setDoctorLevel(doctorRotaPo.getWorkerInfoPo().getPositionPo().getLevel());
        doctorRotaRedisPo.setDate(doctorRotaPo.getDate());
        doctorRotaRedisPo.setDepartmentid(doctorRotaPo.getDepartmentid());
        doctorRotaRedisPo.setRoomid(doctorRotaPo.getRoomid());
        doctorRotaRedisPo.setId(doctorRotaPo.getId());
        doctorRotaRedisPo.setLeftpatient(doctorRotaPo.getLeftpatient());
        doctorRotaRedisPo.setShifttype(doctorRotaPo.getShifttype());
        doctorRotaRedisPo.setStatus(doctorRotaPo.getStatus());
        /* 返回 */
        return doctorRotaRedisPo;
    }

}
