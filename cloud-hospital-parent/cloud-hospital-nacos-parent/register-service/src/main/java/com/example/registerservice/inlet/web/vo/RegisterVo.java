package com.example.registerservice.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/18/18:22
 * @Description: 根据no查询挂号表的消息对象
 */
@Data
@ApiModel
public class RegisterVo {

    @NotNull
    @ApiModelProperty(value = "挂号id", required = true)
    private Long id;//挂号id

    @NotNull
    @ApiModelProperty(value = "患者id", required = true)
    private Long patientId;//患者id

    @NotNull
    @ApiModelProperty(value = "挂号编码", required = true)
    private String no;//挂号编码

    @NotNull
    @ApiModelProperty(value = "科室id", required = true)
    private Integer departmentId;//科室id

    @NotNull
    @ApiModelProperty(value = "排班id", required = true)
    private Long rotaId;//排班id

    @NotNull
    @ApiModelProperty(value = "就诊时间段", required = true)
    private String visitSection;//就诊时间段（1、上午，2、下午）

    @NotNull
    @ApiModelProperty(value = "挂号状态", required = true)
    private String status;//挂号状态（0、未付款；1、以退款；2、付款失败；3、已付款；4、待初诊；5、初诊失约；6、待复诊；7、复诊失约）


    /**
     * 添加挂号的vo对象
     */
    @Data
    public static class AddRegisterVo {
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
    }

    /**
     * 查询挂号的vo对象
     */
    @Data
    public static class QueryRegisterVo {
        private Long id;//挂号的id
        private String no;//挂号的编号
        private Date regTime;//挂号的时间
        private String departmentName;//科目名字
        private BigDecimal price;//挂号费用
        private String doctorName;//医生名字
        private String type;//挂号类型 （1、线上，2、线下）
        private String status;//挂号状态
        private String name;//患者名字
    }

    /**
     * 根据挂号id查询挂号详细对象
     */
    @Data
    public static class QueryGetByIdVo {
        @NotNull
        @ApiModelProperty(value = "挂号id", required = true)
        private Long id;
        @NotNull
        @ApiModelProperty(value = "挂号编号", required = true)
        private String no;
        @NotNull
        @ApiModelProperty(value = "患者id", required = true)
        private Long patientid;
        @NotNull
        @ApiModelProperty(value = "挂号类型（1.专家/2.普通）", required = true)
        private String regtype;
        @NotNull
        @ApiModelProperty(value = "挂号时间（病人挂号的时间）", required = true)
        private Date regtime;
        @NotNull
        @ApiModelProperty(value = "外键-选择排班的排班ID", required = true)
        private Long rotaid;
        @NotNull
        @ApiModelProperty(value = "外键-科室ID", required = true)
        private Integer departmentid;
        @NotNull
        @ApiModelProperty(value = "外键-房间ID", required = true)
        private Integer roomid;
        @NotNull
        @ApiModelProperty(value = "挂号的就诊时间", required = true)
        private Date visittime;
        @NotNull
        @ApiModelProperty(value = "就诊时间段（1、上午，2、下午）", required = true)
        private String visitsection;
        @NotNull
        @ApiModelProperty(value = "挂号费", required = true)
        private BigDecimal price;
        @NotNull
        @ApiModelProperty(value = "挂号类型（1、线上，2、线下）", required = true)
        private String type;
        @NotNull
        @ApiModelProperty(value = "挂号状态", required = true)
        private String status;
        @NotNull
        @ApiModelProperty(value = "登入的手机号，用于查看订单的", required = true)
        private String phone;
    }
}
