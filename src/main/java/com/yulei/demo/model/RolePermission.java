package com.yulei.demo.model;

import com.yulei.demo.common.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by lei.yu on 2016/5/13.
 */
@Table(name = "rolePermission")
@Entity
public class RolePermission extends BaseEntity<Long> implements Serializable{
    @Column
    private Long roleId;
    @Column
    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
