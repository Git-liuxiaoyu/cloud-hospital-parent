package com.example.workerservice.outlet.dao.mysql.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MessagePo {
    private Long id;

    private String exchange;

    private String routingKey;

    private String messageContent;

    private String status;

    private Integer retryCount;

    private Long version;

    public static final String NOT_SEND = "1";

    public static final String SEND_TO_EX_FAIL = "2";

    public static final String SEND_TO_EX_SUCCESS = "3";

    public static final String SEND_TO_Q_FAIL = "4";

    public static final String SEND_TO_Q_SUCCESS = "5";

    public static final String COMSUME_SUCCESS = "6";

    public static final String COMSUME_FAIL = "7";

}