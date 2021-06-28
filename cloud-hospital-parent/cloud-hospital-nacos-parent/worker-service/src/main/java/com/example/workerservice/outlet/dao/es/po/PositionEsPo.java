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
 * @date 2021/6/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "position", shards = 1, replicas = 0)
public class PositionEsPo {

    @Id
    @Field(name = "id", type = FieldType.Integer)
    private Integer id;

    @Field(name = "type", type = FieldType.Keyword)
    private String type;

    @Field(name = "level", type = FieldType.Keyword)
    private String level;

    @Field(name = "isout", type = FieldType.Keyword)
    private String isout;

    @Field(name = "isin", type = FieldType.Keyword)
    private String isin;

    @Field(name = "ismdc", type = FieldType.Keyword)
    private String ismdc;

    @Field(name = "isexam", type = FieldType.Keyword)
    private String isexam;

    @Field(name = "status", type = FieldType.Keyword)
    private String status;

}
