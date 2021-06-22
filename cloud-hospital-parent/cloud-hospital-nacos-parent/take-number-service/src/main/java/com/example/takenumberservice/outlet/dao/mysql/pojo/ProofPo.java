package com.example.takenumberservice.outlet.dao.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据库实体类pojo
 */
public class ProofPo {
    private Long id;//id
    private Long regId;//挂号id
    private String no;//取票no
    private Integer departmentId;//科室id
    private String roomName;//房间名
    private Integer orderNum;//排队序号
    private String createTime;//取票时间
    private String status;//取票状态

    public ProofPo() {
    }

    public ProofPo(Long id, Long regId, Integer departmentId, String roomName, Integer orderNum, String createTime, String status,String no) {
        this.id = id;
        this.regId = regId;
        this.no = no;
        this.departmentId = departmentId;
        this.roomName = roomName;
        this.orderNum = orderNum;
        this.createTime = createTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }


}