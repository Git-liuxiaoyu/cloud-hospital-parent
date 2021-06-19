package com.example.takenumberservice.service.command.addProof;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.findregister.RegisterCommand;
import com.example.takenumberservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
public class ProofCommand {
    private Long id;//id
    private Long regId;//挂号id
    private Integer departmentId;//可是id
    private String roomName;//房间名
    private Integer orderNum;//排队序号
    private String createTime;//取票时间
    private String status;//取票状态

    private String no;//取票码

    private ProofCommandHandle handler;

    public ProofCommand(){
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(ProofCommandHandle.class);
    }

    public ProofCommand(Long id, Long regId, Integer departmentId, String roomName, Integer orderNum, String createTime, String status) {
        this();
        this.id = id;
        this.regId = regId;
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
