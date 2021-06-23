package com.example.takenumberservice.inlet.web.controller;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@Api(value = "取票微服务", description = "挂号取票接口")
@RestController
@CrossOrigin
@RequestMapping("/GHproof/")
public class ProofController {


    @ApiOperation(value = "获得取票凭证", notes = "根据挂号no获得取票凭证", produces = "application/json", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "no", value = "挂号no(如GH1018)通过挂号no判断挂号状态是否付款出票并存入取票凭证", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping("findbyno/{no}")
    public ResponseResult<ProofCommand> findbyregId(@PathVariable("no") String no){
        RegisterCommand rc = new RegisterCommand();
        rc.setNo(no);
        return rc.execute();
    }

}
