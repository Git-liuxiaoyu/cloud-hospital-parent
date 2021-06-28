package com.example.workerservice.outlet.dao.es.po;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
@Document(indexName = "doctor_rota", shards = 1, replicas = 0)
public class DoctorRotaEsPo {

    @Id
    @Field(name = "id", type = FieldType.Long)
    private Long id;

    @Field(name = "departmentid", type = FieldType.Integer)
    private Integer departmentid;

    @Field(name = "date", type = FieldType.Date, format = DateFormat.date_hour_minute)
    private Date date;

    @Field(name = "rotatype", type = FieldType.Keyword)
    private String rotatype;

    @Field(name = "shifttype", type = FieldType.Keyword)
    private String shifttype;

    @Field(name = "doctorid", type = FieldType.Integer)
    private Integer doctorid;

    private WorkerInfoEsPo workerInfo;

    private DepartmentEsPo department;

    @Field(name = "leftpatient", type = FieldType.Integer)
    private Integer leftpatient;

    @Field(name = "maxpatient", type = FieldType.Integer)
    private Integer maxpatient;

    @Field(name = "roomid", type = FieldType.Integer)
    private Integer roomid;

    @Field(name = "createid", type = FieldType.Integer)
    private Integer createid;

    @Field(name = "createtime", type = FieldType.Date, format = DateFormat.hour_minute_second)
    private Date createtime;

    @Field(name = "createtime", type = FieldType.Date, format = DateFormat.hour_minute_second)
    private String status;

}
