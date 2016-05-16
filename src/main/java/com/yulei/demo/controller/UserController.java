package com.yulei.demo.controller;

import com.yulei.demo.common.Result;
import com.yulei.demo.model.User;
import com.yulei.demo.repository.UserRepository;
import com.yulei.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static com.yulei.demo.common.BaseEntity.UNDELETED;
import static com.yulei.demo.controller.ShiroController.getSession;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(ShiroController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Result result;
    /**
     * 进入编辑用户页面
     * @param id
     * @return
     */
    @RequiresPermissions("user:edit")
    @RequestMapping(value="editHtml/{id}")
    public String edit(@PathVariable Long id,Model model){
        logger.info("------进入用户信息修改-------");
        model.addAttribute("user",userRepository.findOne(id));
        return "/admin/changeUserInfo";
    }

    /**
     * 获取用户列表
     * @return Json
     */
    @RequiresPermissions("user:look")
    @RequestMapping("userList")
    @ResponseBody
    public Map<String, Object> getUserList(int current,int rowCount,String searchPhrase){

        if(searchPhrase==null || searchPhrase==""){
            searchPhrase = "%%";
        }else{
            searchPhrase = "%"+searchPhrase+"%";
        }
        return userService.getUserList(UNDELETED,current,rowCount,searchPhrase);
    }

    /**
     * 个人信息,需要用户登录
     * @return
     */
    @RequestMapping("selfInfo")
    public String gerSelfInfo(Model model){
        Subject currentUser = SecurityUtils.getSubject();

        Session session = currentUser.getSession();
        if(session==null){
            return "/login";
        }
        User user = (User) session.getAttribute("user");
        user = userRepository.findOne(user.getId());
        user.setPassword(null);
        model.addAttribute("user",user);
        return "/admin/selfInfo";
    }
    @RequiresPermissions("user:look")
    @RequestMapping("/userDetail/{id}")
    public String getUserDetailInfo(@PathVariable Long id,Model model){
        User user = userRepository.findOne(id);
        user.setPassword(null);
        model.addAttribute("user",user);
        return "/admin/selfInfo";
    }
    /**
     * 添加用户
     * @return
     */
    @RequiresPermissions("user:addUser")
    @RequestMapping("addUser")
    @ResponseBody
    public Result addUser(User user){
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        if(session.getAttribute("user") == null){
            result.setStatus(0);
            return result;
        }
        user.setCreatedBy((((User) session.getAttribute("user")).getId()));
        user.setCreatedAt(new Date());
        user.setPortrait("/img/portrait/default.png");
        user = userService.addUser(user);
        if(user!=null)
            result.setStatus(1);
        return result;
    }
    @RequiresPermissions("user:deleteUser")
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Result deleteUser(@PathVariable Long id){
        result.setStatus(0);
        User user =  userService.deleteUser(id,((User) getSession().getAttribute("user")).getId());
        if(user!=null)
            result.setStatus(1);
        return result;
    }
}
