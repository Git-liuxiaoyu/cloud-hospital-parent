package com.example.drugservice.outlet.dao.es.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "drugInstockOdd", replicas = 0, shards = 1)
public class DrugInstockOddEsPo {

    @Id
    private String id;
    @Field(name = "no", type = FieldType.Keyword)
    private String no;
    @Field(name = "instockperson",type = FieldType.Text,analyzer = "ik_smart")
    private String instockperson;
    @Field(name = "createtime", type = FieldType.Keyword)
    private Date createtime;
    @Field(name = "status", type = FieldType.Keyword)
    private String status;
}
