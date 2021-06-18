package com.example.registerservice.inlet.web.vo;

import lombok.Data;

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
    private String no;//挂号编码
    private Integer departmentId;//科室id
    private Integer roomId;//房间id
    private String visitSection;//就诊时间段（1、上午，2、下午）
    private String status;//挂号状态（0、未付款；1、以退款；2、付款失败；3、已付款；4、待初诊；5、初诊失约；6、待复诊；7、复诊失约）
}
