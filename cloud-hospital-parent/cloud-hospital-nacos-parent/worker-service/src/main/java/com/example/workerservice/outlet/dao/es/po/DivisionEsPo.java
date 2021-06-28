package com.example.workerservice.outlet.dao.es.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author Alnwick11AtoZ 松
 * @date 2021/6/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "division", shards = 1, replicas = 0)
public class DivisionEsPo {

    @Id
    @Field(name = "id", type = FieldType.Integer)
    private Integer id;

    @Field(name = "name", type = FieldType.Keyword)
    private String name;

    @Field(name = "description", type = FieldType.Text, analyzer = "ik_smart")
    private String description;

    @Field(name = "status", type = FieldType.Keyword)
    private String status;
}
