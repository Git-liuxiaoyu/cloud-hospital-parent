package com.example.takenumberservice.outlet.dao.mysql.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamineProofPo {

    private Integer id;//id
    private String no;//取票号码
    private Integer orderNum;//排队序号
    private String createTime;//取票时间
    private String examineType;//检查类型




}
