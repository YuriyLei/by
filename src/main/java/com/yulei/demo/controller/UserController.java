package com.yulei.demo.controller;

import com.yulei.demo.model.User;
import com.yulei.demo.repository.UserRepository;
import com.yulei.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    /**
     * 编辑用户页面
     * @param id
     * @return
     */
    @RequestMapping(value="edit/{id}")
    @ResponseBody
    public String edit(@PathVariable Long id){
        logger.info("------进入用户信息修改-------");
        return "你有权限";
    }

    /**
     * 获取用户列表
     * @param model
     * @return Json
     */
    @RequestMapping("userList")
    @ResponseBody
    public List<User> getUserList(Model model){
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userRepository.findAll());
        return userList;
    }

    /**
     * 个人信息
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
}
