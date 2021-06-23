package com.example.registerservice.inlet.web.vo;

import lombok.Data;

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
public class RegisterVo {
    private Long id;//挂号id
    private Long patientId;//患者id
    private String no;//挂号编码
    private Integer departmentId;//科室id
    private Long rotaId;//排班id
    private String visitSection;//就诊时间段（1、上午，2、下午）
    private String status;//挂号状态（0、未付款；1、以退款；2、付款失败；3、已付款；4、待初诊；5、初诊失约；6、待复诊；7、复诊失约）


    /**
     * 添加挂号的vo对象
     */
    @Data
    public static class AddRegisterVo {
        private Long patientId;//患者id
        private String regType;//挂号类型（1.专家/2.普通）
        private Long rotaId;//排班id
        private Date visitTime;//挂号的就诊时间
        private Integer departmentId;//科室Id
        private String visitSection;//就诊时间段（1、上午，2、下午）
        private String type;//挂号类型（1、线上，2、线下）
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
        private Long id;
        private String no;
        private Long patientid;
        private String regtype;
        private Date regtime;
        private Long rotaid;
        private Integer departmentid;
        private Integer roomid;
        private Date visittime;
        private String visitsection;
        private BigDecimal price;
        private String type;
        private String status;
        private String phone;
    }
}
