package com.yulei.demo.repository;
import com.yulei.demo.BaseRepository;
import com.yulei.demo.model.Permission;

/**
 * Created by lei.yu on 2016/5/5.
 */
public interface PermissionRepository extends BaseRepository<Permission,Long> {
    //List<Permission> findAllByRoleId(Long id);
}
