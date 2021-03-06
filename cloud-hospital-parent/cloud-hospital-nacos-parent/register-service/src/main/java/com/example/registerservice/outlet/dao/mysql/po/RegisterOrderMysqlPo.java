package com.example.registerservice.outlet.dao.mysql.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/23:16
 * @Description:
 */
@Data
public class RegisterOrderMysqlPo {

    private Long id;//挂号的id
    private String no;//挂号的编号
    private Date regTime;//挂号的时间
    private String departmentId;//科目Id
    private String rotaId;//排班id
    private BigDecimal price;//挂号费用
    private String type;//挂号类型 （1、线上，2、线下）
    private String status;//挂号状态
    private String name;//患者名字


}
