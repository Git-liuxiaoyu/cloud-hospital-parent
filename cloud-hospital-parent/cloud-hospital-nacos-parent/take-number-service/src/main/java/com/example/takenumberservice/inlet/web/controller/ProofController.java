package com.example.takenumberservice.inlet.web.controller;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.inlet.web.vo.ProofControllerVo;
import com.example.takenumberservice.service.command.ProofCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/proof/")
public class ProofController {

    @GetMapping("findbyregid/{regId}")
    public ResponseResult<ProofControllerVo> findbyregId(@PathVariable("regId") Integer proof){
        ProofCommand proofCommand = new ProofCommand();
        proofCommand.setId(1);
        ProofControllerVo execute = proofCommand.execute();
        return new ResponseResult<ProofControllerVo>(200,"ok",execute);
    }

}
