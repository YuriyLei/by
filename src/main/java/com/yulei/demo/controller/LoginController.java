package com.yulei.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lei.yu on 2016/4/21.
 */
@Controller
@RequestMapping("/a")
public class LoginController {
    @RequestMapping(value = "/lo")
    public String login(){
        return "login";
    }
}
