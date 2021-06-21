package com.example.registerservice.inlet.web.vo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:07
 * @Description: 病人对象
 */
@Data
public class PatientVo {
    private Long id;//添加成功返回患者的Id
    private String name;//患者姓名
    private Integer age;//患者年龄
    private String gender;//患者性别
    private String phone;//患者电话
    private String identityId;//患者身份证
}
