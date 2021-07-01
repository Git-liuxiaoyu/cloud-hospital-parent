package com.example.registerservice.adapter.converter;

import com.example.registerservice.outlet.dao.es.po.RegisterEsPo;
import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPo;
import com.example.registerservice.outlet.dao.redis.po.RegisterRedisPo;
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
    public Register.ById converter(RegisterMysqlPo po) {
        Register.ById register = new Register.ById();
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

    /**
     * 根据id查询挂号对象
     * mysql对象转换成es对象
     *
     * @param po
     * @return
     */
    public RegisterEsPo esConverter(RegisterMysqlPo po) {
        RegisterEsPo registerEsPo = new RegisterEsPo();
        registerEsPo.setId(po.getId());
        registerEsPo.setNo(po.getNo());
        registerEsPo.setPatientid(po.getPatientid());
        registerEsPo.setRegtype(po.getRegtype());
        registerEsPo.setRegtime(po.getRegtime());
        registerEsPo.setRotaid(po.getRotaid());
        registerEsPo.setDepartmentid(po.getDepartmentid());
        registerEsPo.setRoomid(po.getRoomid());
        registerEsPo.setVisittime(po.getVisittime());
        registerEsPo.setVisitsection(po.getVisitsection());
        registerEsPo.setPrice(po.getPrice());
        registerEsPo.setType(po.getType());
        registerEsPo.setStatus(po.getStatus());
        registerEsPo.setPhone(po.getPhone());
        return registerEsPo;

    }

    /**
     * 根据id查询挂号对象
     * mysql对象转换成redis对象
     *
     * @param po
     * @return
     */
    public RegisterRedisPo redisConverter(RegisterMysqlPo po) {
        RegisterRedisPo registerRedisPo = new RegisterRedisPo();
        registerRedisPo.setId(po.getId());
        registerRedisPo.setNo(po.getNo());
        registerRedisPo.setPatientid(po.getPatientid());
        registerRedisPo.setRegtype(po.getRegtype());
        registerRedisPo.setRegtime(po.getRegtime());
        registerRedisPo.setRotaid(po.getRotaid());
        registerRedisPo.setDepartmentid(po.getDepartmentid());
        registerRedisPo.setRoomid(po.getRoomid());
        registerRedisPo.setVisittime(po.getVisittime());
        registerRedisPo.setVisitsection(po.getVisitsection());
        registerRedisPo.setPrice(po.getPrice());
        registerRedisPo.setType(po.getType());
        registerRedisPo.setStatus(po.getStatus());
        registerRedisPo.setPhone(po.getPhone());
        return registerRedisPo;
    }
}
