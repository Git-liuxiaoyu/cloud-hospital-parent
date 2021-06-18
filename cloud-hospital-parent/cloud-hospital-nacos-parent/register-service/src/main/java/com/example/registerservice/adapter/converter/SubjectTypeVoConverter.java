package com.example.registerservice.adapter.converter;

import com.example.registerservice.inlet.web.vo.SubjectTypeVo;
import com.example.registerservice.outlet.client.po.DepartmentClientPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/11:09
 * @Description:
 */
@Component
@Slf4j
public class SubjectTypeVoConverter {
    /**
     * 科目的集合ClientPo对象转换科目的集合vo对象
     *
     * @param clientPoList
     * @return
     */
    public List<SubjectTypeVo> convert(List<DepartmentClientPo> clientPoList) {
        List<SubjectTypeVo> subjectTypeVoList = new ArrayList<>();
        clientPoList.forEach(item -> subjectTypeVoList.add(convert(item)));
        return subjectTypeVoList;
    }


    /**
     * 科目的ClientPo对象转换科目的vo对象
     *
     * @param clientPo
     * @return
     */
    public SubjectTypeVo convert(DepartmentClientPo clientPo) {
        SubjectTypeVo subjectTypeVo = new SubjectTypeVo();
        subjectTypeVo.setId(clientPo.getId());
        subjectTypeVo.setName(clientPo.getName());
        return subjectTypeVo;
    }


}
