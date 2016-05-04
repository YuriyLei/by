package com.yulei.demo.common;

import com.google.common.base.Objects;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<ID extends Serializable> implements Persistable<ID> {

    private static final long serialVersionUID = 1L;

    public static final String YES = "1";
    public static final String NO = "0";

    public static final String DELETED = "1";
    public static final String UNDELETED = "0";

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected ID id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    @CreatedDate
    private Date createdAt;

    @Column(name="created_by")
    @CreatedBy
    private Long createdBy;

    private String deleted = UNDELETED;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    @LastModifiedDate
    private Date updatedAt;

    @Column(name="updated_by")
    @LastModifiedBy
    private Long updatedBy;

    @Version
    private int version;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public boolean isNew() {
        return null == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof BaseEntity) {
            BaseEntity<?> that = (BaseEntity<?>) object;
            return Objects.equal(this.id, that.id);
        }
        return false;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}

