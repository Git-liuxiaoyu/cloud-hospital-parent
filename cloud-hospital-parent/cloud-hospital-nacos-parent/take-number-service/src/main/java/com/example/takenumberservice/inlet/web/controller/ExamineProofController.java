package com.example.takenumberservice.inlet.web.controller;


import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.inlet.web.controller.vo.ExamineProofVo;
import com.example.takenumberservice.inlet.web.converter.TransformVo;
import com.example.takenumberservice.service.command.addPharmacyProof.PharmacyProofCommand;
import com.example.takenumberservice.service.command.addexamineProof.ExamineProofCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
@Api(value = "取票微服务", description = "检查取票接口")
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

    @ApiOperation(value = "获得检查凭证", notes = "医生给出", produces = "application/json", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "no", value = "检查取票no(如JC1018)", required = true, dataType = "String", paramType = "path")
    })
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
