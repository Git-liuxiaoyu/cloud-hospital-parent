package com.example.takenumberservice.service.command.addexamineProof;


import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addPharmacyProof.PharmacyProofCommand;
import com.example.takenumberservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ExamineProofCommand {

    private Integer id;//id
    private String no;//取票号码
    private Integer orderNum;//排队序号
    private String createTime;//取票时间
    private String examineType;//检查类型

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
