package es.jmpg.developer.fintech.database;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class AuditableEntity<U> implements Serializable {

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "created_by", nullable = false, updatable = false)
    private U createdBy;

    @Column(name = "updated_by", nullable = false)
    private U updatedBy;

    @PrePersist
    protected void onCreate() {
        updatedAt = createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
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

    public U getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(U createdBy) {
        this.createdBy = createdBy;
    }

    public U getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(U updatedBy) {
        this.updatedBy = updatedBy;
    }
}
