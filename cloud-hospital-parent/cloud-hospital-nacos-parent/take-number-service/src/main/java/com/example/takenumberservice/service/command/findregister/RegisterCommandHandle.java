package com.example.takenumberservice.service.command.findregister;

import com.example.takenumberservice.adapter.RegisterAdapter;
import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCommandHandle implements com.example.takenumberservice.service.api.RegisterCommandHandle {

    @Autowired
    private RegisterAdapter registerAdapter;


    //通过no查询挂号信息
    @Override
    public ResponseResult<ProofCommand> findbyno(String no) {
        //先查redis
        boolean noRedis = registerAdapter.findNoRedis(no);

        if(noRedis){//如果为true则代表redis中有该no则无操作返回
            return new ResponseResult<>(999,"已出票，请勿重复取票",null);
        }
        ResponseResult<RegisterCommand> findbyno = registerAdapter.findbyno(no);
            if(findbyno.getCode() != 200){
                return new ResponseResult<>(400,"未查询到挂号信息，请稍后重试",null);
            }else{
                ProofCommand proofCommand = new ProofCommand();


                return proofCommand.execute(findbyno.getData());
            }
    }
}
