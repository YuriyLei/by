package com.yulei.demo.model;

import com.yulei.demo.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by lei.yu on 2016/5/5.
 */
@Entity
@Table(name="permission")
public class Permission extends BaseEntity<Long> implements Serializable{
    @Column
    private String permissionName;
    @Column
    private long roleId;

    public Permission() {
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
