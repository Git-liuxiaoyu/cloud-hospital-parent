package com.example.takenumberservice.service.command.addCallProof;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;
import com.example.takenumberservice.util.ApplicationContextHolder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

@Data
@Slf4j
@AllArgsConstructor
public class ProofCommand {
    @NotNull
    @ApiModelProperty(value="主键",required = true,example = "1")
    private Long id;//id

    @NotNull
    @ApiModelProperty(value="挂号Id",required = true,example = "12")
    private Long regId;//挂号id

    @NotNull
    @ApiModelProperty(value="取票码",required = true,example = "GH1018")
    private String no;//取票码


    @NotNull
    @ApiModelProperty(value="科室id",required = true,example = "1")
    private Integer departmentId;//科室id

    @NotNull
    @ApiModelProperty(value="房间名",required = true,example = "诊室1")
    private String roomName;//房间名

    @NotNull
    @ApiModelProperty(value="排队序号",required = true,example = "2")
    private Integer orderNum;//排队序号

    @NotNull
    @ApiModelProperty(value="取票时间",required = true,example = "2021-06-23 19:03:30")
    private String createTime;//取票时间

    @NotNull
    @ApiModelProperty(value="取票状态",required = true,example = "1")
    private String status;//取票状态


    @NotNull
    @ApiModelProperty(value="命令模式构造注入",hidden = true)
    private ProofCommandHandle handler;

    public ProofCommand(){
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(ProofCommandHandle.class);
    }

    public ProofCommand(Long id, Long regId, String no, Integer departmentId, String roomName, Integer orderNum, String createTime, String status) {
        this();
        this.id = id;
        this.regId = regId;
        this.no = no;
        this.departmentId = departmentId;
        this.roomName = roomName;
        this.orderNum = orderNum;
        this.createTime = createTime;
        this.status = status;
    }

    /**
     * 添加进取号表
     * @return
     */
    public ResponseResult<ProofCommand> execute(RegisterCommand findbyno){
        return handler.add(findbyno);
    }
}
