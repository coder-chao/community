package com.nowcoder.community.entity;


import java.util.Date;

public class Record {

    private int id;
    private int userId;
    private int entityType;
    private int entityId;
    private int operaType;

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", userId=" + userId +
                ", entityType=" + entityType +
                ", entityId=" + entityId +
                ", operaType=" + operaType +
                ", createTime=" + createTime +
                '}';
    }

    public int getEntityType() {
        return entityType;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

    public int getOperaType() {
        return operaType;
    }

    public void setOperaType(int operaType) {
        this.operaType = operaType;
    }

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
