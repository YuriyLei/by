package com.yulei.demo.service.impl;

import com.yulei.demo.model.Permission;
import com.yulei.demo.repository.PermissionRepository;
import com.yulei.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lei.yu on 2016/5/5.
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }
}
