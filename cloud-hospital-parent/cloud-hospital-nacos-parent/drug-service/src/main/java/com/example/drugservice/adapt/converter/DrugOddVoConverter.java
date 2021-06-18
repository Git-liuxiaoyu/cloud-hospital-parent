package com.example.drugservice.adapt.converter;


import com.example.drugservice.inlet.web.vo.DrugOddVo;
import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.outlet.dao.mysql.po.DrugOddPo;
import com.example.drugservice.outlet.dao.mysql.po.DrugPo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//转换实体类方法
@Component
public class DrugOddVoConverter {


//        //po集合转成vo集合
//        public List<DrugOddVo> convert(List<DrugOddPo> poList) {
//        List<DrugOddVo> voList = new ArrayList<>();
//        for (DrugOddPo po : poList) {
//            DrugOddVo vo=convert(po);
//            voList.add(vo);
//        }
//        return voList;
//    }
//        //po对象转换为vo对象
//        public DrugOddVo convert(DrugOddPo po) {
//            DrugOddVo vo = new DrugOddVo();
//            BeanUtils.copyProperties(po,vo);
//        return vo;
//    }



}
