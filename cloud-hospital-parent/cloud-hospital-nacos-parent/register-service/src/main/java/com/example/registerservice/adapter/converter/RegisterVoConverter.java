package com.example.registerservice.adapter.converter;

import com.example.registerservice.inlet.web.vo.RegisterVo;
import com.example.registerservice.inlet.web.vo.SubjectTypeVo;
import com.example.registerservice.outlet.client.po.DepartmentClientPo;
import com.example.registerservice.outlet.dao.mysql.po.RegisterMysqlPo;
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
    public List<RegisterVo> convert(List<RegisterMysqlPo> clientPoList) {
        List<RegisterVo> RegisterVoList = new ArrayList<>();
        clientPoList.forEach(item -> RegisterVoList.add(convert(item)));
        return RegisterVoList;
    }


    /**
     * 科目的mysqlPo对象转换科目的vo对象
     *
     * @param mysqlPo
     * @return
     */
    public RegisterVo convert(RegisterMysqlPo mysqlPo) {
        RegisterVo vo=new RegisterVo();
        vo.setId(mysqlPo.getId());
        vo.setPatientId(mysqlPo.getPatientid());
        vo.setNo(mysqlPo.getNo());
        vo.setDepartmentId(mysqlPo.getDepartmentid());
        vo.setRotaId(mysqlPo.getRotaid());
        vo.setVisitSection(mysqlPo.getVisitsection());
        vo.setStatus(mysqlPo.getStatus());
        return vo;
    }
}
