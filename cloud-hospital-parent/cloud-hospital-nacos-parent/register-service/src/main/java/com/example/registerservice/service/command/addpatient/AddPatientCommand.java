package com.example.registerservice.service.command.addpatient;

import com.example.registerservice.inlet.web.vo.PatientVo;
import com.example.registerservice.service.api.IAddPatientCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import com.example.registerservice.util.PatientUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:14
 * @Description:
 */
@Data
public class AddPatientCommand implements Serializable {
    private Long id;//添加成功返回患者的Id

    private String no;//病人编号
    private String status;//病人状态(0、待就诊 1、已就诊)
    private Date createtime;//病人建档时间
    private String medicard;//病人医保卡


    /**
     * ControllerVo注入进来的值
     */
    private String name;//患者姓名

    private Integer age;//患者年龄

    private String gender;//患者性别

    private String phone;//患者电话

    private String identityId;//患者身份证

    private IAddPatientCommandHandler handler;

    public AddPatientCommand(PatientVo vo) {
        this();
        this.name = vo.getName();
        this.age = vo.getAge();
        this.gender = vo.getGender();
        this.phone = vo.getPhone();
        this.identityId = vo.getIdentityId();
        //下面的是系统自动生成赋的值
        this.no = PatientUtil.getPatientNo();
        this.status = "0";//默认待就诊
        this.createtime = new Date();//系统时间
//        this.medicard=null;//默认没有医保卡
    }

    public AddPatientCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IAddPatientCommandHandler.class);
    }

    public Long execute() {
        Long patientId = handler.action(this);
        return patientId;
    }
}
