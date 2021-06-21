package com.example.registerservice.service.command.addRegister;

import com.example.registerservice.inlet.web.vo.RegisterVo;
import com.example.registerservice.service.api.IAddRegisterCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import com.example.registerservice.util.RegisterUtil;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/15:34
 * @Description:
 */
@Data
public class AddRegisterCommand implements Serializable {
    private String  no;//挂号编码
    private Long patientId;//患者id
    private String regType;//挂号类型（1.专家/2.普通）
    private Date regTime;//挂号时间（病人挂号的时间）
    private Long rotaId;//排班id
    private Integer departmentId;//科室Id
    private String visitSection;
    private BigDecimal price;//挂号费用
    private String type;//挂号类型（1、线上，2、线下）
    private String status;//挂号状态

    private Date visitTime;//挂号的就诊时间

    private IAddRegisterCommandHandler handler;


    public AddRegisterCommand(RegisterVo.AddRegisterVo vo) {
        this();
        this.no= RegisterUtil.getRegisterNo();//生成随机的挂号No
        this.patientId = vo.getPatientId();//患者id
        this.regType = vo.getRegType();//挂号类型（1.专家/2.普通）
        this.regTime=new Date();//挂号时间（病人挂号的时间）
        this.rotaId = vo.getRotaId();//排班id
        this.departmentId = vo.getDepartmentId();//科室Id
        this.visitTime = vo.getVisitTime();//挂号的就诊时间
        this.visitSection = vo.getVisitSection();////就诊时间段（1、上午，2、下午）
        if (this.regType.equals("1")) {
            this.price = new BigDecimal(10.00); //挂号费用（普通5元，专家10元）
        }else {
            this.price = new BigDecimal(5.00);
        }
        this.type = vo.getType();//挂号类型（1、线上，2、线下）
        this.status = "0";//挂号状态 默认没有付款
    }

    public AddRegisterCommand() {
        handler = ApplicationContextHolder.getApplicationContext().getBean(IAddRegisterCommandHandler.class);
    }

    public void execute() {
        handler.action(this);
    }
}
