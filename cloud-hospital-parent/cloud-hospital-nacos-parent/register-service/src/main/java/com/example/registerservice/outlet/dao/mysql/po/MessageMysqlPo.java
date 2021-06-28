package com.example.registerservice.outlet.dao.mysql.po;


import lombok.Data;

@Data
public class MessageMysqlPo {
    private Long id;

    private String exchange;

    private String routingKey;

    private String messageContent;

    private String status;

    private Integer retryCount;

    private Long version;

}