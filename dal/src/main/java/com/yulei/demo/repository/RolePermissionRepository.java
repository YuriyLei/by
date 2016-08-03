package com.yulei.demo.repository;

import com.yulei.demo.BaseRepository;
import com.yulei.demo.model.RolePermission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lei.yu on 2016/5/13.
 */
public interface RolePermissionRepository extends BaseRepository<RolePermission,Long> {
    @Query(value = "select rp.permissionId from RolePermission rp where rp.roleId = :roleId")
    List<Long> findPermissionIdByRoleId(@Param("roleId") Long id);
}
