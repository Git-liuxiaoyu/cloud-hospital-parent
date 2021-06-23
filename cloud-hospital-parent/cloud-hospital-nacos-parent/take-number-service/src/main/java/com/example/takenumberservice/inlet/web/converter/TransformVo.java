package com.example.takenumberservice.inlet.web.converter;

import com.example.takenumberservice.inlet.web.controller.vo.ExamineProofVo;
import com.example.takenumberservice.service.command.addexamineProof.ExamineProofCommand;
import org.springframework.stereotype.Component;

@Component
public class TransformVo {

    /**
     * 检查科取票转换
     * @param ec
     * @return
     */
    public ExamineProofVo ctov(ExamineProofCommand ec){
        ExamineProofVo ev = new ExamineProofVo();
        ev.setNo(ec.getNo());
        ev.setCreateTime(ec.getCreateTime());
        ev.setExamineType(ec.getExamineType());
        ev.setId(ec.getId());
        ev.setOrderNum(ec.getOrderNum());
        return ev;
    }

}
