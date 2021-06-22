package com.example.takenumberservice.inlet.web.controller;


import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;
import com.example.takenumberservice.service.command.addPharmacyProof.PharmacyProofCommand;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/YFproof/")
public class PharmacyProofController {

    @GetMapping("findbyno/{no}")
    public ResponseResult<PharmacyProofCommand> findbyregId(@PathVariable("no") String no){
        PharmacyProofCommand proofCommand = new PharmacyProofCommand();
        proofCommand.setNo(no);
        return proofCommand.execute(proofCommand);
    }


}
