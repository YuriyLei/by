package com.yulei.demo.controller;

import com.yulei.demo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Controller
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
}
