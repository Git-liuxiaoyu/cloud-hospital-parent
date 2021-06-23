package com.example.takenumberservice.inlet.web.controller.vo;


import com.example.takenumberservice.inlet.web.ResponseResult;
import com.example.takenumberservice.service.command.addexamineProof.ExamineProofCommandHandle;
import com.example.takenumberservice.util.ApplicationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamineProofVo {

    private Integer id;//id
    private String no;//取票号码
    private Integer orderNum;//排队序号
    private String createTime;//取票时间
    private String examineType;//检查类型




}
