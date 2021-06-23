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
@Document(indexName = "drug", replicas = 0, shards = 1)
public class DrugEsPo {
    @Id
    private String id;
    @Field(name = "name",type = FieldType.Text,analyzer = "ik_smart")
    private String name;

    @Field(name = "no", type = FieldType.Keyword)
    private String no;

    @Field(name = "typeName", type = FieldType.Keyword)
    private String typeName;

    @Field(name = "stock", type = FieldType.Keyword)
    private Integer stock;

    @Field(name = "saleprice", type = FieldType.Keyword)
    private BigDecimal saleprice;
    @Field(name = "costprice", type = FieldType.Keyword)
    private BigDecimal costprice;

    @Field(name = "location", type = FieldType.Keyword)
    private String location;

    @Field(name = "productiontime", type = FieldType.Keyword)
    private Date productiontime;

    @Field(name = "expirationtime", type = FieldType.Keyword)
    private Date expirationtime;

    @Field(name = "status", type = FieldType.Keyword)
    private String status;
}
