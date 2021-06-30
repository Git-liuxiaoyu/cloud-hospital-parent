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

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/28
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "physical_exam", replicas = 1, shards = 3)
public class PhysicalExamEsPo {

    @Id
    @Field(name = "id", type = FieldType.Integer)
    private Integer id;

    @Field(name = "no", type = FieldType.Keyword)
    private String no;

    @Field(name = "typeid", type = FieldType.Integer)
    private Integer typeid;

    @Field(name = "name", type = FieldType.Keyword)
    private String name;

    @Field(name = "price", type = FieldType.Double)
    private BigDecimal price;

    @Field(name = "leftstock", type = FieldType.Long)
    private Long leftstock;

    @Field(name = "maxstock", type = FieldType.Long)
    private Long maxstock;

    @Field(name = "status", type = FieldType.Keyword)
    private String status;

}
