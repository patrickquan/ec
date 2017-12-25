package com.yangcl.ec.common.entity;

import java.util.Date;

public class BaseEntity {
    private Integer  status;
    private Boolean isDel;
    private Integer  version;
    private Date createdAt;
    private Date updatedAt;

    public Integer  getStatus() {
        return status;
    }

    public void setStatus(Integer  status) {
        this.status = status;
    }

    public Boolean isDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }

    public Integer  getVersion() {
        return version;
    }

    public void setVersion(Integer  version) {
        this.version = version;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
