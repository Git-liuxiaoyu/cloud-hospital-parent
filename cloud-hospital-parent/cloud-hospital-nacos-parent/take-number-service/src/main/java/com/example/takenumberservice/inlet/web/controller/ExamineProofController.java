package com.example.takenumberservice.inlet.web.controller;


import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.inlet.web.controller.vo.ExamineProofVo;
import com.example.takenumberservice.inlet.web.converter.TransformVo;
import com.example.takenumberservice.service.command.addPharmacyProof.PharmacyProofCommand;
import com.example.takenumberservice.service.command.addexamineProof.ExamineProofCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/JCproof/")
public class ExamineProofController {

    @Autowired
    private TransformVo transformVo;

    /**
     * 通过no取检查科的票
     * @param no
     * @return
     */
    @GetMapping("findbyno/{no}")
    public ResponseResult<ExamineProofVo> getNum(@PathVariable("no") String no){
        ExamineProofCommand examineProofCommand = new ExamineProofCommand();
        examineProofCommand.setNo(no);
        ResponseResult<ExamineProofCommand> execute = examineProofCommand.execute();
        if(execute.getData() == null){
            return new ResponseResult<>(execute.getCode(), execute.getMsg(),null);
        }else{
            return new ResponseResult<ExamineProofVo>(execute.getCode(),execute.getMsg(),transformVo.ctov(execute.getData()));
        }
    }


}
