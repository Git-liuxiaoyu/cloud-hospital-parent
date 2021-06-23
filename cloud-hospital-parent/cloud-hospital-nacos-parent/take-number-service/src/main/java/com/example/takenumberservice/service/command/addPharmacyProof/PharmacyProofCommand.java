package com.example.takenumberservice.service.command.addPharmacyProof;


import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;
import com.example.takenumberservice.service.command.addCallProof.ProofCommandHandle;
import com.example.takenumberservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class PharmacyProofCommand {

    private Integer id;//id
    private String no;//取票no
    private Integer orderNum;//排队序号
    private String createTime;//取票时间



    private PharmacyProofCommandHandle handler;

    public PharmacyProofCommand(){
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(PharmacyProofCommandHandle.class);
    }

    public PharmacyProofCommand(Integer id, String no, Integer orderNum, String createTime) {
        this();
        this.id = id;
        this.no = no;
        this.orderNum = orderNum;
        this.createTime = createTime;
    }


    /**
     * 执行方法
     * @return
     */
    public ResponseResult<PharmacyProofCommand> execute(){

        return handler.add(this);
    }
}
