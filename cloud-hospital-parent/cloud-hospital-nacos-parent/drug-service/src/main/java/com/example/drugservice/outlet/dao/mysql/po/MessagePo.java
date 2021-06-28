package com.example.drugservice.outlet.dao.mysql.po;

public class MessagePo {

    public static final String UN_SEND = "未发送";
    public static final String RABBITMQ_RECEIVED = "RabbitMQ已接受";
    public static final String RETRY_ERROR = "重试次数耗尽";

    //rabbitmq未成功接收消息 可能交换机不存在
    public static final String MESSAGE_STATE_SEND_FAILURE = "发送失败";

    public static final String MESSAGE_STATE_SUCCESS = "消费者接收成功";

    public static final String MESSAGE_STATE_RECEIVED_FAILURE = "消费者接收失败";

    //业务执行结束
    public static final String MESSAGE_STATE_CONSUMED = "已消费";



    private Long id;

    private String exchange;

    private String routingKey;

    private String messageContent;

    private String status;

    private Integer retryCount;

    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange == null ? null : exchange.trim();
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey == null ? null : routingKey.trim();
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}