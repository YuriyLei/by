package com.yulei.demo.controller;

import com.yulei.demo.RoleService;
import com.yulei.demo.config.Result;
import com.yulei.demo.model.Role;
import com.yulei.demo.model.User;
import com.yulei.demo.repository.RoleRepository;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static com.yulei.demo.BaseEntity.DELETED;
import static com.yulei.demo.BaseEntity.UNDELETED;
import static com.yulei.demo.controller.ShiroController.getSession;

/**
 * Created by lei.yu on 2016/5/10.
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private Result result;

    /**
     * 获得角色列表
     * @param current
     * @param rowCount
     * @return
     */
    @RequiresPermissions("role:look")
    @RequestMapping("roleList")
    @ResponseBody
    public Map<String, Object> roleList(int current, int rowCount) {
        int total = roleRepository.countNotDelete();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("current", current);
        map.put("rowCount", rowCount);
        map.put("rows", roleRepository.findAllByDeleted(UNDELETED));
        map.put("total", total);
        return map;
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequiresPermissions("role:addRole")
    @RequestMapping("addRole")
    @ResponseBody
    public Result roleList(Role role) {
        if (roleRepository.save(role) != null)
            result.setStatus(1);
        result.setStatus(0);
        return result;
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @RequiresPermissions("role:deleteRole")
    @RequestMapping("deleteRole/{id}")
    @ResponseBody
    public Result deleteRole(@PathVariable Long id){
        result.setStatus(0);
        Role role =  roleService.updateRoleByDeleted(id,((User) getSession().getAttribute("user")).getId(),DELETED);
        if(role!=null)
            result.setStatus(1);
        return result;
    }
}
