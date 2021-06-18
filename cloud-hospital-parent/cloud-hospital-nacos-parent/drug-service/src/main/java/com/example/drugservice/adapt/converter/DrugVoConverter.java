package com.example.drugservice.adapt.converter;


import com.example.drugservice.inlet.web.vo.DrugVo;
import com.example.drugservice.outlet.dao.mysql.po.DrugPo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//转换实体类方法
@Component
public class DrugVoConverter {

//    public DepartmentVo convert(DepartmentRedisPo po) {
//        DepartmentVo vo = new DepartmentVo();
//        vo.setId(po.getId());
//        vo.setName(po.getName());
//        vo.setLocation(po.getLocation());
//        return vo;
//    }
//
//    public DepartmentVo convert(Department po) {
//
//        DepartmentVo vo = new DepartmentVo();
//        vo.setId(po.getId());
//        vo.setName(po.getName());
//        vo.setLocation(po.getLocation());
//        return vo;
//    }
//
//    public DepartmentVo convert(DepartmentEsPo po) {
//        DepartmentVo vo = new DepartmentVo();
//            vo.setId(Integer.parseInt(po.getId()));
//            vo.setName(po.getName());
//            vo.setLocation(po.getLocation());
//
//        return vo;
//    }
//
//    public List<DepartmentVo> convert(List<DepartmentEsPo> poList) {
//        List<DepartmentVo> voList = new ArrayList<>();
//        for (DepartmentEsPo po : poList) {
//            DepartmentVo vo=convert(po);
//            voList.add(vo);
//        }
//        return voList;
//    }
        //po集合转成vo集合
        public List<DrugVo> convert(List<DrugPo> poList) {
        List<DrugVo> voList = new ArrayList<>();
        for (DrugPo po : poList) {
            DrugVo vo=convert(po);
            voList.add(vo);
        }
        return voList;
    }
        //po对象转换为vo对象
        public DrugVo convert(DrugPo po) {
            DrugVo vo = new DrugVo();
//            vo.setId(Integer.parseInt(po.getId()));
//            vo.setName(po.getName());
//            vo.setLocation(po.getLocation());
            vo.setTypeName(po.getDrugtype());
            BeanUtils.copyProperties(po,vo);
        return vo;
    }



}
