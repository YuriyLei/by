package com.yulei.demo.controller;

import com.yulei.demo.model.Activity;
import com.yulei.demo.model.Important;
import com.yulei.demo.model.Notice;
import com.yulei.demo.repository.ActivityRepository;
import com.yulei.demo.repository.ImportantRepository;
import com.yulei.demo.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private ImportantRepository importantRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @RequestMapping(value = "/home")
    public String home(Model model){
        List<Notice> noticesList= noticeRepository.findTopTen();
        List<Important> importantList= importantRepository.findTopTen();
        List<Activity> activityList= activityRepository.findTopTen();
        model.addAttribute("noticeList",noticesList);
        model.addAttribute("activityList",activityList);
        model.addAttribute("importantList",importantList);
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
    @RequestMapping(value = "/upNo")
    public String upNo(){
        return "admin/uploadNotice";
    }
    @RequestMapping(value = "/upAc")
    public String upAc(){
        return "admin/uploadActivity";
    }
    @RequestMapping(value = "/upIm")
    public String upIm(){
        return "admin/uploadImportant";
    }

    @RequestMapping(value = "/testNav")
    public String testNav(){
        return "testNav";
    }
}
