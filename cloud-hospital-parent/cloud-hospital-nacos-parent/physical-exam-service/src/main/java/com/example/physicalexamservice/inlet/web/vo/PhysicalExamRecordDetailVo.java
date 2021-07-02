package com.example.physicalexamservice.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhysicalExamRecordDetailVo {

    private Long id;

    private Long recordid;

    private Integer typeid;

    private String typeName;

    private Integer examid;

    private String examName;

    private Integer count;

    private BigDecimal price;

    private Date examtime;

    private String resultfile;

    private String resulttext;

    private Integer examdocid;

    private String examDocName;

    private String status;

    public static final String STATUS_NOTEXAM = "0";

    public static final String STATUS_EXAMED = "1";

}
