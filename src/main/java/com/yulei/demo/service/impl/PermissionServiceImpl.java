package com.yulei.demo.service.impl;

import com.yulei.demo.model.Permission;
import com.yulei.demo.repository.PermissionRepository;
import com.yulei.demo.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log= LoggerFactory.getLogger(PermissionServiceImpl.class);

    public void reCreateFilterChains() {

    }
}
