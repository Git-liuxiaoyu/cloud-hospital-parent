package com.example.registerservice.service.command.addRegister;

import com.example.registerservice.service.api.IAddRegisterCommandHandler;
import com.example.registerservice.util.ApplicationContextHolder;
import com.example.registerservice.util.RegisterUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

import static com.example.registerservice.outlet.publisher.api.IAddRegisterOrderEventPublisher.AddRegisterOrderCommandCompletedEvent;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/15:34
 * @Description:
 */
@Data
public class AddRegisterCommand {
    @ApiModelProperty(value = "挂号编码", hidden = true)
    private String no;//挂号编码
    @ApiModelProperty(value = "挂号费用", hidden = true)
    private BigDecimal price;//挂号费用
    @ApiModelProperty(value = "挂号状态", hidden = true)
    private String status;//挂号状态
    @ApiModelProperty(value = "挂号时间", hidden = true)
    private Date regTime;//挂号状态

    @NotNull
    @ApiModelProperty(value = "患者id", required = true)
    private Long patientId;//患者id

    @NotNull
    @ApiModelProperty(value = "挂号类型（1.专家/2.普通）", required = true)
    private String regType;//挂号类型（1.专家/2.普通）

    @NotNull
    @ApiModelProperty(value = "排班id", required = true)
    private Long rotaId;//排班id

    @NotNull
    @ApiModelProperty(value = "挂号的就诊时间", required = true)
    private Date visitTime;//挂号的就诊时间

    @NotNull
    @ApiModelProperty(value = "房间Id", required = true)
    private Integer roomId;//房间Id

    @NotNull
    @ApiModelProperty(value = "科室Id", required = true)
    private Integer departmentId;//科室Id
    @NotNull
    @ApiModelProperty(value = "就诊时间段（1、上午，2、下午）", required = true)
    private String visitSection;//就诊时间段（1、上午，2、下午）
    @NotNull
    @ApiModelProperty(value = "挂号类型（1、线上，2、线下）", required = true)
    private String type;//挂号类型（1、线上，2、线下）
    @NotNull
    @ApiModelProperty(value = "登入的手机号", required = true)
    private String phone;//登入的手机号


    @ApiModelProperty(value = "登入的手机号", hidden = true)
    private IAddRegisterCommandHandler handler;

    public AddRegisterCommand() {
        handler = ApplicationContextHolder
                .getApplicationContext()
                .getBean(IAddRegisterCommandHandler.class);
    }

    public void execute() {
        /*生成随机订单号*/
        this.no = RegisterUtil.getRegisterNo();
        if (this.regType.equals("1")) {
            this.price = new BigDecimal(10.00); //挂号费用（普通5元，专家10元）
        } else {
            this.price = new BigDecimal(5.00);
        }
        this.status = "0";//挂号状态 默认没有付款
        this.regTime = new Date();//挂号时间
        handler.action(this);
        //执行发消息
        AddRegisterOrderCommandCompletedEvent event = new AddRegisterOrderCommandCompletedEvent(this.getNo());
        ApplicationContextHolder.getApplicationContext().publishEvent(event);
    }
}
