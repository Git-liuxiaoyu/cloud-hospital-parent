package com.example.takenumberservice.service.command.findregister;

import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addCallProof.ProofCommand;
import com.example.takenumberservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 挂号表实体类
 */
@Data
@Slf4j
@AllArgsConstructor
public class RegisterCommand {

    private Long id;//挂号id
    private String no;//挂号编码
    private Long patientId;//病人id
    private Long rotaId;//排班id
    private Integer departmentId;//科室id
    private Integer roomId;//房间id
    private String visitSection;//就诊时间段（1、上午，2、下午）
    private String status;//挂号状态（0、未付款；1、以退款；2、付款失败；3、已付款；4、已取初诊票；5、初诊失约；6、待复诊；7、已取复诊票；8、复诊失约）

    private RegisterCommandHandle handle;

    public RegisterCommand(){
        handle = ApplicationContextHolder
        .getApplicationContext()
        .getBean(RegisterCommandHandle.class);
    }

    public RegisterCommand(Long id, String no, Integer departmentId, Integer roomId,String visitSection,String status,Long patientId) {
        this();
        this.id = id;
        this.no = no;
        this.patientId = patientId;
        this.departmentId = departmentId;
        this.roomId = roomId;
        this.visitSection = visitSection;
        this.status = status;
    }

    /**
     * 通过挂号编码获得挂号相关信息
     * @return
     */
    public ResponseResult<ProofCommand> execute(){
        return handle.findbyno(this.no);
    }
}
