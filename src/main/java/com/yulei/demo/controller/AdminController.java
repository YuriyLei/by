package com.yulei.demo.controller;

import com.yulei.demo.model.Activity;
import com.yulei.demo.model.Important;
import com.yulei.demo.model.Notice;
import com.yulei.demo.repository.ActivityRepository;
import com.yulei.demo.repository.ImportantRepository;
import com.yulei.demo.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by lei.yu on 2016/4/21.
 */
@Controller
public class AdminController {
    @Autowired
    private NoticeRepository noticeRepository;
    @Autowired
    private ImportantRepository importantRepository;
    @Autowired
    private ActivityRepository activityRepository;

    /**
     * 进入系统前台首页
     * @param model
     * @return
     */
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

    /**
     * 进入系统后台首页
     * @return
     */
    @RequestMapping(value = "/ahome")
    public String ax(){
        return "/adminAx/index";
    }

    /**
     * 进入添加新闻页面
     * @return
     */
    @RequestMapping(value = "/addNews")
    public String addNo(){
        return "/admin/addNews";
    }

    /**
     * 进入上传通知公告页面
     * @return
     */
    @RequestMapping(value = "/upNo")
    public String upNo(){
        return "/admin/uploadNotice";
    }

    /**
     * 进入上传学生活动页面
     * @return
     */
    @RequestMapping(value = "/upAc")
    public String upAc(){
        return "/admin/uploadActivity";
    }

    /**
     * 进入上传学院新闻页面
     * @return
     */
    @RequestMapping(value = "/upIm")
    public String upIm(){
        return "/admin/uploadImportant";
    }

    @RequestMapping(value="/userL")
    public String userL(){
        return "/admin/userList";
    }
    @RequestMapping(value="/addUserHtml")
    public String addUserHtml(){
        return "/admin/addUserHtml";
    }
}
