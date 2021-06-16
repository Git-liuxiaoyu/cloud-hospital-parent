package com.example.takenumberservice.service.command;

import com.example.takenumberservice.inlet.web.vo.ProofControllerVo;
import com.example.takenumberservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
public class ProofCommand {
    private Integer id;//id
    private Integer regId;//挂号id
    private Integer departmentId;//可是id
    private String roomName;//房间名
    private Integer orderNum;//排队序号
    private String createTime;//取票时间
    private char status;//取票状态

    private ProofCommandHandler handler;

    public ProofCommand(){
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(ProofCommandHandler.class);
    }

    public ProofCommand(Integer id, Integer regId, Integer departmentId, String roomName, Integer orderNum, String createTime, char status) {
        this();
        this.id = id;
        this.regId = regId;
        this.departmentId = departmentId;
        this.roomName = roomName;
        this.orderNum = orderNum;
        this.createTime = createTime;
        this.status = status;
    }

    public ProofControllerVo execute(){
        log.info("执行查询取号信息功能");
        ProofControllerVo ProofControllerVo = handler.findbyregId(this.id);
        return ProofControllerVo;
    }
}
