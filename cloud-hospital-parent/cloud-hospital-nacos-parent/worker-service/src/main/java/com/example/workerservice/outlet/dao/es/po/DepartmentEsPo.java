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
@Document(indexName = "department", shards = 1, replicas = 0)
public class DepartmentEsPo {

    @Id
    @Field(name = "id", type = FieldType.Integer)
    private Integer id;

    @Field(name = "divisionid;", type = FieldType.Integer)
    private Integer divisionid;

    @Field(name = "no;", type = FieldType.Keyword)
    private String no;

    @Field(name = "name;", type = FieldType.Text, analyzer = "ik_smart")
    private String name;

    @Field(name = "directorid;", type = FieldType.Long)
    private Long directorid;

    @Field(name = "location;", type = FieldType.Text, analyzer = "ik_smart")
    private String location;

    @Field(name = "phone;", type = FieldType.Keyword)
    private String phone;

    @Field(name = "description;", type = FieldType.Text, analyzer = "ik_smart")
    private String description;

    @Field(name = "status;", type = FieldType.Keyword)
    private String status;

}
