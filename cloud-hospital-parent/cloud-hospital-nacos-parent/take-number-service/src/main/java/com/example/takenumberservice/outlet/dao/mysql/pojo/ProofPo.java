package com.example.takenumberservice.outlet.dao.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据库实体类pojo
 */
public class ProofPo {
    private Integer id;//id
    private Integer regId;//挂号id
    private Integer departmentId;//科室id
    private String roomName;//房间名
    private Integer orderNum;//排队序号
    private String createTime;//取票时间
    private char status;//取票状态

    public ProofPo() {
    }

    public ProofPo(Integer id, Integer regId, Integer departmentId, String roomName, Integer orderNum, String createTime, char status) {
        this.id = id;
        this.regId = regId;
        this.departmentId = departmentId;
        this.roomName = roomName;
        this.orderNum = orderNum;
        this.createTime = createTime;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProofPo{" +
                "id=" + id +
                ", regId=" + regId +
                ", departmentId=" + departmentId +
                ", roomName='" + roomName + '\'' +
                ", orderNum=" + orderNum +
                ", createTime='" + createTime + '\'' +
                ", status=" + status +
                '}';
    }
}