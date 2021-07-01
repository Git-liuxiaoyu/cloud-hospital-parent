package com.example.registerservice.adapter.converter;

import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPo;
import com.example.registerservice.service.query.queryregister.po.Register;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/18:45
 * @Description:
 */
@Component
public class RegisterVoConverter {
    /**
     * 科目的集合ClientPo对象转换科目的集合vo对象
     *
     * @param clientPoList
     * @return
     */
    public List<Register.ByNo> convert(List<RegisterMysqlPo> clientPoList) {
        List<Register.ByNo> RegisterVoList = new ArrayList<>();
        clientPoList.forEach(item -> RegisterVoList.add(convert(item)));
        return RegisterVoList;
    }


    /**
     * 科目的mysqlPo对象转换科目的Register.ByNo对象
     *
     * @param mysqlPo
     * @return
     */
    public Register.ByNo convert(RegisterMysqlPo mysqlPo) {
        Register.ByNo byNo = new Register.ByNo();
        byNo.setId(mysqlPo.getId());
        byNo.setPatientId(mysqlPo.getPatientid());
        byNo.setNo(mysqlPo.getNo());
        byNo.setDepartmentId(mysqlPo.getDepartmentid());
        byNo.setRotaId(mysqlPo.getRotaid());
        byNo.setVisitSection(mysqlPo.getVisitsection());
        byNo.setStatus(mysqlPo.getStatus());
        return byNo;
    }
}
