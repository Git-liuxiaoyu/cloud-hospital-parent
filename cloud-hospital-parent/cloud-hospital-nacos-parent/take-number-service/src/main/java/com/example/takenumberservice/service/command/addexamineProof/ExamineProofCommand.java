package com.example.takenumberservice.service.command.addexamineProof;


import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addPharmacyProof.PharmacyProofCommand;
import com.example.takenumberservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ExamineProofCommand {

    @NotNull
    @ApiModelProperty(value="主键Id",required = true,example = "1")
    private Integer id;//id

    @NotNull
    @ApiModelProperty(value="取票号码",required = true,example = "JC0001")
    private String no;//取票号码


    @NotNull
    @ApiModelProperty(value="排队序号",required = true,example = "1")
    private Integer orderNum;//排队序号

    @NotNull
    @ApiModelProperty(value="取票时间",required = true,example = "2021-06-23 19:03:30")
    private String createTime;//取票时间

    @NotNull
    @ApiModelProperty(value="检查类型",required = true,example = "1")
    private String examineType;//检查类型


    @NotNull
    @ApiModelProperty(value="命令模式构造注入",hidden = true)
    private ExamineProofCommandHandle handle;



    public ExamineProofCommand(){
        handle = ApplicationContextHolder
                .getApplicationContext()
                .getBean(ExamineProofCommandHandle.class);
    }

    public ExamineProofCommand(Integer id, String no, Integer orderNum, String createTime, String examineType) {
        this();
        this.id = id;
        this.no = no;
        this.orderNum = orderNum;
        this.createTime = createTime;
        this.examineType = examineType;
    }

    /**
     * 执行命令
     * @return
     */
    public ResponseResult<ExamineProofCommand> execute(){

        return handle.add(this);
    }


}
