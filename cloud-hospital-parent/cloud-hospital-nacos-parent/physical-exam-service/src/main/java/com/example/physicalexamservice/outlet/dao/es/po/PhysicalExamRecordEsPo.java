package com.example.physicalexamservice.outlet.dao.es.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * 实体类 - EsPo - PhysicalExamRecord
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "physical_exam_record", replicas = 1, shards = 3)
public class PhysicalExamRecordEsPo {

    @Id
    @Field(name = "id", type = FieldType.Long)
    private Long id;

    @Field(name = "no", type = FieldType.Keyword)
    private String no;

    @Field(name = "treatrecordid", type = FieldType.Long)
    private Long treatrecordid;

    @Field(name = "treatrecordid", type = FieldType.Integer)
    private Integer doctorid;

    @Field(name = "treatrecordid", type = FieldType.Long)
    private Long patientid;

    @Field(name = "createtime", type = FieldType.Date_Range)
    private Date createtime;

    @Field(name = "status", type = FieldType.Keyword)
    private String status;

}
