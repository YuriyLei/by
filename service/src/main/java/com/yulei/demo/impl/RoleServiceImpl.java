package com.yulei.demo.impl;

import com.yulei.demo.RoleService;
import com.yulei.demo.model.Permission;
import com.yulei.demo.model.Role;
import com.yulei.demo.repository.PermissionRepository;
import com.yulei.demo.repository.RolePermissionRepository;
import com.yulei.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by lei.yu on 2016/5/5.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;
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

    public Role updateRoleByDeleted(Long id, Long user, String deleted) {
        Role role = roleRepository.findOne(id);
        if(role==null){
            return role;
        }
        role.setUpdatedBy(user);
        role.setDeleted(deleted);
        role.setUpdatedAt(new Date());
        return roleRepository.saveAndFlush(role);
    }

    public List<Permission> getPermissionList(Role role){
        List<Long> permissionIdlist = rolePermissionRepository.findPermissionIdByRoleId(role.getId());
        List<Permission> permissionList = new ArrayList<Permission>();
        for(Long id:permissionIdlist){
            permissionList.add(permissionRepository.findOne(id));
        }
        return permissionList;
    }
}
