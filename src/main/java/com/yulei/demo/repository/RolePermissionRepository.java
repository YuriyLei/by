package com.yulei.demo.repository;

import com.yulei.demo.common.BaseRepository;
import com.yulei.demo.model.Permission;
import com.yulei.demo.model.RolePermission;

import java.util.List;

/**
 * Created by lei.yu on 2016/5/13.
 */
public interface RolePermissionRepository extends BaseRepository<RolePermission,Long> {
    List<Permission> findAllByRoleId(Long id);
}
