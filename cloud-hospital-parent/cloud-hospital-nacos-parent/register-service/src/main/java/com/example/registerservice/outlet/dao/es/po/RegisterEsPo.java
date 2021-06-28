package com.example.registerservice.outlet.dao.es.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/25/14:51
 * @Description: 挂号的RegisterRedisPo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "register", shards = 1, replicas = 0)
public class RegisterEsPo {
    @Id
    @Field(name = "id", type = FieldType.Long)
    private Long id;
    @Field(name = "no", type = FieldType.Keyword)
    private String no;
    @Field(name = "patientid", type = FieldType.Long)
    private Long patientid;
    @Field(name = "regtype", type = FieldType.Keyword)
    private String regtype;
    @Field(name = "regtime", type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regtime;
    @Field(name = "rotaid", type = FieldType.Long)
    private Long rotaid;
    @Field(name = "departmentid", type = FieldType.Integer)
    private Integer departmentid;
    @Field(name = "roomid", type = FieldType.Integer)
    private Integer roomid;
    @Field(name = "visittime", type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd")
    private Date visittime;
    @Field(name = "visitsection", type = FieldType.Keyword)
    private String visitsection;
    @Field(name = "price", type = FieldType.Double)
    private BigDecimal price;
    @Field(name = "type", type = FieldType.Keyword)
    private String type;
    @Field(name = "status", type = FieldType.Keyword)
    private String status;
    @Field(name = "phone", type = FieldType.Keyword)
    private String phone;
}
