package com.yulei.demo.controller;

import com.yulei.demo.common.Result;
import com.yulei.demo.model.Role;
import com.yulei.demo.repository.RoleRepository;
import com.yulei.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.yulei.demo.common.BaseEntity.UNDELETED;

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
    @RequestMapping("roleList")
    @ResponseBody
    public Map<String,Object> roleList(int current,int rowCount){
        int total  = roleRepository.countNotDelete();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("current",current);
        map.put("rowCount",rowCount);
        map.put("rows",roleRepository.findAllByDeleted(UNDELETED));
        map.put("total",total);
        return map;
    }

    @RequestMapping("addRole")
    @ResponseBody
    public Result roleList(Role role){
        if(roleRepository.save(role)!=null)
            result.setStatus(1);
        result.setStatus(0);
        return result;
    }
}
