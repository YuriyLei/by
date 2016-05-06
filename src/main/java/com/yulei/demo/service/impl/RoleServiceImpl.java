package com.yulei.demo.service.impl;

import com.yulei.demo.model.Permission;
import com.yulei.demo.model.Role;
import com.yulei.demo.repository.PermissionRepository;
import com.yulei.demo.repository.RoleRepository;
import com.yulei.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by lei.yu on 2016/5/5.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    public Collection<String> getPermissionsName(Role role) {
        List<String> list = new ArrayList<String>();
        List<Permission> perlist = getPermissionList(role);
        for (Permission per : perlist) {
            list.add(per.getPermissionName());
        }
        return list;
    }

    public List<Permission> getPermissionList(Role role){
        List<Permission> perlist = permissionRepository.findAllByRoleId(role.getId());
        return perlist;
    }
}
