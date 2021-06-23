package com.example.takenumberservice.inlet.web.controller;


import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;
import com.example.takenumberservice.service.command.addPharmacyProof.PharmacyProofCommand;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
@Api(value = "取票微服务", description = "药房取票接口")
@RestController
@CrossOrigin
@RequestMapping("/YFproof/")
public class PharmacyProofController {



    @ApiOperation(value = "获得药房取票凭证", notes = "根据药房no获得取票凭证", produces = "application/json", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "no", value = "药房no(如YF0001)通过医生给患者的药房取票no出票并存入取票凭证", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping("findbyno/{no}")
    public ResponseResult<PharmacyProofCommand> findbyregId(@PathVariable("no") String no){
        PharmacyProofCommand proofCommand = new PharmacyProofCommand();
        proofCommand.setNo(no);
        return proofCommand.execute();
    }


}
