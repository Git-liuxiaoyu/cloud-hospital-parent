package com.example.takenumberservice.adapter.converter;


import com.example.takenumberservice.outlet.client.examine.pojo.ExamineVo;
import com.example.takenumberservice.outlet.dao.mysql.pojo.ExamineProofPo;
import com.example.takenumberservice.service.command.addexamineProof.ExamineProofCommand;
import org.springframework.stereotype.Component;

@Component
public class ExamineConverter {

    /**
     * 检查command转po
     * @param examineProofCommand
     * @return
     */
    public ExamineProofPo excmtopo(ExamineProofCommand examineProofCommand){
        ExamineProofPo ep = new ExamineProofPo();
        ep.setCreateTime(examineProofCommand.getCreateTime());
        ep.setId(examineProofCommand.getId());
        ep.setNo(examineProofCommand.getNo());
        ep.setOrderNum(examineProofCommand.getOrderNum());
        ep.setExamineType(examineProofCommand.getExamineType());

        return ep;
    }

    /**
     * 检查vo转command
     * @param examineVo
     * @return
     */
    public ExamineProofCommand votoexcm(ExamineVo examineVo){
        ExamineProofCommand rc = new ExamineProofCommand();
        rc.setNo(examineVo.getNo());
        rc.setExamineType(examineVo.getType());
        return rc;
    }

}
