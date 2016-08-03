package com.yulei.demo.controller;

import com.yulei.demo.PermissionService;
import com.yulei.demo.repository.PermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lei.yu on 2016/5/16.
 */
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private PermissionRepository permissionRepository;
}
