package com.yulei.demo.model;

import com.yulei.demo.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by lei.yu on 2016/5/5.
 */
@Entity
@Table(name="userRole")
public class UserRole extends BaseEntity<Long> implements Serializable{
    @Column
    private long userId;
    @Column
    private long roleId;

    public UserRole() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
