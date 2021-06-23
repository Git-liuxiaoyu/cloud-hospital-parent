package com.example.takenumberservice.service.command.addPharmacyProof;


import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;
import com.example.takenumberservice.service.command.addCallProof.ProofCommandHandle;
import com.example.takenumberservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class PharmacyProofCommand {

    @NotNull
    @ApiModelProperty(value="主键id",required = true,example = "1")
    private Integer id;//id

    @NotNull
    @ApiModelProperty(value="取票no",required = true,example = "YF0001")
    private String no;//取票no

    @NotNull
    @ApiModelProperty(value="排队序号",required = true,example = "1")
    private Integer orderNum;//排队序号


    @NotNull
    @ApiModelProperty(value="取票时间",required = true,example = "2021-06-23 19:03:30")
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
