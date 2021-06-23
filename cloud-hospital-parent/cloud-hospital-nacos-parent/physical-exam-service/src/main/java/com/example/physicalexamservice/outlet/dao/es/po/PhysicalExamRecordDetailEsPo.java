package com.example.physicalexamservice.outlet.dao.es.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体类 - EsPo - PhysicalExamRecordDetail
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "physical_exam_record_detail", replicas = 1, shards = 3)
public class PhysicalExamRecordDetailEsPo {

    @Id
    @Field(name = "id", type = FieldType.Long)
    private Long id;

    @Field(name = "recordid", type = FieldType.Long)
    private Long recordid;

    @Field(name = "typeid", type = FieldType.Integer)
    private Integer typeid;

    @Field(name = "examid", type = FieldType.Integer)
    private Integer examid;

    @Field(name = "count", type = FieldType.Integer)
    private Integer count;

    @Field(name = "price", type = FieldType.Double_Range)
    private BigDecimal price;

    @Field(name = "examtime", type = FieldType.Date_Range)
    private Date examtime;

}
