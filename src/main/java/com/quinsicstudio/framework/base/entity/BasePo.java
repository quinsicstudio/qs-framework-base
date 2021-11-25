package com.quinsicstudio.framework.base.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@EntityListeners(value = AuditingEntityListener.class)
public class BasePo implements Serializable {
    @Version
    @Column(name = "version")
    protected int version;

    @Column(name = "created_dt")
    @CreatedDate
    protected Date createdDatetime;

    @Column(name = "updated_dt")
    @LastModifiedDate
    protected Date lastModifiedDatetime;

    @Column(name = "created_by")
    @CreatedBy
    protected Long createdBy;

    @Column(name = "updated_by")
    @LastModifiedBy
    protected Long lastModifiedBy;
}
