package com.yulei.demo.controller;

import com.yulei.demo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Controller
@RequestMapping("college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;
}
