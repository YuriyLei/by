package com.yulei.demo.controller;

import com.yulei.demo.model.Notice;
import com.yulei.demo.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/21.
 */
@Controller
@RequestMapping("/a")
public class LoginController {
    @Autowired
    private NoticeRepository noticeRepository;

    @RequestMapping(value = "/home")
    public String home(Model model){
        List<Notice> noticesList= noticeRepository.findTopTen();
        model.addAttribute("noticeList",noticesList);
        return "index";
    }
    @RequestMapping(value = "/lo")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/no")
    public String addNo(){
        return "admin/ahome";
    }
    @RequestMapping(value = "/upf")
    public String upNo(){
        return "admin/uploadNotice";
    }
}
