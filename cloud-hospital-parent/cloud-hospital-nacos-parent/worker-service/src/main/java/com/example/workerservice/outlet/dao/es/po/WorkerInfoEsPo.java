package com.example.workerservice.outlet.dao.es.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * 实体类 - EsPo - WorkerInfo
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "worker_info", shards = 1, replicas = 0)
public class WorkerInfoEsPo {

    @Id
    @Field(name = "id", type = FieldType.Integer)
    private Integer id;

    @Field(name = "no", type = FieldType.Keyword)
    private String no;

    @Field(name = "name", type = FieldType.Keyword)
    private String name;

    @Field(name = "birthday", type = FieldType.Date, format = DateFormat.date)
    private Date birthday;

    @Field(name = "gender", type = FieldType.Keyword)
    private String gender;

    @Field(name = "identityno", type = FieldType.Keyword)
    private String identityno;

    @Field(name = "topeducation", type = FieldType.Text, analyzer = "ik_smart")
    private String topeducation;

    @Field(name = "career", type = FieldType.Text, analyzer = "ik_smart")
    private String career;

    @Field(name = "departmentid", type = FieldType.Integer)
    private Integer departmentid;

    private DepartmentEsPo department;

    @Field(name = "positionid", type = FieldType.Integer)
    private Integer positionid;

    private PositionEsPo position;

    @Field(name = "signtime", type = FieldType.Date, format = DateFormat.date)
    private Date signtime;

    @Field(name = "resigntime", type = FieldType.Date, format = DateFormat.date)
    private Date resigntime;

    @Field(name = "avatar", type = FieldType.Keyword)
    private String avatar;

    @Field(name = "status", type = FieldType.Keyword)
    private String status;

    @Field(name = "phone", type = FieldType.Keyword)
    private String phone;

}
