package com.yulei.demo.service.impl;

import com.yulei.demo.model.Role;
import com.yulei.demo.model.User;
import com.yulei.demo.repository.RoleRepository;
import com.yulei.demo.repository.UserRepository;
import com.yulei.demo.repository.UserRoleRepository;
import com.yulei.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepositoy;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleRepository roleRepository;
    public Set<String> getRolesName(User user) {
        List<Role> roles = getRoleList(user);
        Set<String> set = new HashSet<String>();
        for (Role role : roles) {
            set.add(role.getRoleName());
        }
        return set;
    }

    public List<Role> getRoleList(User user) {
        List<Long> roleId = userRoleRepository.findRoleIdByUserId(user.getId());
        List<Role> roleList =new ArrayList<Role>();
        for(long id : roleId){
            roleList.add(roleRepository.findOne(id));
        }
        return roleList;
    }
}
