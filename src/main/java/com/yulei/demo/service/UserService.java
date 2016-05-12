package com.yulei.demo.service;


import com.yulei.demo.model.Role;
import com.yulei.demo.model.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lei.yu on 2016/4/22.
 */

public interface UserService {

    Set<String> getRolesName(User user);

    List<Role> getRoleList(User user);

    User addUser(User user);

    Map<String,Object> getUserList(String deleted,int current, int rowCount, String searchPhrase);

    User deleteUser(Long id, Long id1);
}
