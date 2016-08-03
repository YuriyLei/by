package com.yulei.demo;

import com.yulei.demo.model.Role;

import java.util.Collection;

/**
 * Created by lei.yu on 2016/5/5.
 */
public interface RoleService {

    Collection<String> getPermissionsName(Role role);

    Role updateRoleByDeleted(Long id, Long user, String undeleted);
}
