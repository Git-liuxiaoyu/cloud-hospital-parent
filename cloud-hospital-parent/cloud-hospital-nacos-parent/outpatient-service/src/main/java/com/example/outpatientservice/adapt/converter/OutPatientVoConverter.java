package com.example.outpatientservice.adapt.converter;



import com.example.outpatientservice.inlet.web.vo.OutPatientVo;
import com.example.outpatientservice.outlet.dao.mysql.po.OutPatientPo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//转换实体类方法
@Component
public class OutPatientVoConverter {
        //po集合转成vo集合
        public List<OutPatientVo> convert(List<OutPatientPo> poList) {
        List<OutPatientVo> voList = new ArrayList<>();
        for (OutPatientPo po : poList) {
            OutPatientVo vo=convert(po);
            voList.add(vo);
        }
        return voList;
    }
        //po对象转换为vo对象
        public OutPatientVo convert(OutPatientPo po) {
            OutPatientVo vo = new OutPatientVo();
            BeanUtils.copyProperties(po,vo);
        return vo;
    }



}
