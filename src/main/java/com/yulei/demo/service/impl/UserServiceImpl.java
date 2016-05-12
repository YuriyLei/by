package com.yulei.demo.service.impl;

import com.yulei.demo.model.Role;
import com.yulei.demo.model.User;
import com.yulei.demo.repository.RoleRepository;
import com.yulei.demo.repository.UserRepository;
import com.yulei.demo.repository.UserRoleRepository;
import com.yulei.demo.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.yulei.demo.common.BaseEntity.DELETED;
import static com.yulei.demo.common.BaseEntity.UNDELETED;


/**
 * Created by lei.yu on 2016/4/22.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleRepository roleRepository;

    /**
     * 根据用户id获得角色名称的集合
     *
     * @param user
     * @return
     */
    public Set<String> getRolesName(User user) {
        List<Role> roles = getRoleList(user);
        Set<String> set = new HashSet<String>();
        for (Role role : roles) {
            set.add(role.getRoleName());
        }
        return set;
    }

    /**
     * 根据用户获得角色列表
     *
     * @param user
     * @return List<Role>
     */
    public List<Role> getRoleList(User user) {
        List<Long> roleId = userRoleRepository.findRoleIdByUserId(user.getId());
        List<Role> roleList = new ArrayList<Role>();
        for (long id : roleId) {
            roleList.add(roleRepository.findOne(id));
        }
        return roleList;
    }

    /**
     * 添加用户，初始密码为编号
     *
     * @param user
     * @return
     */
    public User addUser(User user) {
        user.setPassword(new Md5Hash(user.getPassword(), user.getUserCode(), 2).toHex());
        return userRepository.save(user);
    }

    /**
     * 获得用户列表
     *
     * @param current
     * @param rowCount
     * @param searchPhrase
     * @return
     */
    @Transactional
    public Map<String, Object> getUserList(String deleted, int current, int rowCount, String searchPhrase) {
        List<User> userList = userRepository.findAllByDeleted(deleted, (current - 1) * rowCount, rowCount, searchPhrase);
        int total = userRepository.countNotDelete(deleted, searchPhrase);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("current", current);
        map.put("rowCount", rowCount);
        map.put("rows", userList);
        map.put("total", total);
        return map;
    }

    /**
     * 删除用户
     *
     * @param id
     * @param id1
     * @return
     */
    @Transactional
    public User deleteUser(Long id, Long id1) {
        User user = userRepository.findOne(id);
        if (user == null) {
            return user;
        }
        user.setUpdatedBy(id1);
        user.setUpdatedAt(new Date());
        user.setDeleted(DELETED);
        return userRepository.saveAndFlush(user);
    }
}
