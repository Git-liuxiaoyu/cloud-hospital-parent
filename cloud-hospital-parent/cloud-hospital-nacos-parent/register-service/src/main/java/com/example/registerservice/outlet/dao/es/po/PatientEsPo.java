package com.example.registerservice.outlet.dao.es.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/25/14:51
 * @Description:患者的PatientRedisPo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "patient", shards = 1, replicas = 0)
public class PatientEsPo {

    @Id
    @Field(name = "id", type = FieldType.Long)
    private Long id;

    @Field(name = "no", type = FieldType.Keyword)
    private String no;

    @Field(name = "name", type = FieldType.Keyword)
    private String name;

    @Field(name = "age", type = FieldType.Integer)
    private Integer age;

    @Field(name = "gender", type = FieldType.Keyword)
    private String gender;

    @Field(name = "phone", type = FieldType.Keyword)
    private String phone;

    @Field(name = "identityid", type = FieldType.Keyword)
    private String identityid;

    @Field(name = "status", type = FieldType.Keyword)
    private String status;

    @Field(name = "createtime", type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    @Field(name = "medicard", type = FieldType.Keyword)
    private String medicard;
}
