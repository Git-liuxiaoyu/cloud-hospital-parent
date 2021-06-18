package com.example.registerservice.adapter.converter;

import com.example.registerservice.inlet.web.vo.SubjectVo;
import com.example.registerservice.outlet.client.po.DivisionClientPo;
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
public class SubjectVoConverter {
    /**
     * 科目的集合ClientPo对象转换科目的集合vo对象
     *
     * @param clientPoList
     * @return
     */
    public List<SubjectVo> convert(List<DivisionClientPo> clientPoList) {
        List<SubjectVo> subjectVoList = new ArrayList<>();
        clientPoList.forEach(item -> subjectVoList.add(convert(item)));
        return subjectVoList;
    }


    /**
     * 科目的ClientPo对象转换科目的vo对象
     *
     * @param clientPo
     * @return
     */
    public SubjectVo convert(DivisionClientPo clientPo) {
        SubjectVo subjectVo = new SubjectVo();
        subjectVo.setId(clientPo.getId());
        subjectVo.setName(clientPo.getName());
        return subjectVo;
    }


}
