package com.example.registerservice.adapter.converter;

import com.example.registerservice.inlet.web.vo.RegisterVo;
import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPo;
import com.example.registerservice.service.query.queryregister.po.Register;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/22/17:47
 * @Description:
 */
@Component
public class RegisterConverter {
    public Register converter(RegisterMysqlPo po) {
        Register register = new Register();
        register.setId(po.getId());
        register.setNo(po.getNo());
        register.setPatientid(po.getPatientid());
        register.setRegtype(po.getRegtype());
        register.setRegtime(po.getRegtime());
        register.setRotaid(po.getRotaid());
        register.setDepartmentid(po.getDepartmentid());
        register.setRoomid(po.getRoomid());
        register.setVisittime(po.getVisittime());
        register.setVisitsection(po.getVisitsection());
        register.setPrice(po.getPrice());
        register.setType(po.getType());
        register.setStatus(po.getStatus());
        register.setPhone(po.getPhone());
        return register;
    }

    public RegisterVo.QueryGetByIdVo converter(Register register) {
        RegisterVo.QueryGetByIdVo Vo = new RegisterVo.QueryGetByIdVo();
        Vo.setId(register.getId());
        Vo.setNo(register.getNo());
        Vo.setPatientid(register.getPatientid());
        Vo.setRegtype(register.getRegtype());
        Vo.setRegtime(register.getRegtime());
        Vo.setRotaid(register.getRotaid());
        Vo.setDepartmentid(register.getDepartmentid());
        Vo.setRoomid(register.getRoomid());
        Vo.setVisittime(register.getVisittime());
        Vo.setVisitsection(register.getVisitsection());
        Vo.setPrice(register.getPrice());
        Vo.setType(register.getType());
        Vo.setStatus(register.getStatus());
        Vo.setPhone(register.getPhone());
        return Vo;
    }
}
