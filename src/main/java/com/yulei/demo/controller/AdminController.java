package com.yulei.demo.controller;

import com.yulei.demo.model.Activity;
import com.yulei.demo.model.Image;
import com.yulei.demo.model.Important;
import com.yulei.demo.model.Notice;
import com.yulei.demo.repository.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.yulei.demo.common.BaseEntity.UNDELETED;

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
    @Autowired
    private SectorRepository sectorRepository;
@Autowired
private ImageRepository imageRepository;
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
        List<Image> carouselList= imageRepository.findCarouselTopFive();
        List<Image> imageList= imageRepository.findImageTopTen();
        model.addAttribute("noticeList",noticesList);
        model.addAttribute("activityList",activityList);
        model.addAttribute("importantList",importantList);
        model.addAttribute("carouselList",carouselList);
        model.addAttribute("imageList",imageList);
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

    /**
     * 进入用户列表页面
     * @return
     */
    @RequestMapping(value="/userL")
    public String userL(){
        return "/admin/userList";
    }

    /**
     * 进入添加用户页面
     * @return
     */
    @RequiresPermissions("user:addUser")
    @RequestMapping(value="/addUserHtml")
    public String addUserHtml(Model model){
        model.addAttribute("sectorList",sectorRepository.findAllByDeleted(UNDELETED));
        return "/admin/addUserHtml";
    }
    /**
     * 进入添加角色页面
     * @return
     */
    @RequestMapping(value="/addRoleHtml")
    public String addRoleHtml(){
        return "/admin/addRole";
    }
    /**
     * 进入角色列表页面
     * @return
     */
    @RequestMapping(value="/roleListHtml")
    public String roleList(){
        return "/admin/roleList";
    }

    @RequiresPermissions("sector:addSector")
    @RequestMapping("addSectorHtml")
    public String toAddSector(){
        return "/admin/addSector";
    }
}
