package com.example.registerservice.service.command.updatepatient;

import com.example.registerservice.inlet.web.vo.PatientVo;
import com.example.registerservice.service.api.IUpdatePatientCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/23/14:42
 * @Description:
 */
@Data
public class UpdatePatientCommand {

    private Long id;//添加成功返回患者的Id
    private String name;//患者姓名
    private Integer age;//患者年龄
    private String gender;//患者性别
    private String phone;//患者电话
    private String identityId;//患者身份证

    private IUpdatePatientCommandHandler handler;

    public UpdatePatientCommand(PatientVo vo) {
        this();
        this.id = vo.getId();
        this.name = vo.getName();
        this.age = vo.getAge();
        this.gender = vo.getGender();
        this.phone = vo.getPhone();
        this.identityId = vo.getIdentityId();
    }

    public UpdatePatientCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IUpdatePatientCommandHandler.class);
    }

    public void execute() {
        handler.action(this);
    }
}
