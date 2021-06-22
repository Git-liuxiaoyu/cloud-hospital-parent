package com.example.workerservice.util.converter;

import com.example.workerservice.inlet.web.vo.DoctorRotaSetVo;
import com.example.workerservice.outlet.dao.mysql.po.DoctorRotaPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换器类 - Convert To DoctorRotaSetVo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/21
 */
@Component
@Slf4j
public class DoctorRotaSetVoConverter {

    /**
     * List<DoctorRotaPo> -> List<DoctorRotaSetVo>
     *
     * @param doctorRotaPoList
     * @return
     */
    public List<DoctorRotaSetVo> convert(List<DoctorRotaPo> doctorRotaPoList) {
        /* 实例化 */
        List<DoctorRotaSetVo> doctorRotaSetVoList = new ArrayList<>();
        /* 转换 */
        doctorRotaPoList.forEach(d -> doctorRotaSetVoList.add(convert(d)));
        /* 返回 */
        return doctorRotaSetVoList;
    }

    /**
     * DoctorRotaPo -> DoctorRotaSetVo
     *
     * @param doctorRotaPo
     * @return
     */
    public DoctorRotaSetVo convert(DoctorRotaPo doctorRotaPo) {
        /* 实例化 */
        DoctorRotaSetVo doctorRotaSetVo = new DoctorRotaSetVo();
        /* 复制属性 */
        BeanUtils.copyProperties(doctorRotaPo, doctorRotaSetVo);
        /* 返回 */
        return doctorRotaSetVo;
    }

}
